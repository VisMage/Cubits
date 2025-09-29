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

            if (killer instanceof Player){
                EntityType slayerMob = playerProfile.getSlayerMob();
                EntityType killedMob = entity.getType();
                if(playerProfile.getSlayerMob() != null) {
                if (killedMob == slayerMob){
                    SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                    playerProfile.addPlayerVariables(PlayerVariables.SLAYER_AMOUNT, 1);
                }
            }
            }

            // End of Mobs Killed Event
        }
    }



}
