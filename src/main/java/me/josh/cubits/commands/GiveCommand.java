package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GiveCommand implements SubCommand{

    private static final String NAME = "Give";
    private static final String DESCRIPTION = "Gives the specified Cubit.";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        //Vis_Mage check
        if(!p.getName().equals("Vis_Mage")){
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Shame " + ChatColor.GREEN + p.getName() + ChatColor.LIGHT_PURPLE + ", for shame! Trying to give yourself a Cubit using commands, and thinking no one would be the wiser. I expected better from you. You cheated not only the game, but yourself. You didn't grow. You didn't improve. You took a shortcut and gained nothing. You experienced a hollow victory. Nothing was risked and nothing was gained. It's sad you don't know the difference.");
            SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
            return;
        }

        if(args.length != 2){
            Utils.msg(p, "Incorrect syntax. /cb give [Cubit_Type]");
            return;
        }

        //If there are arguments attached to the command, then parse the arguments
        CubitBase cubitBase = CubitDatabase.getCubitBase(args[1]);

        if(cubitBase == null) {
            Utils.msg(p, "Invalid Cubit type.");
            return;
        }

        Utils.msg(p, "You got a " + cubitBase.getName() + "!");
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        playerProfile.addCubit(new Cubit(cubitBase, p));

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
