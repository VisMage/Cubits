package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.menus.TreasureChest;
import me.josh.cubits.menus.shopkeepers.ShopkeeperRandomStock;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class TreasureChestListener implements Listener {

    private final Main plugin;

    public TreasureChestListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Treasure Chest")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Check if clicked item has CustomModelData. If it does, saves it to int. If not, int set to 0.
        if (e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasCustomModelData()) {
            customModelDataValue = e.getCurrentItem().getItemMeta().getCustomModelData();
        } else {
            customModelDataValue = 0;
        }

        // Check for individual item types, CustomModelData, or Item Name
        if (e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)) {

            ItemBase reward;
            int treasureType;

            if (e.getView().getTitle().startsWith("Treasure Chest - Foraging")) {
                reward = ShopkeeperRandomStock.FORAGING_TREASURE.getRandomEntry();
                treasureType = 2;
            } else if (e.getView().getTitle().startsWith("Treasure Chest - Mining")) {
                reward = ShopkeeperRandomStock.MINING_TREASURE.getRandomEntry();
                treasureType = 3;
            } else {
                reward = ShopkeeperRandomStock.FISHING_TREASURE.getRandomEntry();
                treasureType = 1;
            }

            playerProfile.addCubitItem(reward, 1);
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);

            if(customModelDataValue == 1){
                new TreasureChest().OpenTreasureChest(plugin, p, reward, treasureType, 1);
            } else if(customModelDataValue == 2){
                new TreasureChest().OpenTreasureChest(plugin, p, reward, treasureType, 2);
            } else if(customModelDataValue == 3){
                new TreasureChest().OpenTreasureChest(plugin, p, reward, treasureType, 3);
            }

            //playerProfile.removeCubitItem(usedItem, 1);
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
        }

    }


    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getView().getTitle().startsWith("Treasure Chest")) {
            e.setCancelled(true);
        }
    }
    //End
}
