package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class GiveCurrencyCommand implements SubCommand{
    private static final String NAME = "GiveCurrency";
    private static final String DESCRIPTION = "Give different Currencies.";
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
            Utils.msg(p, "Incorrect syntax. /cb GiveCurrency [TYPE] [AMOUNT].");
            //Utils.msg(p, "Valid Types: Coins, RED_IRIS, TOKEN_SURVIVAL");
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

        String type = args[1];
        if(type.equals("coins")){
            playerProfile.addMiniGameTokens(MiniGameToken.COINS, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Coins are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.COINS));

        } else if (type.equals("gems")) {
            playerProfile.addMiniGameTokens(MiniGameToken.GEMS, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Gems are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.GEMS));

        }else if (type.equals("survival")) {
            playerProfile.addMiniGameTokens(MiniGameToken.SURVIVAL, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Survival Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.SURVIVAL));

        }else if (type.equals("combat")) {
            playerProfile.addMiniGameTokens(MiniGameToken.COMBAT, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Combat Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.COMBAT));

        }else if (type.equals("foraging")) {
            playerProfile.addMiniGameTokens(MiniGameToken.FORAGING, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Foraging Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.FORAGING));

        }else if (type.equals("fishing")) {
            playerProfile.addMiniGameTokens(MiniGameToken.FISHING, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Fishing Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.FISHING));

        }else if (type.equals("mythic")) {
            playerProfile.addMiniGameTokens(MiniGameToken.MYTHIC, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Mythic Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.MYTHIC));

        }else if (type.equals("essence")) {
            playerProfile.addMiniGameTokens(MiniGameToken.ESSENCE, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Essence Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.ESSENCE));

        }else if (type.equals("red_iris")) {
            playerProfile.addMiniGameTokens(MiniGameToken.RED_IRIS, amount);
            p.sendMessage(ChatColor.YELLOW + "Your Red Iris Tokens are now " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.RED_IRIS));

        }else{
            Utils.msg(p, "Invalid currency type.");
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
