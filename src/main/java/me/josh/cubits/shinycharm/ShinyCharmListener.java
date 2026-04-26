package me.josh.cubits.shinycharm;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ShinyCharmListener implements Listener {

    private static final String TAG = "shiny_charm";

    private final Main plugin;
    public ShinyCharmListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onArmorStandRightClick(PlayerInteractAtEntityEvent event) {
        // Prevent the event from firing twice, once for each hand.
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        if (!(event.getRightClicked() instanceof ArmorStand armorStand)) {
            return;
        }

        if (!armorStand.getScoreboardTags().contains(TAG)) {
            return;
        }

        Player player = event.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        // Optional: prevents players from changing the armor stand's items/equipment.
        event.setCancelled(true);

        String armorStandId = armorStand.getUniqueId().toString();
        String path = "clicked-shiny-charms." + armorStandId;

        if (plugin.getConfig().isConfigurationSection(path)) {
            player.sendMessage(ChatColor.GRAY + "You have already found this Shiny Charm.");
            return;
        }

        saveArmorStandLocation(path, armorStand.getLocation());
        plugin.saveConfig();

        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        playerProfile.addPlayerVariables(PlayerVariables.SHINY_CHARMS, 1);
        player.sendMessage(ChatColor.LIGHT_PURPLE + "You found a Shiny Charm! (" + playerProfile.getPlayerVariables().get(PlayerVariables.SHINY_CHARMS) + "/" + plugin.shinyCharmTotal + ")");
    }

    private void saveArmorStandLocation(String path, Location location) {
        plugin.getConfig().set(path + ".world", location.getWorld().getName());
        plugin.getConfig().set(path + ".x", location.getX());
        plugin.getConfig().set(path + ".y", location.getY());
        plugin.getConfig().set(path + ".z", location.getZ());
        plugin.getConfig().set(path + ".yaw", location.getYaw());
        plugin.getConfig().set(path + ".pitch", location.getPitch());
    }
}