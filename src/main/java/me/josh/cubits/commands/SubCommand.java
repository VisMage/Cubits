package me.josh.cubits.commands;
import me.josh.cubits.Main;
import org.bukkit.entity.Player;


public interface SubCommand {
    void executeCommand(Main plugin, Player p, String args[]);

    String getName();

    String getDescription();


}
