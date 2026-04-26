package me.josh.cubits.items;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.concurrent.ThreadLocalRandom;

public class ObtainTreat {

    private final Main plugin;
    public ObtainTreat(Main plugin) {
        this.plugin = plugin;
    }

    public void GiveTreat(Player player, ItemBase item) {

        int amount = 1;
        int fishingFrenzyExtra = ThreadLocalRandom.current().nextInt(3, 5 + 1);

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Item drop! Found a " + item.getName() + "!");
        playerProfile.addCubitItem(item, amount);
        SoundUtil.PlaySoundAll(Sound.BLOCK_BEEHIVE_ENTER, 1, 1);

        if(playerProfile.isActivateFishingFrenzy()){
            player.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Fishing Frenzy! Caught " + fishingFrenzyExtra + " extra fish!");
            amount += fishingFrenzyExtra;
            playerProfile.setActivateFishingFrenzy(false);
        }

        if(playerProfile.isActivateDoubleHaul()){
            amount *= 2;
            player.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Double Haul! Reeled in " + amount + " " + item.getName() + "!");
            playerProfile.setActivateDoubleHaul(false);
        }

        if(playerProfile.getAch2ItemBase() == item) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            playerProfile.addPlayerVariables(PlayerVariables.ACHIEVEMENT_AMOUNT_2, amount);
        }

        if(playerProfile.getAch5Fish() == item) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            playerProfile.addPlayerVariables(PlayerVariables.ACHIEVEMENT_AMOUNT_5, amount);
        }

    }

}
