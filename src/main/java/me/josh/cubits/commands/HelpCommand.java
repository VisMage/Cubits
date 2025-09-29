package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.utils.Utils;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelpCommand implements SubCommand {

    private static String NAME = "help";
    private static String DESCRIPTION = "Lists all Cubits commands.";
    private static final int COMMANDS_PER_PAGE = 7;
    private static final String COMMAND_COLOR = "&7";
    private static final String DESCRIPTION_COLOR = "&f";
    private static final  String ERROR_COLOR = "&c";

    List<String> helpList;

    public HelpCommand() {
        helpList = new ArrayList<>();
    }

    public void init(Map<String, SubCommand> subCommandByName) {
        for(Map.Entry<String, SubCommand> entry : subCommandByName.entrySet()) {
            if(entry.getValue() != this)
                helpList.add(String.format("%s/cb %2s %3s%4s", COMMAND_COLOR, entry.getValue().getName(), DESCRIPTION_COLOR, entry.getValue().getDescription()));
        }
    }

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        // If there are no arguments after "/cb help" then display the help menu's first page
        if(args.length <= 1) {
            HelpMenuPage(p, 1);
            return;
        }

        try {
            int pageNum = Integer.parseInt(args[1]);
            HelpMenuPage(p, pageNum);
        }
        catch (Exception e) {
            Utils.msg(p, String.format("%sInvalid args", ERROR_COLOR));
            Utils.msg(p, String.format("%sCommand parameters: /cb help <Page Number>", ERROR_COLOR));
        }
    }

    private void HelpMenuPage(Player p, int pageNum)
    {
        if(pageNum <= 1 || (pageNum - 1) * COMMANDS_PER_PAGE >= helpList.size())
            pageNum = 1;

        int totalPages = (helpList.size() % COMMANDS_PER_PAGE == 0) ? helpList.size() / COMMANDS_PER_PAGE : helpList.size() / COMMANDS_PER_PAGE + 1;
        Utils.msg(p, String.format("%s=== Cubits Help Menu ===", COMMAND_COLOR));
        Utils.msg(p, String.format("%s========== Page %d /%2d ==========", COMMAND_COLOR, pageNum, totalPages));
        for(int i = 0; i < COMMANDS_PER_PAGE; i++) {
            int commandIndex = (pageNum - 1) * COMMANDS_PER_PAGE + i;
            if(commandIndex >= helpList.size())
                break;

            Utils.msg(p, helpList.get(commandIndex));
        }

        if(pageNum * COMMANDS_PER_PAGE < helpList.size())
            Utils.msg(p, String.format("%sType %2s/cb help %d %2sto view the next page", COMMAND_COLOR, DESCRIPTION_COLOR, pageNum + 1, COMMAND_COLOR));
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
