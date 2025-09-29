package me.josh.cubits.listeners.bag;

import me.josh.cubits.Main;
import me.josh.cubits.commands.BagCategoryCommand;
import me.josh.cubits.items.ItemType;
import me.josh.cubits.menus.BagCategoryMenu;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.menus.PlayerInventoryMenu;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BagTreatListener implements Listener {
    private final Main plugin;

    public BagTreatListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Treat Bag")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();

        // Check if player has an equipped Cubit
        if(cubit == null){
            return;
        }

        // Create a NamespacedKey
        NamespacedKey key = new NamespacedKey(plugin, "itemIdentifier");
        ItemBase usedItem = null;

        // Get the data from the PDC
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING)) {
            usedItem = CubitDatabase.getStatBoostItem(container.get(key, PersistentDataType.STRING)); //Returns null
        }

        // Check if clicked item has CustomModelData. If it does, saves it to int. If not, int set to 0.
        if (e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasCustomModelData()) {
            customModelDataValue = e.getCurrentItem().getItemMeta().getCustomModelData();
        } else {
            customModelDataValue = 0;
        }

        // TODO: Add a check to make sure the clicked clock has persistent data container
        // Check for individual item types, CustomModelData, or Item Name

        if (e.getCurrentItem().getType().equals(Material.CLOCK)) {
            usedItem.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
            playerProfile.removeCubitItem(usedItem , 1);
            PlayerInventoryMenu.OpenBagByItemType(plugin, p, ItemType.STAT_BOOST_ITEM, 1);
            SoundUtil.PlaySoundAll(Sound.ENTITY_PLAYER_BURP, 1, 1);
        }

    }

    @EventHandler
    public void onMenuClickBarrier(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Treat Bag")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();

        // Check for individual item types, CustomModelData, or Item Name
        if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            BagCategoryMenu.openBagCategoryMenu(plugin, p);
            //p.closeInventory();
        }

    }


}
