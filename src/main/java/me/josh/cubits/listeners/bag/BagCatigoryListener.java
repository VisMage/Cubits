package me.josh.cubits.listeners.bag;

import me.josh.cubits.Main;
import me.josh.cubits.commands.MenuCommand;
import me.josh.cubits.menus.BagCookingMenu;
import me.josh.cubits.menus.PlayerInventoryMenu;
import me.josh.cubits.items.ItemType;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BagCatigoryListener implements Listener {
    private final Main plugin;

    public BagCatigoryListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Bag")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;

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

        if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            p.sendMessage("Check skills");
            p.closeInventory();
        } else if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.CAKE)) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            BagCookingMenu.OpenBagCooking(plugin, p, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10101) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            PlayerInventoryMenu.OpenBagByItemType(plugin, p, ItemType.STAT_BOOST_ITEM, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10102) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            PlayerInventoryMenu.OpenBagByItemType(plugin, p, ItemType.DUMMY_ITEM, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10103) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            p.sendMessage("Trinkets coming soon!");
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10104) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            PlayerInventoryMenu.OpenBagByItemType(plugin, p, ItemType.COSMETIC_ITEM, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10105) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            p.sendMessage("Potions coming soon!");
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            new MenuCommand().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }


    }


}
