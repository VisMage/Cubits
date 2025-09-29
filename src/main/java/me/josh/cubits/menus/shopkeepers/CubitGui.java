package me.josh.cubits.menus.shopkeepers;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public abstract class CubitGui {
    protected static final ItemStack TRIM;
    protected static final ItemStack QUIT_MENU_ICON;

    static {
        TRIM = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta filling_meta = TRIM.getItemMeta();
        filling_meta.setDisplayName(" ");
        TRIM.setItemMeta(filling_meta);

        QUIT_MENU_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = QUIT_MENU_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        QUIT_MENU_ICON.setItemMeta(back_meta);
    }

    protected static void addBorderTrim(Inventory gui) {
        for(int i = 0; i < gui.getSize() / 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(i == 0 || i == gui.getSize() / 9 - 1 || j == 0 || j == 8)
                    gui.setItem(i * 9 + j, TRIM);
            }
        }
    }

    protected static ItemStack getPlayerHeadWithTokenStats(Main plugin, Player player) {
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        if(playerProfile == null)
            return null;

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta)playerHead.getItemMeta();
        skullMeta.setOwnerProfile(player.getPlayerProfile());
        String nameTemp = player.getDisplayName();
        nameTemp = ChatColor.stripColor(nameTemp);
        skullMeta.setDisplayName(ChatColor.BLUE + nameTemp);
        skullMeta.setLore(Arrays.asList(
                ChatColor.LIGHT_PURPLE + "Coins: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.COINS),
                ChatColor.LIGHT_PURPLE + "Gems: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.GEMS),
                ChatColor.LIGHT_PURPLE + "Survival Tokens: " + ChatColor.WHITE +  playerProfile.getMiniGameTokens().get(MiniGameToken.SURVIVAL),
                ChatColor.LIGHT_PURPLE + "Combat Tokens: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.COMBAT),
                ChatColor.LIGHT_PURPLE + "Foraging Tokens: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.FORAGING),
                ChatColor.LIGHT_PURPLE + "Fishing Tokens: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.FISHING),
                ChatColor.LIGHT_PURPLE + "Mythic Tokens: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.MYTHIC),
                ChatColor.LIGHT_PURPLE + "Slayer Tokens: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.SLAYER_TOKENS),
                ChatColor.LIGHT_PURPLE + "Essence: " + ChatColor.WHITE + playerProfile.getMiniGameTokens().get(MiniGameToken.ESSENCE)));
        playerHead.setItemMeta(skullMeta);

        return playerHead;
    }

}
