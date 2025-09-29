package me.josh.cubits.cubitentity;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

public class Animator {

    private final Main plugin;

    public Animator(Main plugin) {
        this.plugin = plugin;
    }


    //Register a ticker
    static int ticker = 0;

    public void runGlobalAnimation() {

        //Calculate the next tick location
        double bonusY;
        if (ticker > 20) {
            bonusY = (double) -(ticker - 40) / 100;
            if (ticker > 40) ticker = 0;
        } else {
            bonusY = (double) ticker / 100;
        }
        ticker++;

        NamespacedKey key = new NamespacedKey(plugin, "cubitUUID");

        //Teleport armorstands
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
            if (playerProfile == null){
                continue;
            }
            if (!playerProfile.getActiveCubitEntity().isActive()){
                continue;
            }

            Wolf wolf = playerProfile.getActiveCubitEntity().getWolf();
            ArmorStand armorStand = playerProfile.getActiveCubitEntity().getArmorStand();
            player.getWorld().spawnParticle(Particle.DUST, wolf.getLocation().add(0, 0.8, 0), 15, 0, 0, 0, 0, new Particle.DustOptions(Color.AQUA, 1.4F));

            if (playerProfile.getActiveCubitEntity().getCubit().getShiny() == 1){
                player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, wolf.getLocation().add(0, 1.0, 0), 6, 0, 0.5, 0.5, 0.5);

            }

            armorStand.teleport(wolf.getLocation().add(0, -0.5 + bonusY, 0));
            wolf.setTarget(null);

        }




//        for (Player player : Bukkit.getOnlinePlayers()) {
//            for (Entity entity : player.getWorld().getEntities()) {
//                if (entity instanceof Wolf) {
//                    Wolf wolf = (Wolf) entity;
//                    if (wolf.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
//
//                        // Cubit particle trail
//                        // Add in special particles based on the Cubit species
//                        World world = wolf.getWorld();
//                        Location loc = wolf.getLocation();
//                        world.spawnParticle(Particle.DUST, loc.add(0, 0.8, 0), 15, 0, 0, 0, 0, new Particle.DustOptions(Color.AQUA, 1.4F));
//
//                        for (Entity entity2 : player.getWorld().getEntities()) {
//                            if (entity2 instanceof ArmorStand) {
//                                ArmorStand armorStand = (ArmorStand) entity2;
//                                if (armorStand.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
//                                    armorStand.teleport(wolf.getLocation().add(0, -0.5 + bonusY, 0));
//
//                                }
//                            }
//                        }
//
//                        wolf.setTarget(null);
//
//                    }
//                }
//            }
//        }



    }


}
