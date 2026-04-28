package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    private final Main plugin;
    public JoinLeaveListener(Main plugin) {
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

            //Equip last equipped cubit
            if(playerProfile.getLastEquippedCubit() != null){
                playerProfile.equipActiveCubit(plugin, player, playerProfile.getLastEquippedCubit());
            }

            //Reset Treasure Tracker Steps
            playerProfile.setTreasureTrackerStep(0);

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

        //Cancel pending trade
        playerProfile.setTradeReady(false);
        //playerProfile.setTradePlayer(null);

        //Reset Treasure Tracker Steps
        playerProfile.setTreasureTrackerStep(0);

    }

}
