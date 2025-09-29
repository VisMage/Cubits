package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.menus.shopkeepers.CubitGui;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SlayerMenu extends CubitGui {

    public static void openSlayerMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String INVENTORY_NAME = "Slayer Menu";
        int INVENTORY_SIZE = 27;
        ItemStack BACK_ICON;
        ItemStack SLAYERSHOP;
        ItemStack SLAYERINFO;
        ItemStack QUEST3;
        ItemStack SLAYERTASK;
        ItemStack QUEST5;
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
        treats_meta.setDisplayName("Slayer Shop");
        treats_meta.setCustomModelData(10101);
        loreInt1 = playerProfile.getMiniGameTokens().get(MiniGameToken.SLAYER_TOKENS);
        treats_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Slayer Points: " + ChatColor.WHITE +   loreInt1));
        SLAYERSHOP.setItemMeta(treats_meta);


        SLAYERINFO = new ItemStack(Material.PAPER, 1);
        ItemMeta dummyItems_meta = SLAYERINFO.getItemMeta();
        dummyItems_meta.setDisplayName("Slayer Info");
        dummyItems_meta.setCustomModelData(10102);
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_COMPLETED);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_STREAK);
        dummyItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Tasks Complete: " + ChatColor.WHITE +   loreInt1, ChatColor.LIGHT_PURPLE + "Current Streak: " + ChatColor.WHITE +   loreInt2));
        SLAYERINFO.setItemMeta(dummyItems_meta);


//        QUEST3 = new ItemStack(Material.CLOCK, 1);
//        ItemMeta trinkets_meta = QUEST3.getItemMeta();
//        trinkets_meta.setDisplayName("Quest 3");
//        trinkets_meta.setCustomModelData(10103);
//        QUEST3.setItemMeta(trinkets_meta);


        SLAYERTASK = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta skinItems_meta = SLAYERTASK.getItemMeta();
        skinItems_meta.setDisplayName("Slayer Task");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT);

        if(playerProfile.getSlayerMob() != null) {
            lore1 = playerProfile.getSlayerMob().toString();
        }else{
            lore1 = "No Active Task";
        }

        skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + lore1, ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        skinItems_meta.setCustomModelData(10104);
        SLAYERTASK.setItemMeta(skinItems_meta);


//        QUEST5 = new ItemStack(Material.CLOCK, 1);
//        ItemMeta potions_meta = QUEST5.getItemMeta();
//        potions_meta.setDisplayName("Daily Collection Task");
//        potions_meta.setCustomModelData(10105);
//        QUEST5.setItemMeta(potions_meta);
//
//        COOKING_ICON = new ItemStack(Material.CAKE, 1);
//        ItemMeta cooking_meta = COOKING_ICON.getItemMeta();
//        cooking_meta.setDisplayName("Cooking");
//        //cooking_meta.setCustomModelData(10101);
//        COOKING_ICON.setItemMeta(cooking_meta);



        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(11, SLAYERSHOP);
        gui.setItem(15, SLAYERINFO);
        //gui.setItem(13, QUEST3);
        gui.setItem(13, SLAYERTASK);
        //gui.setItem(15, QUEST5);
        gui.setItem(22, BACK_ICON);
        //gui.setItem(26, COOKING_ICON);

        p.openInventory(gui);
    }

}

