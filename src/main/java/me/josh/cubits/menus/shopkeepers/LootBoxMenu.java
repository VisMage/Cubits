package me.josh.cubits.menus.shopkeepers;

import me.josh.cubits.Main;
import me.josh.cubits.items.CubitItemStack;
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

public class LootBoxMenu extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static final String INVENTORY_NAME = "Loot Box Menu";

    private LootBoxMenu() {

    }

    public static void OpenLootBoxMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Set items into their proper slots
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(49, QUIT_MENU_ICON);

        // Create Items
        gui.setItem(10, getLootBoxKeyItem(plugin, playerProfile, ItemBase.KEY_MOSSY));
        gui.setItem(11, getLootBoxKeyItem(plugin, playerProfile, ItemBase.KEY_DUSTY));
        gui.setItem(12, getLootBoxKeyItem(plugin, playerProfile, ItemBase.KEY_ICY));

        p.openInventory(gui);
    }

    private static ItemStack getLootBoxKeyItem(Main plugin, PlayerProfile playerProfile, ItemBase keyItemBase) {
        if(keyItemBase == null)
            return null;

        ItemStack shopItem = new ItemStack(Material.CLOCK, 1);
        ItemMeta shopItemMeta = shopItem.getItemMeta();
        shopItemMeta.setDisplayName(keyItemBase.getName());
        shopItemMeta.setCustomModelData(keyItemBase.getCustomModelData());

        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        shopItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, keyItemBase.getIdentifier());

        ArrayList<String> lore = new ArrayList<>();
        lore.add(keyItemBase.getDescription());

        CubitItemStack itemStack1 = playerProfile.getCubitItemByIdentifier(keyItemBase.getIdentifier());
        if(itemStack1 == null){
            lore.add(ChatColor.WHITE + "Amount: 0");
        }else{
            lore.add(ChatColor.WHITE + "Amount: " + itemStack1.getAmount());
        }

        shopItemMeta.setLore(lore);
        shopItem.setItemMeta(shopItemMeta);

        return shopItem;
    }

}
