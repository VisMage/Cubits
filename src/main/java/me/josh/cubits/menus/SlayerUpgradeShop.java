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

public class SlayerUpgradeShop extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static String INVENTORY_NAME;

    private SlayerUpgradeShop(){

    }

    public static void OpenSlayerUpgradeStore(Main plugin, Player p) {
       // Define Variables
        ItemStack SLAYERTASK;
        ItemStack BACK_ICON;
        ItemStack SPIDER_SQUASHER;
        ItemStack SKIP_TASK;
        ItemStack EXTEND_TASK;
        ItemStack DRAGON_SLAYER;
        ItemStack WITHER_SLAYER;
        ItemStack WARDEN_SLAYER;
        ItemStack BOSS_RUSH;
        ItemStack POINT_BOOST;
        ItemStack BLOCK_SLOT;
        ItemStack BLOCK_SLOT_CLEAR;


        String lore1 = " ";
        String lore2 = " ";
        String lore3 = " ";
        String lore4 = " ";
        int loreInt1 = 0;
        int loreInt2 = 0;
        int loreInt3 = 0;
        int loreInt4 = 0;

        // Set Inventory Name
        INVENTORY_NAME = "Slayer Upgrades";

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

        SPIDER_SQUASHER = new ItemStack(Material.COBWEB, 1);
        ItemMeta treats_meta = SPIDER_SQUASHER.getItemMeta();
        treats_meta.setDisplayName("Spider Squisher");
        treats_meta.setCustomModelData(10101);
        //loreInt1 = playerProfile.getMiniGameTokens().get(MiniGameToken.SLAYER_TOKENS);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_SPIDER_SQUASHER) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Cave Spiders count double towards Spider slayer tasks.", "Cost: 20 Slayer Points" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.GREEN + "Cave Spiders count double towards Spider slayer tasks.", "PURCHASED" ));
        }
        SPIDER_SQUASHER.setItemMeta(treats_meta);

        SKIP_TASK = new ItemStack(Material.WIND_CHARGE, 1);
        treats_meta = SKIP_TASK.getItemMeta();
        treats_meta.setDisplayName("Skip Task");
        treats_meta.setCustomModelData(10101);
        treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Skip your current slayer task.", "Cost: 10 Slayer Points" ));
        SKIP_TASK.setItemMeta(treats_meta);

        EXTEND_TASK = new ItemStack(Material.EMERALD, 1);
        treats_meta = EXTEND_TASK.getItemMeta();
        treats_meta.setDisplayName("Extend Task");
        treats_meta.setCustomModelData(10101);
        treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Extend your current slayer task.", "Cost: 5 Slayer Points" ));
        EXTEND_TASK.setItemMeta(treats_meta);

        DRAGON_SLAYER = new ItemStack(Material.DRAGON_HEAD, 1);
        treats_meta = DRAGON_SLAYER.getItemMeta();
        treats_meta.setDisplayName("Dragon Slayer");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_DRAGON) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds an Ender Dragon slayer task.", "Cost: 30 Slayer Points" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds an Ender Dragon slayer task.", "PURCHASED" ));
            }
        DRAGON_SLAYER.setItemMeta(treats_meta);

        WITHER_SLAYER = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
        treats_meta = WITHER_SLAYER.getItemMeta();
        treats_meta.setDisplayName("Wither Slayer");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_WITHER) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds a Wither slayer task.", "Cost: 30 Slayer Points" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds a Wither slayer task.", "PURCHASED" ));
        }
        WITHER_SLAYER.setItemMeta(treats_meta);

        WARDEN_SLAYER = new ItemStack(Material.SCULK_SENSOR, 1);
        treats_meta = WARDEN_SLAYER.getItemMeta();
        treats_meta.setDisplayName("Warden Slayer");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_WARDEN) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds a Warden slayer task.", "Cost: 30 Slayer Points" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds a Warden slayer task.", "PURCHASED" ));
        }
        WARDEN_SLAYER.setItemMeta(treats_meta);

        BOSS_RUSH = new ItemStack(Material.NETHER_STAR, 1);
        treats_meta = BOSS_RUSH.getItemMeta();
        treats_meta.setDisplayName("Boss Rush");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_BOSSRUSH) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds a Boss Rush slayer task.", "Includes Ender Dragon, Wither, Elder Guardian, Warden, and Invoker.", "Enables various new item drops and enhanced Slayer Point rewards.", "Cost: 50 Slayer Points" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Adds a Boss Rush slayer task.", "Includes Ender Dragon, Wither, Elder Guardian, Warden, and Invoker.", "Enables various new item drops and enhanced Slayer Point rewards.", "PURCHASED" ));
        }
        BOSS_RUSH.setItemMeta(treats_meta);

        POINT_BOOST = new ItemStack(Material.DIAMOND, 1);
        treats_meta = POINT_BOOST.getItemMeta();
        treats_meta.setDisplayName("Point Boost");
        treats_meta.setCustomModelData(10101);
        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_POINTBOOST) == 1){
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increases the amount of slayer points earned from tasks.", "Cost: 50 Slayer Points" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Increases the amount of slayer points earned from tasks.", "PURCHASED" ));
        }
        POINT_BOOST.setItemMeta(treats_meta);

        BLOCK_SLOT = new ItemStack(Material.IRON_BARS, 1);
        treats_meta = BLOCK_SLOT.getItemMeta();
        treats_meta.setDisplayName("Block Task");
        treats_meta.setCustomModelData(10101);
        if (playerProfile.getSlayerBlock() == null) {
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Blocks your current slayer task from being assigned, and skips it.", "Only one slayer task can be blocked at once.", "Blocked Task - None" ));
        }else{
            treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Blocks your current slayer task from being assigned, and skips it.", "Only one slayer task can be blocked at once.", "Blocked Task - " + playerProfile.getSlayerBlock().toString() ));
        }
        BLOCK_SLOT.setItemMeta(treats_meta);

        BLOCK_SLOT_CLEAR = new ItemStack(Material.IRON_INGOT, 1);
        treats_meta = BLOCK_SLOT_CLEAR.getItemMeta();
        treats_meta.setDisplayName("Clear Blocked Task");
        treats_meta.setCustomModelData(10101);
        treats_meta.setLore(Arrays.asList(ChatColor.WHITE + "Clear your blocked task." ));
        BLOCK_SLOT_CLEAR.setItemMeta(treats_meta);

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


        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(10, SPIDER_SQUASHER);
        gui.setItem(11, SKIP_TASK);
        gui.setItem(12, EXTEND_TASK);
        gui.setItem(13, DRAGON_SLAYER);
        gui.setItem(14, WITHER_SLAYER);
        gui.setItem(15, WARDEN_SLAYER);
        gui.setItem(16, BOSS_RUSH);
        gui.setItem(19, POINT_BOOST);
        gui.setItem(20, BLOCK_SLOT);
        gui.setItem(21, BLOCK_SLOT_CLEAR);
        gui.setItem(22, EXTEND_TASK);
        gui.setItem(23, SKIP_TASK);
        gui.setItem(45, SLAYERTASK);
        gui.setItem(49, BACK_ICON);

        p.openInventory(gui);
    }

}

