package me.josh.cubits.menus.index;

import me.josh.cubits.Main;
import me.josh.cubits.commands.SubCommand;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class IndexMenu implements SubCommand {

    private static final String NAME = "Index";
    private static final String DESCRIPTION = "Opens the Index menu.";
    private static final  String ERROR_COLOR = "&c";

    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        // Catch Errors
        if(args.length != 1){
            Utils.msg(p, String.format("%sIncorrect syntax. /cb Index", ERROR_COLOR));
            return;
        }

        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String nameTemp = "debug";
        int loreInt1 = 0;
        int loreInt2 = 0;
        int loreInt3 = 0;
        int loreInt4 = 0;
        int loreInt5 = 0;
        int loreInt6 = 0;
        int loreInt7 = 0;
        int loreInt8 = 0;

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, 27, "Index");

        // Create Items to place in inventory
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = back.getItemMeta();
        back_meta.setDisplayName("Back");
        back.setItemMeta(back_meta);

        ItemStack filling = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta filling_meta = filling.getItemMeta();
        filling_meta.setDisplayName(" ");
        filling.setItemMeta(filling_meta);

        ItemStack cubits = new ItemStack(Material.CLOCK, 1);
        ItemMeta cubits_meta = cubits.getItemMeta();
        cubits_meta.setDisplayName("Cubits");
        cubits_meta.setCustomModelData(10106);
        cubits.setItemMeta(cubits_meta);

        ItemStack treats = new ItemStack(Material.CLOCK, 1);
        ItemMeta treats_meta = treats.getItemMeta();
        treats_meta.setDisplayName("Treats");
        treats_meta.setCustomModelData(10101);
        treats.setItemMeta(treats_meta);

        ItemStack dummyItems = new ItemStack(Material.CLOCK, 1);
        ItemMeta dummyItems_meta = dummyItems.getItemMeta();
        dummyItems_meta.setDisplayName("Items");
        dummyItems_meta.setCustomModelData(10102);
        dummyItems.setItemMeta(dummyItems_meta);

        ItemStack trinkets = new ItemStack(Material.CLOCK, 1);
        ItemMeta trinkets_meta = trinkets.getItemMeta();
        trinkets_meta.setDisplayName("Trinkets");
        trinkets_meta.setCustomModelData(10103);
        trinkets.setItemMeta(trinkets_meta);

        ItemStack skinItems = new ItemStack(Material.CLOCK, 1);
        ItemMeta skinItems_meta = skinItems.getItemMeta();
        skinItems_meta.setDisplayName("Cosmetics");
        skinItems_meta.setCustomModelData(10104);
        skinItems.setItemMeta(skinItems_meta);

        ItemStack potions = new ItemStack(Material.CLOCK, 1);
        ItemMeta potions_meta = potions.getItemMeta();
        potions_meta.setDisplayName("Potions");
        potions_meta.setCustomModelData(10105);
        potions.setItemMeta(potions_meta);

        ItemStack item5 = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta)item5.getItemMeta();
        skullMeta.setOwnerProfile(p.getPlayerProfile());
        nameTemp = p.getDisplayName();
        nameTemp = ChatColor.stripColor(nameTemp);
        skullMeta.setDisplayName(ChatColor.BLUE + nameTemp);
        loreInt1 = playerProfile.getMiniGameTokens().get(MiniGameToken.COINS);
        loreInt2 = playerProfile.getMiniGameTokens().get(MiniGameToken.GEMS);
        loreInt3 = playerProfile.getMiniGameTokens().get(MiniGameToken.SURVIVAL);
        loreInt4 = playerProfile.getMiniGameTokens().get(MiniGameToken.COMBAT);
        loreInt5 = playerProfile.getMiniGameTokens().get(MiniGameToken.FORAGING);
        loreInt6 = playerProfile.getMiniGameTokens().get(MiniGameToken.FISHING);
        loreInt7 = playerProfile.getMiniGameTokens().get(MiniGameToken.MYTHIC);
        loreInt8 = playerProfile.getMiniGameTokens().get(MiniGameToken.ESSENCE);
        skullMeta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Coins: " + ChatColor.WHITE + loreInt1, ChatColor.LIGHT_PURPLE + "Gems: " + ChatColor.WHITE + loreInt2, ChatColor.LIGHT_PURPLE + "Survival Tokens: " + ChatColor.WHITE +  loreInt3, ChatColor.LIGHT_PURPLE + "Combat Tokens: " + ChatColor.WHITE + loreInt4, ChatColor.LIGHT_PURPLE + "Foraging Tokens: " + ChatColor.WHITE + loreInt5, ChatColor.LIGHT_PURPLE + "Fishing Tokens: " + ChatColor.WHITE + loreInt6, ChatColor.LIGHT_PURPLE + "Mythic Tokens: " + ChatColor.WHITE + loreInt7, ChatColor.LIGHT_PURPLE + "Essence: " + ChatColor.WHITE + loreInt8));
        item5.setItemMeta(skullMeta);

        // Loop to fill in remaining slots with Gray Stained Glass Panes
        for (int i = 0; i < 27; i++) {
            if(i < 9 || i > 18 || i % 9 == 0 || i % 9 == 8){
                gui.setItem(i, filling);
            }
        }

        // Set items into their proper slots
        gui.setItem(4, item5);
        gui.setItem(11, cubits);
        gui.setItem(12, treats);
        gui.setItem(13, dummyItems);
        gui.setItem(14, trinkets);
        gui.setItem(15, skinItems);
        //gui.setItem(16, potions); //Brewed directly, not obtained?
        gui.setItem(22, back);

        p.openInventory(gui);

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
