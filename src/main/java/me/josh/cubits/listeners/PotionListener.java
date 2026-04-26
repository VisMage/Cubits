package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerUpgrades;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PotionListener implements Listener {

    private final Main plugin;

    public PotionListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        if (e.getEntity().getKiller() != null) {
            Entity killer = e.getEntity().getKiller();
            final Player player = e.getEntity().getKiller();
            PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

            EntityType slayerMob = playerProfile.getSlayerMob();
            EntityType killedMob = entity.getType();


            if (killer instanceof Player){
                if(playerProfile.getSlayerMob() == EntityType.EVOKER) {
                    if (killedMob == EntityType.ENDER_DRAGON || killedMob == EntityType.WITHER || killedMob == EntityType.ELDER_GUARDIAN || killedMob == EntityType.EVOKER || killedMob == EntityType.WARDEN && playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT ) > playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT)){
                        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                        //playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                        return;
                    }
                }

                if(playerProfile.getSlayerMob() == EntityType.SPIDER) {
                    if (killedMob == EntityType.SPIDER || killedMob == EntityType.CAVE_SPIDER && playerProfile.getUpgrades().get(PlayerUpgrades.SLAYER_UPGRADE_SPIDER_SQUASHER) && playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT ) > playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT)){
                        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                        //playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                        return;
                    }
                }

                if(playerProfile.getSlayerMob() != null) {
                    if (killedMob == slayerMob && playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT ) > playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT)){
                        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                        //playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                    }
                }





            }
            // End of Mobs Killed Event
        }
    }



}

