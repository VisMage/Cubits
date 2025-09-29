package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UnequipOnLeave implements Listener {
    private final Main plugin;
    public UnequipOnLeave(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        //Check if player has cubit equipped
        if (playerProfile.getActiveCubitEntity().getCubit() != null){
            Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();

            //Despawn cubit
            playerProfile.getActiveCubitEntity().EquipCubit(plugin, player, cubit);
        }

    }


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {

        Player player = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        //Check if player has cubit equipped
        if (playerProfile.getActiveCubitEntity().getCubit() != null){

            //Despawn cubit
            playerProfile.getActiveCubitEntity().DespawnCubit();
        }

    }

}
