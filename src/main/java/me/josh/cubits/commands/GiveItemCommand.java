package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GiveItemCommand implements SubCommand{
    private static final String NAME = "GiveItem";
    private static final String DESCRIPTION = "Give Cubit Items.";
    private static final String ERROR_COLOR = "&c";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        //Vis_Mage check
        if(!p.getName().equals("Vis_Mage")){
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Shame " + ChatColor.GREEN + p.getName() + ChatColor.LIGHT_PURPLE + ", for shame! Trying to give yourself a currency using commands, and thinking no one would be the wiser. I expected better from you. You cheated not only the game, but yourself. You didn't grow. You didn't improve. You took a shortcut and gained nothing. You experienced a hollow victory. Nothing was risked and nothing was gained. It's sad you don't know the difference.");
            SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
            return;
        }

        if(args.length != 3){
            Utils.msg(p, "Incorrect syntax. /cb GiveItem [ITEM] [AMOUNT].");
            return;
        }

        //If there are arguments attached to the command, then parse the arguments
        int amount = 1;
        try {
            amount = Integer.parseInt(args[2]);
        }
        catch (Exception e )
        {
            amount = 0;
        }

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        //If there are arguments attached to the command, then parse the arguments
        ItemBase itemBase = CubitDatabase.getAllItem(args[1]);

        if(itemBase == null) {
            Utils.msg(p, "Invalid Item type.");
            return;
        }

        Utils.msg(p, "You got " + amount + " " + itemBase.getName() + "!");
        playerProfile.addCubitItem(itemBase, amount);

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
