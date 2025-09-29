package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.menus.BagCategoryMenu;
import me.josh.cubits.utils.Utils;
import org.bukkit.entity.Player;

public class BagCategoryCommand implements SubCommand {
    public static final String NAME = "Bag";
    private static final String DESCRIPTION = "Opens the Bag menu.";
    private static final  String ERROR_COLOR = "&c";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {
        // Catch Errors
        if(args.length != 1){
            Utils.msg(p, String.format("%sIncorrect syntax. /cb Bag", ERROR_COLOR));
            return;
        }

        BagCategoryMenu.openBagCategoryMenu(plugin, p);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
