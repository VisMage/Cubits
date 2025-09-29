package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.menus.shopkeepers.CubitGui;
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

public class QuestMenu extends CubitGui {

    public static void openQuestMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String INVENTORY_NAME = "Quest Menu";
        int INVENTORY_SIZE = 27;
        ItemStack BACK_ICON;
        ItemStack QUEST1;
        ItemStack QUEST2;
        ItemStack QUEST3;
        ItemStack QUEST4;
        ItemStack QUEST5;
        ItemStack COOKING_ICON;

        String lore1 = " ";
        String lore2 = " ";
        String lore3 = " ";
        String lore4 = " ";
        String lore5 = " ";
        String lore6 = " ";
        String lore7 = " ";
        String lore8 = " ";
        String lore9 = " ";
        String lore10 = " ";
        int loreInt1 = 0;
        int loreInt2 = 0;
        int loreInt3 = 0;
        int loreInt4 = 0;
        int loreInt5 = 0;
        int loreInt6 = 0;
        int loreInt7 = 0;
        int loreInt8 = 0;
        int loreInt9 = 0;
        int loreInt10 = 0;

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Create Inventory Items
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);

        QUEST1 = new ItemStack(Material.CLOCK, 1);
        ItemMeta treats_meta = QUEST1.getItemMeta();
        treats_meta.setDisplayName("Quest 1");
        treats_meta.setCustomModelData(10101);
        QUEST1.setItemMeta(treats_meta);

        QUEST2 = new ItemStack(Material.CLOCK, 1);
        ItemMeta dummyItems_meta = QUEST2.getItemMeta();
        dummyItems_meta.setDisplayName("Quest 2");
        dummyItems_meta.setCustomModelData(10102);
        QUEST2.setItemMeta(dummyItems_meta);

        QUEST3 = new ItemStack(Material.CLOCK, 1);
        ItemMeta trinkets_meta = QUEST3.getItemMeta();
        trinkets_meta.setDisplayName("Quest 3");
        trinkets_meta.setCustomModelData(10103);
        QUEST3.setItemMeta(trinkets_meta);


        QUEST4 = new ItemStack(Material.CLOCK, 1);
        ItemMeta skinItems_meta = QUEST4.getItemMeta();
        skinItems_meta.setDisplayName("Slayer Task");

        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT);
        loreInt3 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_STREAK);
        loreInt4 = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_COMPLETED);

        if(playerProfile.getSlayerMob() != null) {
            lore1 = playerProfile.getSlayerMob().toString();
            }else{
            lore1 = "No Active Task";
        }

        skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + lore1, ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        skinItems_meta.setCustomModelData(10104);
        QUEST4.setItemMeta(skinItems_meta);


        QUEST5 = new ItemStack(Material.CLOCK, 1);
        ItemMeta potions_meta = QUEST5.getItemMeta();
        potions_meta.setDisplayName("Daily Collection Task");
        potions_meta.setCustomModelData(10105);
        QUEST5.setItemMeta(potions_meta);

        COOKING_ICON = new ItemStack(Material.CAKE, 1);
        ItemMeta cooking_meta = COOKING_ICON.getItemMeta();
        cooking_meta.setDisplayName("Cooking");
        //cooking_meta.setCustomModelData(10101);
        COOKING_ICON.setItemMeta(cooking_meta);



        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(11, QUEST1);
        gui.setItem(12, QUEST2);
        gui.setItem(13, QUEST3);
        gui.setItem(14, QUEST4);
        gui.setItem(15, QUEST5);
        gui.setItem(22, BACK_ICON);
        //gui.setItem(26, COOKING_ICON);

        p.openInventory(gui);
    }

}
