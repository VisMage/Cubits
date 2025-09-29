package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CubitListener implements Listener {
    private final Main plugin;

    public CubitListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId()) == null) {
            plugin.getPlayerProfileManager().addPlayerProfile(p.getUniqueId(), p);
        }
    }





}
