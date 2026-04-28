package me.josh.cubits.treasuretracker;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public final class TreasureTrackingManager implements Listener, CommandExecutor {

    private static final String TREASURES_CONFIG_PATH = "treasure-tracking.treasures";

    private static final double PARTICLE_DISTANCE = 5.0;
    private static final double PARTICLE_DISTANCE_SQUARED = PARTICLE_DISTANCE * PARTICLE_DISTANCE;

    private final Main plugin;
    //private final JavaPlugin plugin;
    private final Random random = new Random();

    private final List<Treasure> treasures = new ArrayList<>();
    private final Map<UUID, ActiveTreasure> activeTreasures = new HashMap<>();

    private final NamespacedKey trackingCompassKey;

    private BukkitTask particleTask;

    public TreasureTrackingManager(Main plugin) {
        this.plugin = Objects.requireNonNull(plugin, "plugin");
        this.trackingCompassKey = new NamespacedKey(plugin, "treasure_tracking_compass");
    }

    public void enable() {
        plugin.saveDefaultConfig();

        loadTreasures();

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        PluginCommand command = plugin.getCommand("starttreasuretracking");
        if (command != null) {
            command.setExecutor(this);
        }

        startParticleTask();
    }

    public void shutdown() {
        if (particleTask != null) {
            particleTask.cancel();
            particleTask = null;
        }

        activeTreasures.clear();
    }

    /**
     * Call this from your existing plugin whenever you want a player
     * to begin the Treasure Tracking minigame.
     */
    public void startTreasureTracking(Player player) {
        assignNewTreasure(player, null, true);
    }

    public boolean hasActiveTreasure(Player player) {
        return activeTreasures.containsKey(player.getUniqueId());
    }

    public Optional<String> getCurrentTreasureHint(Player player) {
        ActiveTreasure activeTreasure = activeTreasures.get(player.getUniqueId());

        if (activeTreasure == null) {
            return Optional.empty();
        }

        return Optional.of(activeTreasure.treasure().hint());
    }

    public boolean giveCurrentTreasureCompass(Player player) {
        ActiveTreasure activeTreasure = activeTreasures.get(player.getUniqueId());

        if (activeTreasure == null) {
            player.sendMessage(ChatColor.RED + "You are not currently tracking a treasure.");
            return false;
        }

        ArmorStand armorStand = findArmorStandById(activeTreasure.armorStandId());

        ActiveTreasure compassTreasure = activeTreasure;

        // If the armor stand is currently loaded, refresh the compass target
        // to the armor stand's current location.
        if (armorStand != null) {
            compassTreasure = new ActiveTreasure(
                    activeTreasure.treasure(),
                    activeTreasure.armorStandId(),
                    armorStand.getLocation().clone()
            );

            activeTreasures.put(player.getUniqueId(), compassTreasure);
        }

        // Removes any old Treasure Tracker compasses still in their inventory,
        // then gives them one fresh compass for their current treasure.
        removeTrackingCompasses(player);
        giveTrackingCompass(player, compassTreasure);

        player.sendMessage(ChatColor.GOLD + "You received a replacement Treasure Tracker.");
        player.sendMessage(ChatColor.YELLOW + "Hint: " + compassTreasure.treasure().hint());

        return true;
    }

    /**
     * Useful if your existing plugin has a reload command.
     */
    public void reloadTreasures() {
        treasures.clear();
        loadTreasures();
    }

    private void loadTreasures() {
        treasures.clear();

        for (Map<?, ?> treasureMap : plugin.getConfig().getMapList(TREASURES_CONFIG_PATH)) {
            Object tagObject = treasureMap.get("tag");
            Object hintObject = treasureMap.get("hint");

            if (tagObject == null || hintObject == null) {
                continue;
            }

            String tag = tagObject.toString();
            String hint = hintObject.toString();

            if (!tag.isBlank() && !hint.isBlank()) {
                treasures.add(new Treasure(tag, hint));
            }
        }

        if (treasures.isEmpty()) {
            plugin.getLogger().warning("No Treasure Tracking treasures were loaded from config path: " + TREASURES_CONFIG_PATH);
        }
    }

    private boolean assignNewTreasure(Player player, String tagToAvoid, boolean firstTreasure) {
        TreasurePick pick = pickRandomAvailableTreasure(tagToAvoid);

        if (pick == null) {
            player.sendMessage(ChatColor.RED + "No treasure armor stands are available right now.");
            return false;
        }

        removeTrackingCompasses(player);

        Location targetLocation = pick.armorStand().getLocation().clone();

        ActiveTreasure activeTreasure = new ActiveTreasure(
                pick.treasure(),
                pick.armorStand().getUniqueId(),
                targetLocation
        );

        activeTreasures.put(player.getUniqueId(), activeTreasure);
        giveTrackingCompass(player, activeTreasure);

        if (firstTreasure) {
            player.sendMessage(ChatColor.GOLD + "Treasure Tracking started!");
        } else {
            player.sendMessage(ChatColor.GOLD + "A new treasure has been chosen!");
        }

        player.sendMessage(ChatColor.YELLOW + "Hint: " + pick.treasure().hint());

        return true;
    }

    private TreasurePick pickRandomAvailableTreasure(String tagToAvoid) {
        List<TreasurePick> available = getAvailableTreasures(tagToAvoid);

        // If the only available treasure is the one just found,
        // allow it as a fallback.
        if (available.isEmpty() && tagToAvoid != null) {
            available = getAvailableTreasures(null);
        }

        if (available.isEmpty()) {
            return null;
        }

        return available.get(random.nextInt(available.size()));
    }

    private List<TreasurePick> getAvailableTreasures(String tagToAvoid) {
        List<TreasurePick> available = new ArrayList<>();

        for (Treasure treasure : treasures) {
            if (tagToAvoid != null && treasures.size() > 1 && treasure.tag().equals(tagToAvoid)) {
                continue;
            }

            ArmorStand armorStand = findTreasureArmorStand(treasure.tag());

            if (armorStand != null) {
                available.add(new TreasurePick(treasure, armorStand));
            }
        }

        return available;
    }

    public void giveTrackingCompass(Player player, ActiveTreasure activeTreasure) {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta rawMeta = compass.getItemMeta();

        if (!(rawMeta instanceof CompassMeta meta)) {
            player.sendMessage(ChatColor.RED + "Could not create a tracking compass.");
            return;
        }

        meta.setDisplayName(ChatColor.GOLD + "Treasure Tracker");
        meta.setLore(List.of(
                ChatColor.YELLOW + activeTreasure.treasure().hint(),
                ChatColor.GRAY + "Right-click to ping the treasure."
        ));

        meta.setLodestone(activeTreasure.targetLocation());
        meta.setLodestoneTracked(false);

        meta.getPersistentDataContainer().set(
                trackingCompassKey,
                PersistentDataType.STRING,
                activeTreasure.treasure().tag()
        );

        compass.setItemMeta(meta);

        Map<Integer, ItemStack> leftovers = player.getInventory().addItem(compass);

        for (ItemStack leftover : leftovers.values()) {
            player.getWorld().dropItemNaturally(player.getLocation(), leftover);
        }
    }

    private void removeTrackingCompasses(Player player) {
        PlayerInventory inventory = player.getInventory();

        for (int slot = 0; slot < inventory.getSize(); slot++) {
            ItemStack item = inventory.getItem(slot);

            if (isTrackingCompass(item)) {
                inventory.setItem(slot, null);
            }
        }

        if (isTrackingCompass(inventory.getItemInOffHand())) {
            inventory.setItemInOffHand(null);
        }
    }

    private boolean isTrackingCompass(ItemStack item) {
        return getTrackingCompassTag(item) != null;
    }

    private String getTrackingCompassTag(ItemStack item) {
        if (item == null || item.getType() != Material.COMPASS || !item.hasItemMeta()) {
            return null;
        }

        ItemMeta meta = item.getItemMeta();

        return meta.getPersistentDataContainer().get(
                trackingCompassKey,
                PersistentDataType.STRING
        );
    }

    private void startParticleTask() {
        if (particleTask != null) {
            particleTask.cancel();
        }

        particleTask = Bukkit.getScheduler().runTaskTimer(
                plugin,
                this::showNearbyTreasureParticles,
                0L,
                10L
        );
    }

    private void showNearbyTreasureParticles() {
        for (Map.Entry<UUID, ActiveTreasure> entry : activeTreasures.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());

            if (player == null || !player.isOnline()) {
                continue;
            }

            ActiveTreasure activeTreasure = entry.getValue();
            ArmorStand armorStand = findArmorStandById(activeTreasure.armorStandId());

            if (armorStand == null) {
                continue;
            }

            Location playerLocation = player.getLocation();
            Location treasureLocation = armorStand.getLocation();

            if (!isSameWorld(playerLocation, treasureLocation)) {
                continue;
            }

            if (playerLocation.distanceSquared(treasureLocation) <= PARTICLE_DISTANCE_SQUARED) {
                Location particleLocation = treasureLocation.clone().add(0, 1.0, 0);

                player.spawnParticle(
                        Particle.END_ROD,
                        particleLocation,
                        20,
                        0.35,
                        0.45,
                        0.35,
                        0.02
                );
            }
        }
    }

    @EventHandler
    public void onTreasureRightClick(PlayerInteractAtEntityEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        if (!(event.getRightClicked() instanceof ArmorStand armorStand)) {
            return;
        }

        Treasure clickedTreasure = getTreasureForArmorStand(armorStand);

        if (clickedTreasure == null) {
            return;
        }

        // Prevent players from putting items on or taking items from the treasure armor stand.
        event.setCancelled(true);

        Player player = event.getPlayer();
        ActiveTreasure activeTreasure = activeTreasures.get(player.getUniqueId());

        if (activeTreasure == null) {
            player.sendMessage(ChatColor.GRAY + "This looks like a treasure, but you are not tracking one right now.");
            return;
        }

        if (!armorStand.getUniqueId().equals(activeTreasure.armorStandId())) {
            player.sendMessage(ChatColor.RED + "This is not the treasure your compass is tracking.");
            return;
        }

        if (!clickedTreasure.tag().equals(activeTreasure.treasure().tag())) {
            player.sendMessage(ChatColor.RED + "This is not the treasure your compass is tracking.");
            return;
        }

        removeTrackingCompasses(player);
        activeTreasures.remove(player.getUniqueId());

        player.sendMessage(ChatColor.GREEN + "You found the treasure!");
        player.playSound(
                player.getLocation(),
                Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
                SoundCategory.PLAYERS,
                1.0f,
                1.3f
        );

        // 3/4 chance to continue.
        // 1/4 chance to end with congratulations.

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (playerProfile.getTreasureTrackerStep() == 5) {
            player.sendMessage(ChatColor.GOLD + "Congratulations! You completed the treasure trail!");
            playerProfile.setTreasureTrackerStep(0);
            playerProfile.addPlayerVariables(PlayerVariables.TREASURE_TRACKER_COMPLETED, 1);
            player.playSound(
                    player.getLocation(),
                    Sound.BLOCK_BEACON_POWER_SELECT,
                    SoundCategory.PLAYERS,
                    1.0f,
                    1.7f
            );
        } else if (random.nextInt(4) < 3 || playerProfile.getTreasureTrackerStep() < 2) {
                playerProfile.setTreasureTrackerStep(playerProfile.getTreasureTrackerStep() + 1);
                boolean startedNewTreasure = assignNewTreasure(
                        player,
                        activeTreasure.treasure().tag(),
                        false
                );

                if (!startedNewTreasure) {
                    player.sendMessage(ChatColor.GOLD + "No more treasures are available. Congratulations!");
                    playerProfile.setTreasureTrackerStep(0);
                    playerProfile.addPlayerVariables(PlayerVariables.TREASURE_TRACKER_COMPLETED, 1);
                    player.playSound(
                            player.getLocation(),
                            Sound.BLOCK_BEACON_POWER_SELECT,
                            SoundCategory.PLAYERS,
                            1.0f,
                            1.5f
                    );
                }
            } else {
                player.sendMessage(ChatColor.GOLD + "Congratulations! You completed the treasure trail!");
                playerProfile.setTreasureTrackerStep(0);
            playerProfile.addPlayerVariables(PlayerVariables.TREASURE_TRACKER_COMPLETED, 1);
                player.playSound(
                        player.getLocation(),
                        Sound.BLOCK_BEACON_POWER_SELECT,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.7f
                );
            }



    }

    @EventHandler
    public void onCompassRightClick(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        Action action = event.getAction();

        if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemStack item = event.getItem();
        String compassTreasureTag = getTrackingCompassTag(item);

        if (compassTreasureTag == null) {
            return;
        }

        event.setCancelled(true);

        Player player = event.getPlayer();
        ActiveTreasure activeTreasure = activeTreasures.get(player.getUniqueId());

        if (activeTreasure == null || !activeTreasure.treasure().tag().equals(compassTreasureTag)) {
            removeTrackingCompasses(player);
            player.sendMessage(ChatColor.RED + "That treasure tracker is no longer active.");
            return;
        }

        Location targetLocation = getCurrentTargetLocation(activeTreasure);

        if (!isSameWorld(player.getLocation(), targetLocation)) {
            player.sendMessage(ChatColor.RED + "The tracker hums strangely. The treasure is in another world.");
            player.playSound(
                    player.getLocation(),
                    Sound.BLOCK_NOTE_BLOCK_BASEDRUM,
                    SoundCategory.PLAYERS,
                    1.0f,
                    0.5f
            );
            return;
        }

        double distance = player.getLocation().distance(targetLocation);
        playDistancePing(player, distance);
    }

    private void playDistancePing(Player player, double distance) {
        Sound sound;
        float pitch;
        String message;

        if (distance <= 5) {
            sound = Sound.BLOCK_BEACON_POWER_SELECT;
            pitch = 1.8f;
            message = ChatColor.GREEN + "The treasure is right here!";
        } else if (distance <= 15) {
            sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
            pitch = 1.6f;
            message = ChatColor.GREEN + "The tracker rings loudly. Very close.";
        } else if (distance <= 30) {
            sound = Sound.BLOCK_NOTE_BLOCK_PLING;
            pitch = 1.4f;
            message = ChatColor.YELLOW + "The tracker gives a clear ping. Close.";
        } else if (distance <= 60) {
            sound = Sound.BLOCK_NOTE_BLOCK_CHIME;
            pitch = 1.0f;
            message = ChatColor.YELLOW + "The tracker chimes softly. Getting warmer.";
        } else if (distance <= 100) {
            sound = Sound.BLOCK_NOTE_BLOCK_BELL;
            pitch = 0.8f;
            message = ChatColor.GRAY + "The tracker gives a distant ring.";
        } else {
            sound = Sound.BLOCK_NOTE_BLOCK_BASS;
            pitch = 0.5f;
            message = ChatColor.DARK_GRAY + "The tracker gives a low, faint thud. Far away.";
        }

        player.playSound(player.getLocation(), sound, SoundCategory.PLAYERS, 1.0f, pitch);
        player.sendMessage(message + ChatColor.GRAY + " [" + formatDistance(distance) + " blocks]");
    }

    private Location getCurrentTargetLocation(ActiveTreasure activeTreasure) {
        ArmorStand armorStand = findArmorStandById(activeTreasure.armorStandId());

        if (armorStand != null) {
            return armorStand.getLocation().clone();
        }

        return activeTreasure.targetLocation().clone();
    }

    private ArmorStand findTreasureArmorStand(String tag) {
        for (World world : Bukkit.getWorlds()) {
            for (ArmorStand armorStand : world.getEntitiesByClass(ArmorStand.class)) {
                if (armorStand.getScoreboardTags().contains(tag)) {
                    return armorStand;
                }
            }
        }

        return null;
    }

    private ArmorStand findArmorStandById(UUID armorStandId) {
        for (World world : Bukkit.getWorlds()) {
            for (ArmorStand armorStand : world.getEntitiesByClass(ArmorStand.class)) {
                if (armorStand.getUniqueId().equals(armorStandId)) {
                    return armorStand;
                }
            }
        }

        return null;
    }

    private Treasure getTreasureForArmorStand(ArmorStand armorStand) {
        for (Treasure treasure : treasures) {
            if (armorStand.getScoreboardTags().contains(treasure.tag())) {
                return treasure;
            }
        }

        return null;
    }

    private boolean isSameWorld(Location first, Location second) {
        return first.getWorld() != null
                && second.getWorld() != null
                && first.getWorld().equals(second.getWorld());
    }

    private String formatDistance(double distance) {
        return String.format(Locale.US, "%.1f", distance);
    }

    /**
     * Optional command hook.
     *
     * This only works if your plugin.yml contains the starttreasuretracking command.
     * If you do not want this command, remove "implements CommandExecutor",
     * remove enable()'s command registration, and remove this method.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can start Treasure Tracking.");
            return true;
        }

        startTreasureTracking(player);
        return true;
    }

    private record Treasure(String tag, String hint) {
    }

    private record TreasurePick(Treasure treasure, ArmorStand armorStand) {
    }

    private record ActiveTreasure(Treasure treasure, UUID armorStandId, Location targetLocation) {
    }


}