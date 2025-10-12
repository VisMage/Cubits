package me.josh.cubits.menus.shopkeepers;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class FishermanShop extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static String INVENTORY_NAME;

    private FishermanShop(){

    }

    public static void OpenFishermanShop(Main plugin, Player p, String shopName, ItemBase item1, ItemBase item2, ItemBase item3, int favor) {
        // Set Inventory Name
        INVENTORY_NAME = shopName;

        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Set items into their proper slots
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(49, QUIT_MENU_ICON);

        ItemStack FAVOR_ICON = new ItemStack(Material.NETHER_STAR);
        ItemMeta favorMeta = FAVOR_ICON.getItemMeta();
        favorMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Favor " + favor);
        ArrayList<String> loreFavor = new ArrayList<>();
        loreFavor.add("Highor favor unlocks shop slots and rarer items.");
        loreFavor.add("Unlock rarer items at higher favor.");
        favorMeta.setLore(loreFavor);
        FAVOR_ICON.setItemMeta(favorMeta);
        gui.setItem(45, FAVOR_ICON);


        // Create Items
        if(SetDailyShopStock.fishing_store_Item1 != null){
            gui.addItem(getShopItem(plugin, item1));
        }

        if(SetDailyShopStock.fishing_store_Item2 != null){
            gui.addItem(getShopItem(plugin, item2));
        }

        if(SetDailyShopStock.fishing_store_Item3 != null){
            gui.addItem(getShopItem(plugin, item3));
        }

        p.openInventory(gui);
    }

    private static ItemStack getShopItem(Main plugin, ItemBase dailyItemBase) {
        ItemStack shopItem = new ItemStack(Material.CLOCK, 1);
        ItemMeta shopItemMeta = shopItem.getItemMeta();
        shopItemMeta.setDisplayName(dailyItemBase.getName());
        shopItemMeta.setCustomModelData(dailyItemBase.getCustomModelData());

        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        shopItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, dailyItemBase.getIdentifier());

        ArrayList<String> lore = new ArrayList<>();
        lore.add(dailyItemBase.getDescription());
        lore.add(ChatColor.WHITE + "Cost: " + dailyItemBase.getCost() + " Coins");

        shopItemMeta.setLore(lore);
        shopItem.setItemMeta(shopItemMeta);

        return shopItem;
    }


}

