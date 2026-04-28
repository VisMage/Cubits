package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GiftCommand implements SubCommand{

    private static final String NAME = "Gift";
    private static final String DESCRIPTION = "Give your equipped Cubit to another player.";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        //Vis_Mage check
        if(!p.getName().equals("Vis_Mage")){
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Shame " + ChatColor.GREEN + p.getName() + ChatColor.LIGHT_PURPLE + ", for shame! Trying to give yourself a Cubit using commands, and thinking no one would be the wiser. I expected better from you. You cheated not only the game, but yourself. You didn't grow. You didn't improve. You took a shortcut and gained nothing. You experienced a hollow victory. Nothing was risked and nothing was gained. It's sad you don't know the difference.");
            SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
            return;
        }

        if(args.length != 2){
            Utils.msg(p, "Incorrect syntax. /cb gift [Player]");
            return;
        }

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        Player target = Bukkit.getPlayer(args[2]);

        if (target != null) {

            PlayerProfile playerProfile2 = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

            if(playerProfile2 == null){
                Utils.msg(p, "Error - Unknown player name");
                return;
            }

            p.sendMessage(ChatColor.LIGHT_PURPLE + "You sent " + target.getName() + " your " + playerProfile.getActiveCubitEntity().getCubit().getName() + "! Take good care of " + playerProfile.getActiveCubitEntity().getCubit().getName() + "!");
            p.sendMessage(ChatColor.LIGHT_PURPLE + p.getName() + " sent you their " + playerProfile.getActiveCubitEntity().getCubit().getName() + "! Take good care of " + playerProfile.getActiveCubitEntity().getCubit().getName() + "!");

            playerProfile2.addCubit(playerProfile.getActiveCubitEntity().getCubit());
            playerProfile.removeCubit(playerProfile.getActiveCubitEntity().getCubit());
            playerProfile.getActiveCubitEntity().UnequipCubit(playerProfile);
            playerProfile.setLastEquippedCubit(null);

        } else {
            Utils.msg(p, "Error - Unknown player name");
            return;
        }


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

