package me.josh.cubits.cubitentity;

import me.josh.cubits.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class WolfTeleportRadius extends BukkitRunnable {

    private final Main plugin;

    public WolfTeleportRadius(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (Entity entity : player.getWorld().getEntities()) {
                if (entity instanceof Wolf) {
                    Wolf wolf = (Wolf) entity;
                    if (wolf.isTamed() && wolf.getOwner() == player && wolf.getPersistentDataContainer().has(new NamespacedKey(plugin, "cubitUUID"), PersistentDataType.STRING)) {
                        double distance = wolf.getLocation().distance(player.getLocation());
                        if (distance > 50.0) {
                            // You can customize however you want the teleport to be.
                            wolf.teleport(player.getLocation().subtract(player.getEyeLocation().getDirection().multiply(2)));
                        }
                    }
                }
            }
        }
    }

}
