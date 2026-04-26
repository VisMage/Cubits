package me.josh.cubits.playerdata;

import me.josh.cubits.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerProfileManager {
    private final Main plugin;
    private List<PlayerProfile> playerProfiles;


    public PlayerProfileManager(Main plugin) {
        this.plugin = plugin;
        playerProfiles = new ArrayList<>();
    }

    public void addPlayerProfile(UUID uuid, Player player) {
        for(int i = 0; i < playerProfiles.size(); i++) {
            if(uuid == playerProfiles.get(i).getUuid())
                return;
        }

        PlayerProfile playerProfile = new PlayerProfile(player);
        playerProfiles.add(playerProfile);
    }

    public PlayerProfile getProfileOf(Player player){
        return getProfileOf(player.getUniqueId());
    }

    public PlayerProfile getProfileOf(UUID uuid) {
        for(int i = 0; i < playerProfiles.size(); i++) {
            if(uuid == playerProfiles.get(i).getUuid())
                return playerProfiles.get(i);
        }

        return null;
    }

    public void unequipCubitsOnDisable(){
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerProfile playerProfile = getProfileOf(player.getUniqueId());
            if (playerProfile == null){
                continue;
            }
            if (!playerProfile.getActiveCubitEntity().isActive()){
                continue;
            }

            playerProfile.getActiveCubitEntity().UnequipCubit();
        }

    }


    public List<PlayerProfile> getPlayerProfiles() {
        return playerProfiles;
    }

    public void setPlayerProfile(List<PlayerProfile> playerProfiles){
        this.playerProfiles = playerProfiles;
    }


}
