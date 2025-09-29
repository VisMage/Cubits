package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.commands.SubCommand;
import me.josh.cubits.menus.shopkeepers.CubitGui;
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

public class BagCategoryMenu extends CubitGui {
    private static final int INVENTORY_SIZE = 27;
    private static final String INVENTORY_NAME = "Bag Category";
    private static final ItemStack BACK_ICON;
    private static final ItemStack TREATS_ICON;
    private static final ItemStack DUMMY_ITEMS_ICON;
    private static final ItemStack TRINKETS_ICON;
    private static final ItemStack SKIN_ITEMS_ICON;
    private static final ItemStack POTIONS_ICON;
    private static final ItemStack COOKING_ICON;

    static {
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);

        TREATS_ICON = new ItemStack(Material.CLOCK, 1);
        ItemMeta treats_meta = TREATS_ICON.getItemMeta();
        treats_meta.setDisplayName("Treats");
        treats_meta.setCustomModelData(10101);
        TREATS_ICON.setItemMeta(treats_meta);

        DUMMY_ITEMS_ICON = new ItemStack(Material.CLOCK, 1);
        ItemMeta dummyItems_meta = DUMMY_ITEMS_ICON.getItemMeta();
        dummyItems_meta.setDisplayName("Items");
        dummyItems_meta.setCustomModelData(10102);
        DUMMY_ITEMS_ICON.setItemMeta(dummyItems_meta);

        TRINKETS_ICON = new ItemStack(Material.CLOCK, 1);
        ItemMeta trinkets_meta = TRINKETS_ICON.getItemMeta();
        trinkets_meta.setDisplayName("Trinkets");
        trinkets_meta.setCustomModelData(10103);
        TRINKETS_ICON.setItemMeta(trinkets_meta);

        SKIN_ITEMS_ICON = new ItemStack(Material.CLOCK, 1);
        ItemMeta skinItems_meta = SKIN_ITEMS_ICON.getItemMeta();
        skinItems_meta.setDisplayName("Cosmetics");
        skinItems_meta.setCustomModelData(10104);
        SKIN_ITEMS_ICON.setItemMeta(skinItems_meta);

        POTIONS_ICON = new ItemStack(Material.CLOCK, 1);
        ItemMeta potions_meta = POTIONS_ICON.getItemMeta();
        potions_meta.setDisplayName("Potions");
        potions_meta.setCustomModelData(10105);
        POTIONS_ICON.setItemMeta(potions_meta);

        COOKING_ICON = new ItemStack(Material.CAKE, 1);
        ItemMeta cooking_meta = COOKING_ICON.getItemMeta();
        cooking_meta.setDisplayName("Cooking");
        //cooking_meta.setCustomModelData(10101);
        COOKING_ICON.setItemMeta(cooking_meta);
    }

    public static void openBagCategoryMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(11, TREATS_ICON);
        gui.setItem(12, DUMMY_ITEMS_ICON);
        gui.setItem(13, TRINKETS_ICON);
        gui.setItem(14, SKIN_ITEMS_ICON);
        gui.setItem(15, POTIONS_ICON);
        gui.setItem(22, BACK_ICON);
        gui.setItem(26, COOKING_ICON);

        p.openInventory(gui);
    }

}
