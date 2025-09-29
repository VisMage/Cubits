package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.lootbox.Lootbox;
import me.josh.cubits.menus.shopkeepers.LootBoxMenu;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LootboxMenuListener implements Listener {

    private final Main plugin;

    public LootboxMenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof Villager) {
            Villager v = (Villager)e.getRightClicked();

            // Open the correct shop menu
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Lootbox Menu")) {
                LootBoxMenu.OpenLootBoxMenu(plugin, p);
                SoundUtil.PlaySoundAll(Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
                //p.sendMessage("Welcome to my shop");
                e.setCancelled(true);
                return;
            }


            // End of checking which villager was right-clicked
        }
    }



    // Check for clicks on items
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Loot Box Menu")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create a NamespacedKey
        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        ItemBase usedItem = null;

        // Get the data from the PDC
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING)) {
            usedItem = CubitDatabase.getDummyItem(container.get(key, PersistentDataType.STRING));
        }

        //Fix error?
        if (e.getCurrentItem() == null) {
            return;
        }

        // Check if clicked item has CustomModelData. If it does, saves it to int. If not, int set to 0.
        if (e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasCustomModelData()) {
            customModelDataValue = e.getCurrentItem().getItemMeta().getCustomModelData();
        } else {
            customModelDataValue = 0;
        }

        // Check for individual item types, CustomModelData, or Item Name
        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;

        } else if (e.getCurrentItem().getType().equals(Material.CLOCK)) {

            if(!playerProfile.containsCubitItem(usedItem)) {
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                return;
            }

            if(playerProfile.getCubitItemByIdentifier(usedItem.getIdentifier()).getAmount() == 0){
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                return;
            }

            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            playerProfile.removeCubitItem(usedItem, 1);

            if(usedItem == ItemBase.KEY_MOSSY){
                Lootbox.MOSSY_LOOTBOX.getWeightedLootboxEnteries().getWeightedValue().obtain(playerProfile);
            }
            if(usedItem == ItemBase.KEY_DUSTY){
                Lootbox.DUSTY_LOOTBOX.getWeightedLootboxEnteries().getWeightedValue().obtain(playerProfile);
            }
            if(usedItem == ItemBase.KEY_ICY){
                Lootbox.FROSTY_LOOTBOX.getWeightedLootboxEnteries().getWeightedValue().obtain(playerProfile);
            }

            LootBoxMenu.OpenLootBoxMenu(plugin, p);
            return;

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
        }


    }


    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getView().getTitle().equals("Lootbox Menu")) {
            e.setCancelled(true);
        }
    }
    //End
}
