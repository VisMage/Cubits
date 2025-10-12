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

public class FishingUpgradeShop extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static String INVENTORY_NAME;

    private FishingUpgradeShop(){

    }

    public static void OpenFishingUpgradeStore(Main plugin, Player p) {
        // Define Variables
        ItemStack GEM_FINDER;
        ItemStack DRESSED_SPINNER;
        ItemStack TREASURE_LURE;
        ItemStack DOUBLE_HAUL;
        ItemStack FISHING_FRENZY;
        ItemStack SCAVANGER;
        ItemStack TITANIUM_LURE;
        ItemStack PRESERVE_LURE;
        ItemStack BLOCK_SLOT;
        ItemStack BLOCK_SLOT_CLEAR;
        ItemStack EXTEND_TASK;
        ItemStack SKIP_TASK;
        ItemStack FISHING_TASK;
        ItemStack BACK_ICON;


        String lore1 = " ";
        String lore2 = " ";
        String lore3 = " ";
        String lore4 = " ";
        int loreInt1 = 0;
        int loreInt2 = 0;
        int loreInt3 = 0;
        int loreInt4 = 0;

        // Set Inventory Name
        INVENTORY_NAME = "Fishing Upgrades";

        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Set items into their proper slots
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(49, QUIT_MENU_ICON);

        // Create Items
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);

        GEM_FINDER = new ItemStack(Material.DIAMOND, 1);
        ItemMeta treats_meta = GEM_FINDER.getItemMeta();
        treats_meta.setDisplayName("Gem Finder");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_GEM_FINDER) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Change to fish up a small bundle of gems.", "Cost: 20 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.GREEN + "Change to fish up a small bundle of gems.", "PURCHASED" ));
        }
        GEM_FINDER.setItemMeta(treats_meta);

        SKIP_TASK = new ItemStack(Material.WIND_CHARGE, 1);
        treats_meta = SKIP_TASK.getItemMeta();
        treats_meta.setDisplayName("Skip Task");
        treats_meta.setCustomModelData(10101);
        treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Skip your current fishing task.", "Cost: 10 Fishing Tokens" ));
        SKIP_TASK.setItemMeta(treats_meta);

        EXTEND_TASK = new ItemStack(Material.EMERALD, 1);
        treats_meta = EXTEND_TASK.getItemMeta();
        treats_meta.setDisplayName("Extend Task");
        treats_meta.setCustomModelData(10101);
        treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Extend your current fishing task.", "Cost: 5 Fishing Tokens" ));
        EXTEND_TASK.setItemMeta(treats_meta);

        DRESSED_SPINNER = new ItemStack(Material.PRISMARINE_SHARD, 1);
        treats_meta = DRESSED_SPINNER.getItemMeta();
        treats_meta.setDisplayName("Dressed Spinner");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_DRESSED_SPINNER) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increases the chance to hook rare fish.", "Cost: 30 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increases the chance to hook rare fish.", "PURCHASED" ));
        }
        DRESSED_SPINNER.setItemMeta(treats_meta);

        TREASURE_LURE = new ItemStack(Material.CHEST, 1);
        treats_meta = TREASURE_LURE.getItemMeta();
        treats_meta.setDisplayName("Treasure Lure");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_TREASURE_LURE) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increase the change to hook a treasure chest.", "Cost: 30 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increase the change to hook a treasure chest.", "PURCHASED" ));
        }
        TREASURE_LURE.setItemMeta(treats_meta);

        TITANIUM_LURE = new ItemStack(Material.NETHERITE_SCRAP, 1);
        treats_meta = TITANIUM_LURE.getItemMeta();
        treats_meta.setDisplayName("Titanium Lure");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_TITANIUM_LURE) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Allows Titanic fish to be hooked.", "Cost: 30 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Allows Titanic fish to be hooked.", "PURCHASED" ));
        }
        TITANIUM_LURE.setItemMeta(treats_meta);

        PRESERVE_LURE = new ItemStack(Material.GOLD_INGOT, 1);
        treats_meta = PRESERVE_LURE.getItemMeta();
        treats_meta.setDisplayName("Preserve Lure");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_PRESERVE_LURE) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Change to not use up bait while fishing.", "Includes Ender Dragon, Wither, Elder Guardian, Warden, and Invoker.", "Enables various new item drops and enhanced Slayer Point rewards.", "Cost: 50 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Change to not use up bait while fishing.", "Includes Ender Dragon, Wither, Elder Guardian, Warden, and Invoker.", "Enables various new item drops and enhanced Slayer Point rewards.", "PURCHASED" ));
        }
        PRESERVE_LURE.setItemMeta(treats_meta);

        DOUBLE_HAUL = new ItemStack(Material.SALMON_BUCKET, 1);
        treats_meta = DOUBLE_HAUL.getItemMeta();
        treats_meta.setDisplayName("Double Haul");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_DOUBLE_HAUL) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Chance to hook two fish at once.", "Cost: 50 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Chance to hook two fish at once.", "PURCHASED" ));
        }
        DOUBLE_HAUL.setItemMeta(treats_meta);

        SCAVANGER = new ItemStack(Material.KELP, 1);
        treats_meta = SCAVANGER.getItemMeta();
        treats_meta.setDisplayName("Scavanger");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_SCAVANGER) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increase the change to hook ingredients and treats.", "Cost: 50 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increase the change to hook ingredients and treats.", "PURCHASED" ));
        }
        SCAVANGER.setItemMeta(treats_meta);

        FISHING_FRENZY = new ItemStack(Material.PUFFERFISH, 1);
        treats_meta = FISHING_FRENZY.getItemMeta();
        treats_meta.setDisplayName("Fishing Frenzy");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_FISHING_FRENZY) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Small chance to catch many of the same fish at once!", "Cost: 50 Fishing Tokens" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Small chance to catch many of the same fish at once!", "PURCHASED" ));
        }
        FISHING_FRENZY.setItemMeta(treats_meta);

        BLOCK_SLOT = new ItemStack(Material.IRON_BARS, 1);
        treats_meta = BLOCK_SLOT.getItemMeta();
        treats_meta.setDisplayName("Block Task");
        treats_meta.setCustomModelData(10101);
        if (playerProfile.getQuestFishBlocked() == null) {
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Blocks your current fishing task from being assigned, and skips it.", "Only one fishing task can be blocked at once.", "Blocked Task - None" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Blocks your current fishing task from being assigned, and skips it.", "Only one fishing task can be blocked at once.", "Blocked Task - " + playerProfile.getQuestFishBlocked().toString() ));
        }
        BLOCK_SLOT.setItemMeta(treats_meta);

        BLOCK_SLOT_CLEAR = new ItemStack(Material.IRON_INGOT, 1);
        treats_meta = BLOCK_SLOT_CLEAR.getItemMeta();
        treats_meta.setDisplayName("Clear Blocked Task");
        treats_meta.setCustomModelData(10101);
        treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Clear your blocked task." ));
        BLOCK_SLOT_CLEAR.setItemMeta(treats_meta);





        FISHING_TASK = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta skinItems_meta = FISHING_TASK.getItemMeta();
        skinItems_meta.setDisplayName("Fishing Task");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_AMOUNT);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT);

        if(playerProfile.getSlayerMob() != null) {
            lore1 = playerProfile.getQuestFish().toString();
        }else{
            lore1 = "No Active Task";
        }

        skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + lore1, ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        skinItems_meta.setCustomModelData(10104);
        FISHING_TASK.setItemMeta(skinItems_meta);




        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(10, DRESSED_SPINNER);
        gui.setItem(11, TREASURE_LURE);
        gui.setItem(12, TITANIUM_LURE);
        gui.setItem(13, PRESERVE_LURE);
        gui.setItem(14, GEM_FINDER);
        gui.setItem(15, DOUBLE_HAUL);
        gui.setItem(16, SCAVANGER);
        gui.setItem(19, FISHING_FRENZY);
        gui.setItem(20, BLOCK_SLOT);
        gui.setItem(21, BLOCK_SLOT_CLEAR);
        gui.setItem(22, EXTEND_TASK);
        gui.setItem(23, SKIP_TASK);
        gui.setItem(45, FISHING_TASK);
        gui.setItem(49, BACK_ICON);
        //gui.setItem(26, COOKING_ICON);








        p.openInventory(gui);
    }



}

