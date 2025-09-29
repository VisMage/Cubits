package me.josh.cubits.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
    public static void msg(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));

    }

}
