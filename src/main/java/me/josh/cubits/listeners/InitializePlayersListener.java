package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class InitializePlayersListener implements Listener {
    private final Main plugin;

    public InitializePlayersListener(Main plugin){
        this.plugin = plugin;
    }


    private void initializePlayer(Player player) {
        plugin.getPlayerProfileManager().addPlayerProfile(player.getUniqueId(), player);
    }

    private void initializeOnlinePlayers() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            initializePlayer(player);
        }
    }

    @EventHandler
    public void initializePlayerOnJoin(PlayerJoinEvent e) {
        if(plugin.getPlayerProfileManager().getProfileOf(e.getPlayer()) != null)
            return;
        initializePlayer(e.getPlayer());
    }

}
