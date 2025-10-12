package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;


public class QuestListener implements Listener {

    private final Main plugin;

    public QuestListener(Main plugin) {
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
                        playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                        return;
                    }
                }

                if(playerProfile.getSlayerMob() == EntityType.SPIDER) {
                    if (killedMob == EntityType.SPIDER || killedMob == EntityType.CAVE_SPIDER && playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_SPIDER_SQUASHER) == 1 && playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT ) > playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT)){
                        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                        playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                        return;
                    }
                }

                if(playerProfile.getSlayerMob() != null) {
                    if (killedMob == slayerMob && playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT ) > playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT)){
                        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                        playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                    }
                }





            }
            // End of Mobs Killed Event
        }
    }



}
