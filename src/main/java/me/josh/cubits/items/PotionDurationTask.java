package me.josh.cubits.items;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class PotionDurationTask extends BukkitRunnable {
    private final Main plugin;
    private final Map<UUID, Integer> activePotionSeconds = new HashMap<>();

    public PotionDurationTask(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if (plugin.getPlayerProfileManager() == null) {
            return;
        }

        Set<UUID> onlinePlayers = new HashSet<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            UUID uuid = player.getUniqueId();
            onlinePlayers.add(uuid);

            PlayerProfile profile = plugin.getPlayerProfileManager().getProfileOf(uuid);

            if (profile == null) {
                continue;
            }

            if (!PotionDurationManager.hasAnyActivePotion(profile)) {
                activePotionSeconds.remove(uuid);
                continue;
            }

            int seconds = activePotionSeconds.getOrDefault(uuid, 0) + 1;

            if (seconds >= 60) {
                List<PlayerVariables> expiredPotions =
                        PotionDurationManager.tickDownOneMinuteAndGetExpired(profile);

                notifyExpiredPotions(player, expiredPotions);

                seconds = 0;
            }

            if (PotionDurationManager.hasAnyActivePotion(profile)) {
                activePotionSeconds.put(uuid, seconds);
            } else {
                activePotionSeconds.remove(uuid);
            }
        }

        activePotionSeconds.keySet().removeIf(uuid -> !onlinePlayers.contains(uuid));
    }


    private void notifyExpiredPotions(Player player, List<PlayerVariables> expiredPotions) {
        if (player == null || expiredPotions == null || expiredPotions.isEmpty()) {
            return;
        }

        if (expiredPotions.size() == 1) {
            String potionName = PotionDurationManager.getPotionDisplayName(expiredPotions.get(0));

            player.sendMessage(
                    ChatColor.RED + "Heads up! "
                            + ChatColor.LIGHT_PURPLE + potionName
                            + ChatColor.RED + " has expired."
            );

            player.sendTitle(
                    ChatColor.RED + "Potion Expired",
                    ChatColor.GRAY + potionName + " has worn off.",
                    10,
                    50,
                    15
            );
        } else {
            StringJoiner potionNames = new StringJoiner(ChatColor.GRAY + ", " + ChatColor.LIGHT_PURPLE);

            for (PlayerVariables expiredPotion : expiredPotions) {
                potionNames.add(PotionDurationManager.getPotionDisplayName(expiredPotion));
            }

            player.sendMessage(
                    ChatColor.RED + "Heads up! These potions have expired: "
                            + ChatColor.LIGHT_PURPLE + potionNames
                            + ChatColor.RED + "."
            );

            String expiredPotionsCount = String.valueOf(expiredPotions.size());
            player.sendTitle(
                    ChatColor.RED + "Potions Expired",
                    ChatColor.GRAY + expiredPotionsCount + " potions have worn off.",
                    10,
                    50,
                    15
            );
        }

        player.playSound(
                player.getLocation(),
                Sound.BLOCK_BEACON_DEACTIVATE,
                1.0F,
                1.0F
        );
    }


}
