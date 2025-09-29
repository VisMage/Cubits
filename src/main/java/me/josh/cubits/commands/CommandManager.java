package me.josh.cubits.commands;

import me.josh.cubits.menus.index.IndexMenu;
import me.josh.cubits.Main;
import me.josh.cubits.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements CommandExecutor, TabCompleter {
    private static final  String ERROR_COLOR = "&c";

    public final Main plugin;

    private Map<String, SubCommand> subCommandByName;

    public CommandManager(Main plugin) {

        this.plugin = plugin;
        subCommandByName = new HashMap<String, SubCommand>();

        // Add all String, SubCommand pairs to the command map
        MenuCommand menuCommand = new MenuCommand();
        subCommandByName.put(menuCommand.getName().toLowerCase(), menuCommand);

        PlayerStatMenuCommand playerStatMenuCommand = new PlayerStatMenuCommand();
        subCommandByName.put(playerStatMenuCommand.getName().toLowerCase(), playerStatMenuCommand);
        
        StarterCommand starterCommand = new StarterCommand();
        subCommandByName.put(starterCommand.getName().toLowerCase(), starterCommand);

        BagCategoryCommand bagCategoryCommand = new BagCategoryCommand();
        subCommandByName.put(bagCategoryCommand.getName().toLowerCase(), bagCategoryCommand);

        SummeryCommand summeryCommand = new SummeryCommand();
        subCommandByName.put(summeryCommand.getName().toLowerCase(), summeryCommand);

        PetMenuCommand petMenuCommand = new PetMenuCommand();
        subCommandByName.put(petMenuCommand.getName().toLowerCase(), petMenuCommand);

        IndexMenu indexMenu = new IndexMenu();
        subCommandByName.put(indexMenu.getName().toLowerCase(), indexMenu);

        GiveCommand giveCommand = new GiveCommand();
        subCommandByName.put(giveCommand.getName().toLowerCase(), giveCommand);

        GiveCurrencyCommand giveCurrencyCommand = new GiveCurrencyCommand();
        subCommandByName.put(giveCurrencyCommand.getName().toLowerCase(), giveCurrencyCommand);

        GiveItemCommand giveItemCommand = new GiveItemCommand();
        subCommandByName.put(giveItemCommand.getName().toLowerCase(), giveItemCommand);

        HelpCommand helpCommand = new HelpCommand();
        subCommandByName.put(helpCommand.getName().toLowerCase(), helpCommand);

        DebugCommand debugCommand = new DebugCommand();
        subCommandByName.put(debugCommand.getName().toLowerCase(), debugCommand);

        helpCommand.init(subCommandByName);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use Cubits commands");
            return false;
        }
        Player p = (Player)sender;
        // If no arguments are added to /cb, bring up the /cb help menu
        if(args.length == 0) {
            subCommandByName.get("help").executeCommand(plugin, p, args);
            return false;
        }
        // If the sub-command entered is not a registered sub-command
        if(!subCommandByName.containsKey(args[0].toLowerCase())) {
            Utils.msg(p, String.format("%sInvalid Command", ERROR_COLOR));
            Utils.msg(p, String.format("%sUse /cb Help to see a list of Cubits commands", ERROR_COLOR));
            return false;
        }

        subCommandByName.get(args[0].toLowerCase()).executeCommand(plugin, p, args);
        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> tabList = new ArrayList<>();

        if(args.length == 1) {
            for(Map.Entry<String, SubCommand> cmdEntry : subCommandByName.entrySet())
                tabList.add(cmdEntry.getKey().toLowerCase());
        }
//        else if(args.length == 2) {
//            for(Map.Entry<String, SubCommand> cmdEntry : subCommandByName.entrySet()) {
//                if(cmdEntry.getKey().equals(args[0])) {
//                    tabList = cmdEntry.getValue().getTabCompletionList();
//                    break;
//                }
//            }
//        }

        return tabList;
    }
}
