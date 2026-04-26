package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitRibbon;
import me.josh.cubits.menus.shopkeepers.CubitGui;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RibbonMenu extends CubitGui {

    public static void openRibbonMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String INVENTORY_NAME = "Ribbon Menu";
        int INVENTORY_SIZE = 54;
        ItemStack BACK_ICON;
        ItemStack RIBBON1;
        ItemStack RIBBON2;
        ItemStack RIBBON3;
        ItemStack RIBBON4;
        ItemStack RIBBON5;

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Create Inventory Items
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);


        RIBBON1 = new ItemStack(Material.CLOCK, 1);
        ItemMeta r1 = RIBBON1.getItemMeta();
        ArrayList<String> loreRibbon = new ArrayList<>();
        loreRibbon.add("Earned by reaching a total level of 100");
        if(playerProfile.getActiveCubitEntity().getCubit().getRibbons().get(CubitRibbon.LEVEL)){
            r1.setDisplayName(ChatColor.LIGHT_PURPLE + "Growth Ribbon");
            r1.setCustomModelData(10101);
        } else {
            r1.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r1.setCustomModelData(10101);
        }
        r1.setLore(loreRibbon);
        RIBBON1.setItemMeta(r1);


        RIBBON2 = new ItemStack(Material.CLOCK, 1);
        ItemMeta r2 = RIBBON2.getItemMeta();
        ArrayList<String> loreRibbon2 = new ArrayList<>();
        loreRibbon2.add("???");
        if(playerProfile.getActiveCubitEntity().getCubit().getRibbons().get(CubitRibbon.FRIENDSHIP)){
            r2.setDisplayName(ChatColor.LIGHT_PURPLE + "Friendship Ribbon");
            r2.setCustomModelData(10101);
        } else {
            r2.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r2.setCustomModelData(10101);
        }
        r2.setLore(loreRibbon2);
        RIBBON2.setItemMeta(r2);


        RIBBON3 = new ItemStack(Material.CLOCK, 1);
        ItemMeta r3 = RIBBON3.getItemMeta();
        ArrayList<String> loreRibbon3 = new ArrayList<>();
        loreRibbon3.add("???");
        if(playerProfile.getActiveCubitEntity().getCubit().getRibbons().get(CubitRibbon.ANGLER)){
            r3.setDisplayName(ChatColor.LIGHT_PURPLE + "Angler Ribbon");
            r3.setCustomModelData(10101);
        } else {
            r3.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r3.setCustomModelData(10101);
        }
        r3.setLore(loreRibbon3);
        RIBBON3.setItemMeta(r3);


        RIBBON4 = new ItemStack(Material.CLOCK, 1);
        ItemMeta r4 = RIBBON4.getItemMeta();
        ArrayList<String> loreRibbon4 = new ArrayList<>();
        loreRibbon4.add("???");
        if(playerProfile.getActiveCubitEntity().getCubit().getRibbons().get(CubitRibbon.LEVEL)){
            r4.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r4.setCustomModelData(10101);
        } else {
            r4.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r4.setCustomModelData(10101);
        }
        r4.setLore(loreRibbon4);
        RIBBON4.setItemMeta(r4);


        RIBBON5 = new ItemStack(Material.CLOCK, 1);
        ItemMeta r5 = RIBBON5.getItemMeta();
        ArrayList<String> loreRibbon5 = new ArrayList<>();
        loreRibbon5.add("???");
        if(playerProfile.getActiveCubitEntity().getCubit().getRibbons().get(CubitRibbon.LEVEL)){
            r5.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r5.setCustomModelData(10101);
        } else {
            r5.setDisplayName(ChatColor.LIGHT_PURPLE + "???");
            r5.setCustomModelData(10101);
        }
        r5.setLore(loreRibbon5);
        RIBBON5.setItemMeta(r5);




        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(10, RIBBON1);
        gui.setItem(11, RIBBON2);
        gui.setItem(12, RIBBON3);
        gui.setItem(13, RIBBON4);
        gui.setItem(14, RIBBON5);
        gui.setItem(49, BACK_ICON);

        p.openInventory(gui);
    }

}
