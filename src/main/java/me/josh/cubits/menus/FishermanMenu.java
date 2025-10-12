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

public class FishermanMenu extends CubitGui {

    public static void openFishermanMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String INVENTORY_NAME = "Fisherman Menu";
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
        treats_meta.setDisplayName("Fisherman Shop");
        treats_meta.setCustomModelData(10101);
        //loreInt1 = playerProfile.getMiniGameTokens().get(MiniGameToken.SLAYER_TOKENS);
        //treats_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Slayer Points: " + ChatColor.WHITE +   loreInt1));
        SLAYERSHOP.setItemMeta(treats_meta);

        SLAYERINFO = new ItemStack(Material.PAPER, 1);
        ItemMeta dummyItems_meta = SLAYERINFO.getItemMeta();
        dummyItems_meta.setDisplayName("Fishing Info");
        dummyItems_meta.setCustomModelData(10102);
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUESTS_COMPLETE);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_STREAK);
        dummyItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Tasks Complete: " + ChatColor.WHITE +   loreInt1, ChatColor.LIGHT_PURPLE + "Current Streak: " + ChatColor.WHITE +   loreInt2));
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

        SLAYERTASK = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta skinItems_meta = SLAYERTASK.getItemMeta();
        skinItems_meta.setDisplayName("Fishing Task");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_AMOUNT);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT);

        if(playerProfile.getQuestFish() != null) {
            lore1 = playerProfile.getQuestFish().getName();
        }else{
            lore1 = "No Active Task";
        }

        skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + lore1, ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        skinItems_meta.setCustomModelData(10104);
        SLAYERTASK.setItemMeta(skinItems_meta);


        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(11, SLAYERSHOP);
        gui.setItem(15, SLAYERINFO);
        gui.setItem(13, SLAYERTASK);
        gui.setItem(12, FISHINGUPGRADE);
        gui.setItem(14, QUEST);
        gui.setItem(22, BACK_ICON);
        //gui.setItem(26, COOKING_ICON);

        p.openInventory(gui);
    }

}
