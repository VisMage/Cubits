package me.josh.cubits.menus.shopkeepers;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
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
import java.util.List;

public class BobaShop extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static final String INVENTORY_NAME = "Boba Shop";

    private BobaShop() {}

    public static void OpenBobaShop(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Set items into their proper slots
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(49, QUIT_MENU_ICON);

        // Add sellable items
        if(SetDailyShopStock.boba_store_Item1 != null){
            gui.addItem(getSellableItemStack(SetDailyShopStock.boba_store_Item1, playerProfile, plugin));
        }

        if(SetDailyShopStock.boba_store_Item2 != null){
            gui.addItem(getSellableItemStack(SetDailyShopStock.boba_store_Item2, playerProfile, plugin));
        }

        if(SetDailyShopStock.boba_store_Item3 != null){
            gui.addItem(getSellableItemStack(SetDailyShopStock.boba_store_Item3, playerProfile, plugin));
        }

//        if(SetDailyShopStock.general_store_Item4 != null){
//            if(playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_SELLSHOP) >= 50){
//                gui.addItem(getSellableItemStack(SetDailyShopStock.sell_Item4, playerProfile, plugin));
//            }
//        }
//
//        if(SetDailyShopStock.general_store_Item5 != null){
//            if(playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_SELLSHOP) >= 100){
//                gui.addItem(getSellableItemStack(SetDailyShopStock.sell_Item5, playerProfile, plugin));
//            }
//        }


        p.openInventory(gui);
    }

    private static ItemStack getSellableItemStack(ItemBase sellShopItem, PlayerProfile playerProfile, Main plugin) {
        if(sellShopItem == null)
            return null;

        ItemStack shopItem = new ItemStack(Material.CLOCK, 1);
        ItemMeta shopItemMeta = shopItem.getItemMeta();
        shopItemMeta.setDisplayName(sellShopItem.getName());
        shopItemMeta.setCustomModelData(sellShopItem.getCustomModelData());

        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        shopItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, sellShopItem.getIdentifier());

        List<String> lore = new ArrayList<>();
        lore.add(sellShopItem.getDescription());
        lore.add(ChatColor.WHITE + "Sell: " + sellShopItem.getCost() + " Coins");

        if(!playerProfile.containsCubitItem(sellShopItem)) {
            lore.add(ChatColor.WHITE + "Amount: 0");
        }else{
            lore.add(ChatColor.WHITE + "Amount: " + playerProfile.getCubitItemByIdentifier(sellShopItem.getIdentifier()).getAmount());
        }

        shopItemMeta.setLore(lore);
        shopItem.setItemMeta(shopItemMeta);

        return shopItem;
    }

}
