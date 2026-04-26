package me.josh.cubits.shinycharm;

import me.josh.cubits.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ShinyCharmAnimator {

    private static final String TAG = "shiny_charm";
    private static final double RADIUS = 5.0;
    private static final double RADIUS_SQUARED = RADIUS * RADIUS;

    private final Main plugin;
    public ShinyCharmAnimator(Main plugin) {
        this.plugin = plugin;
    }

    //@Override
    public void shinyOnEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    showShinyArmorStands(player);
                }
            }
        }.runTaskTimer(plugin, 0L, 5L); // every 5 ticks
    }

    private void showShinyArmorStands(Player player) {
        Location playerLoc = player.getLocation();

        for (Entity entity : player.getNearbyEntities(RADIUS, RADIUS, RADIUS)) {
            if (!(entity instanceof ArmorStand armorStand)) {
                continue;
            }

            if (!armorStand.getScoreboardTags().contains(TAG)) {
                continue;
            }

            // getNearbyEntities uses a box; this makes it an actual 5-block sphere.
            if (armorStand.getLocation().distanceSquared(playerLoc) > RADIUS_SQUARED) {
                continue;
            }

            Location particleLoc = armorStand.getLocation().add(0, 0.3, 0);

            player.spawnParticle(
                    Particle.END_ROD,
                    particleLoc,
                    3,
                    0.25, 0.25, 0.25,
                    0.02
            );
        }
    }
}