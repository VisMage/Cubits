package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.menus.PetMenu;
import me.josh.cubits.utils.Utils;
import org.bukkit.entity.Player;

public class PetMenuCommand implements SubCommand {
    private static final String NAME = "PetMenu";
    private static final String DESCRIPTION = "Opens the player's Pet Menu.";
    private static final String ERROR_COLOR = "&c";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        //Page Number (Default: 1)
        int page = 1;
        if(args.length >= 3){
            Utils.msg(p, String.format("%sCommand parameters: /cb PetMenu <Page Number>", ERROR_COLOR));
            return;
        }
        if(args.length == 2){
            try{
                page = Integer.parseInt(args[1]);
            }
            catch (Exception ex) {
                Utils.msg(p, String.format("%sCommand parameters: /cb PetMenu <Page Number>", ERROR_COLOR));
                return;
            }
        }

        PetMenu.OpenPetMenu(plugin, p, page);
        // End
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
