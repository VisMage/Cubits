package me.josh.cubits.playerdata;

import me.josh.cubits.Main;
import me.josh.cubits.utils.PSerializable;
import me.josh.cubits.utils.PlayerProfileSerializer;
import me.josh.cubits.utils.Serializer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerProfileManager implements PSerializable<PlayerProfileManager> {
    private final Main plugin;
    private Serializer profileSerializer;
    private List<PlayerProfile> playerProfiles;


    public PlayerProfileManager(Main plugin) {
        this.plugin = plugin;
        profileSerializer = new PlayerProfileSerializer(plugin);
        playerProfiles = new ArrayList<>();
    }

    public void addPlayerProfile(UUID uuid, Player player) {
        for(int i = 0; i < playerProfiles.size(); i++) {
            if(uuid == playerProfiles.get(i).getUuid())
                return;
        }

        PlayerProfile playerProfile = new PlayerProfile(uuid, player);
        playerProfiles.add(playerProfile);
    }

    public PlayerProfile getProfileOf(UUID uuid) {
        for(int i = 0; i < playerProfiles.size(); i++) {
            if(uuid == playerProfiles.get(i).getUuid())
                return playerProfiles.get(i);
        }

        return null;
    }


    public List<PlayerProfile> getPlayerProfiles() {
        return playerProfiles;
    }

    public void setPlayerProfile(List<PlayerProfile> playerProfiles){
        this.playerProfiles = playerProfiles;
    }

    public void serialize() {
        profileSerializer.serialize(playerProfiles);
    }


    @Override
    public Serializer<PlayerProfileManager> serializer() {
        return new PlayerProfileSerializer(plugin);
    }
}
