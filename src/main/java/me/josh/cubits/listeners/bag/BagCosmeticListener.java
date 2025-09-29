package me.josh.cubits.listeners.bag;

import me.josh.cubits.Main;
import me.josh.cubits.commands.BagCategoryCommand;
import me.josh.cubits.menus.BagCategoryMenu;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
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

public class BagCosmeticListener implements Listener {
    private final Main plugin;

    public BagCosmeticListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Cosmetic Bag")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();
        //ItemBase usedItem = e.getCurrentItem().getItemMeta().getPersistentDataContainer()

        // Check if player has an equipped Cubit
        if(cubit == null){
            return;
        }

        // Create a NamespacedKey
        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        ItemBase usedItem = null;

        // Get the data from the PDC
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING)) {
            usedItem = CubitDatabase.getCosmeticItem(container.get(key, PersistentDataType.STRING));
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
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            usedItem.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
            playerProfile.removeCubitItem(usedItem , 1);
            //BagCosmeticMenu.OpenBagCosmetics(plugin, p, 1);
            return;

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            new BagCategoryCommand().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }



    }


}
