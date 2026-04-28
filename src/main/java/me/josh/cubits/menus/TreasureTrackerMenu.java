package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.menus.shopkeepers.CubitGui;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.treasuretracker.TreasureTrackingManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TreasureTrackerMenu extends CubitGui {

    public static void openTreasureTrackerMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        String INVENTORY_NAME = "Treasure Tracker";
        int INVENTORY_SIZE = 27;
        ItemStack BACK_ICON;
        ItemStack SLAYERSHOP;
        ItemStack SLAYERINFO;
        ItemStack FISHINGUPGRADE;
        ItemStack QUEST;
        ItemStack SLAYERTASK;
        ItemStack COOKING_ICON;

        String lore1 = " ";
        String lore2 = " ";
        String lore3 = " ";
        String lore4 = " ";
        int loreInt1 = 0;
        int loreInt2 = 0;
        int loreInt3 = 0;
        int loreInt4 = 0;


        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Create Inventory Items
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);


        SLAYERSHOP = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta treats_meta = SLAYERSHOP.getItemMeta();
        treats_meta.setDisplayName("Treasure Shop");
        treats_meta.setCustomModelData(10101);
        SLAYERSHOP.setItemMeta(treats_meta);

        SLAYERINFO = new ItemStack(Material.PAPER, 1);
        ItemMeta dummyItems_meta = SLAYERINFO.getItemMeta();
        dummyItems_meta.setDisplayName("Treasure Tracker Info");
        dummyItems_meta.setCustomModelData(10102);
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.TREASURE_TRACKER_COMPLETED);
        dummyItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Treasures Found: " + ChatColor.WHITE + loreInt1));
        SLAYERINFO.setItemMeta(dummyItems_meta);

        FISHINGUPGRADE = new ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1);
        ItemMeta treats_meta2 = FISHINGUPGRADE.getItemMeta();
        treats_meta2.setDisplayName("Upgrade Shop");
        treats_meta2.setCustomModelData(10101);
        FISHINGUPGRADE.setItemMeta(treats_meta2);

        QUEST = new ItemStack(Material.MAP, 1);
        ItemMeta treats_meta3 = QUEST.getItemMeta();
        treats_meta3.setDisplayName("Quest");
        treats_meta3.setCustomModelData(10101);
        QUEST.setItemMeta(treats_meta3);

        SLAYERTASK = new ItemStack(Material.COMPASS, 1);
        ItemMeta skinItems_meta = SLAYERTASK.getItemMeta();
        skinItems_meta.setDisplayName("Treasure Task");

        if(plugin.getTreasureTrackingManager().hasActiveTreasure(p)) {
            lore1 = "Treasure Task Active!";
            lore2 = "Hint: " + plugin.getTreasureTrackingManager().getCurrentTreasureHint(p);
            lore3 = "Click to get new compass";
            skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + lore1, ChatColor.WHITE + lore2,  ChatColor.WHITE + lore3));
        }else{
            lore1 = "No Active Task";
            lore2 = "Click to get new treasure tak!";
            skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + lore1, ChatColor.WHITE + lore2));
        }

        skinItems_meta.setCustomModelData(10104);
        SLAYERTASK.setItemMeta(skinItems_meta);


        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        //gui.setItem(12, SLAYERSHOP);
        gui.setItem(26, SLAYERINFO);
        gui.setItem(13, SLAYERTASK);
        //gui.setItem(12, FISHINGUPGRADE);
        //gui.setItem(14, QUEST);
        gui.setItem(22, BACK_ICON);

        p.openInventory(gui);
    }

}
