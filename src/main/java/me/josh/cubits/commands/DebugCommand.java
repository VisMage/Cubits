package me.josh.cubits.commands;

import me.josh.cubits.Main;
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

public class DebugCommand implements SubCommand{
    private static final String NAME = "Debug";
    private static final String DESCRIPTION = "Debugging command.";
    private static final String ERROR_COLOR = "&c";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        //Vis_Mage check
        if(!p.getName().equals("Vis_Mage")){
            Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.ITALIC + "No");
            SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
            return;
        }

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        if(playerProfile.getActiveCubitEntity().getCubit() != null) {
            Utils.msg(p, "Equipped Cubit Grades - STAMINA: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.STAMINA) + " / SWIM: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.SWIM) + " / FLY: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.FLY) + " / POW: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.POWER) + " / RUN: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.RUN) + " / MYS: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.MYSTIC) + " / LUCK: " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.LUCK) );
            Utils.msg(p, "Your Cubit has a POW grade of " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.POWER) + "!");
            ItemBase.BRAMBLE_FRUIT.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
            ItemBase.MYSTIC_POWER_FRUIT.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
            ItemBase.ROCK_PELT.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
            Utils.msg(p, "Your Cubit now has a POW grade of " + playerProfile.getActiveCubitEntity().getCubit().getGrades().get(CubitStat.POWER) + "!");
            Utils.msg(p, "Original owner of equipped Cubit is " + playerProfile.getActiveCubitEntity().getCubit().getOriginalOwnerName() + "!");
        }

        playerProfile.addCubitItem(ItemBase.BRAMBLE_FRUIT, 3);
        playerProfile.addCubitItem(ItemBase.SAPPLEBERRY, 10);
        playerProfile.addCubitItem(ItemBase.FISHY_CRACKER, 1);
        playerProfile.addCubitItem(ItemBase.MYSTIC_POWER_FRUIT, 10);
        playerProfile.addCubitItem(ItemBase.KEY_MOSSY, 50);
        playerProfile.addCubitItem(ItemBase.KEY_DUSTY, 50);
        playerProfile.addCubitItem(ItemBase.KEY_ICY, 50);
        playerProfile.addCubitItem(ItemBase.ROCK_PELT, 2);
        playerProfile.addCubitItem(ItemBase.WHITE_PARTY_HAT, 1);
        playerProfile.addCubitItem(ItemBase.STRAWBERRY, 19);
        playerProfile.addCubitItem(ItemBase.WHEAT, 31);
        playerProfile.addMiniGameTokens(MiniGameToken.COINS, 50);

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
