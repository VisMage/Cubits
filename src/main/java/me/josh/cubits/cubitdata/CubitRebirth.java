package me.josh.cubits.cubitdata;

import me.josh.cubits.Main;
import me.josh.cubits.menus.RebirthMenu;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CubitRebirth {

    public void CubitRebirth(Main plugin, Player player, Cubit keepCubit, Cubit sacrificeCubit){

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        int tribStaminaGrade = sacrificeCubit.getGrades().get(CubitStat.STAMINA);
        int tribPowGrade = sacrificeCubit.getGrades().get(CubitStat.POWER);
        int tribSwimGrade = sacrificeCubit.getGrades().get(CubitStat.SWIM);
        int tribRunGrade = sacrificeCubit.getGrades().get(CubitStat.RUN);
        int tribFlyGrade = sacrificeCubit.getGrades().get(CubitStat.FLY);
        int tribMagicGrade = sacrificeCubit.getGrades().get(CubitStat.MYSTIC);

        int tribStaminaStat = sacrificeCubit.getStats().get(CubitStat.STAMINA);
        int tribPowStat = sacrificeCubit.getStats().get(CubitStat.POWER);
        int tribSwimStat = sacrificeCubit.getStats().get(CubitStat.SWIM);
        int tribRunStat = sacrificeCubit.getStats().get(CubitStat.RUN);
        int tribFlyStat = sacrificeCubit.getStats().get(CubitStat.FLY);
        int tribMagicStat = sacrificeCubit.getStats().get(CubitStat.MYSTIC);

        int raisedGrades = 0;

        if(keepCubit.getGrades().get(CubitStat.STAMINA) < tribStaminaGrade){
            keepCubit.addGrade(CubitStat.STAMINA, 1);
            raisedGrades = raisedGrades + 1;
        }

        if(keepCubit.getGrades().get(CubitStat.POWER) < tribPowGrade){
            keepCubit.addGrade(CubitStat.POWER, 1);
            raisedGrades = raisedGrades + 1;
        }

        if(keepCubit.getGrades().get(CubitStat.SWIM) < tribSwimGrade){
            keepCubit.addGrade(CubitStat.SWIM, 1);
            raisedGrades = raisedGrades + 1;
        }

        if(keepCubit.getGrades().get(CubitStat.RUN) < tribRunGrade){
            keepCubit.addGrade(CubitStat.RUN, 1);
            raisedGrades = raisedGrades + 1;
        }

        if(keepCubit.getGrades().get(CubitStat.FLY) < tribFlyGrade){
            keepCubit.addGrade(CubitStat.FLY, 1);
            raisedGrades = raisedGrades + 1;
        }

        if(keepCubit.getGrades().get(CubitStat.MYSTIC) < tribMagicGrade){
            keepCubit.addGrade(CubitStat.MYSTIC, 1);
            raisedGrades = raisedGrades + 1;
        }

        // Add random raised grade if none were raised here
        if(raisedGrades > 0){
            if(keepCubit.getGrades().get(CubitStat.STAMINA) < 6){
                keepCubit.addGrade(CubitStat.STAMINA, 1);
            } else if(keepCubit.getGrades().get(CubitStat.POWER) < 6){
                keepCubit.addGrade(CubitStat.POWER, 1);
            } else if(keepCubit.getGrades().get(CubitStat.SWIM) < 6){
                keepCubit.addGrade(CubitStat.SWIM, 1);
            } else if(keepCubit.getGrades().get(CubitStat.RUN) < 6){
                keepCubit.addGrade(CubitStat.RUN, 1);
            } else if(keepCubit.getGrades().get(CubitStat.FLY) < 6){
                keepCubit.addGrade(CubitStat.FLY, 1);
            } else if(keepCubit.getGrades().get(CubitStat.MYSTIC) < 6){
                keepCubit.addGrade(CubitStat.MYSTIC, 1);
            }
        }

        keepCubit.addStat(CubitStat.STAMINA, (tribStaminaStat));
        keepCubit.addStat(CubitStat.POWER, (tribPowStat));
        keepCubit.addStat(CubitStat.SWIM, (tribSwimStat));
        keepCubit.addStat(CubitStat.RUN, (tribRunStat));
        keepCubit.addStat(CubitStat.FLY, (tribFlyStat));
        keepCubit.addStat(CubitStat.MYSTIC, (tribMagicStat));

        keepCubit.setRebirth(keepCubit.getRebirth() + 1);

        playerProfile.removeCubit(sacrificeCubit);
        //player.sendMessage(ChatColor.RED + "Cubit was removed.");
        SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        RebirthMenu.OpenRebirthMenu(plugin, player, 1);

    }





}
