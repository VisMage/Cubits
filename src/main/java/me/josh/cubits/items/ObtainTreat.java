package me.josh.cubits.items;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ObtainTreat {

    private final Main plugin;
    public ObtainTreat(Main plugin) {
        this.plugin = plugin;
    }

    public void GiveTreat(Player player, ItemBase item) {
        player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Item drop! Found a " + item.getName() + "!");
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        playerProfile.addCubitItem(item, 1);
        SoundUtil.PlaySoundAll(Sound.BLOCK_BEEHIVE_ENTER, 1, 1);
    }

}
