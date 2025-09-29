package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.persistence.PersistentDataType;

public class ChunkUnloadListener implements Listener {
    private final Main plugin;

    public ChunkUnloadListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent ev) {

        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
            if(playerProfile != null && playerProfile.getActiveCubitEntity().getCubit() != null){
                //System.out.println(playerProfile.getActiveCubit().getWolf().getLocation());

                Wolf wolf = playerProfile.getActiveCubitEntity().getWolf();
                if (wolf.isTamed() && wolf.getOwner() == player && wolf.getPersistentDataContainer().has(new NamespacedKey(plugin, "cubitUUID"), PersistentDataType.STRING)) {
                    double distance = wolf.getLocation().distance(player.getLocation());
                    if (distance > 80.0) {
                        System.out.println(player.getDisplayName() + "'s Cubit is too far away, it has been re-equipped!");
                        playerProfile.getActiveCubitEntity().EquipCubit(plugin, player, playerProfile.getActiveCubitEntity().getCubit());
                    }
                }


            }
        }




    }



}
