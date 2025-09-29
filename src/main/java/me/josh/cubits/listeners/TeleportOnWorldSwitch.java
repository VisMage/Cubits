package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class TeleportOnWorldSwitch implements Listener {
    private final Main plugin;

    public TeleportOnWorldSwitch(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWorldSwitch(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        //Check if player has cubit equipped
        if (plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).getActiveCubitEntity() == null){
            return;
        }

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        //Despawn cubit
        //Check if player has cubit equipped
        if (playerProfile.getActiveCubitEntity().getCubit() != null){

            //Despawn cubit
            playerProfile.getActiveCubitEntity().DespawnCubit();
        }

    }

}

