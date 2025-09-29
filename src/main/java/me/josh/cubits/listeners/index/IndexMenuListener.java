package me.josh.cubits.listeners.index;

import me.josh.cubits.Main;
import me.josh.cubits.commands.MenuCommand;
import me.josh.cubits.menus.index.IndexMenuCosmetic;
import me.josh.cubits.menus.index.IndexMenuCubit;
import me.josh.cubits.menus.index.IndexMenuDummy;
import me.josh.cubits.menus.index.IndexMenuTreats;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class IndexMenuListener implements Listener {

    private final Main plugin;

    public IndexMenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Index")) return;
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
        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10106) {
            IndexMenuCubit.OpenIndexMenuCubit(plugin, p, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10101) {
            IndexMenuTreats.OpenIndexMenuTreats(plugin, p, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10102) {
            IndexMenuDummy.OpenIndexMenuDummy(plugin, p, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10103) {
            //TRINKETS HERE
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10104) {
            IndexMenuCosmetic.OpenIndexMenuCosmetic(plugin, p, 1);
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10105) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            new MenuCommand().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }

    }

}
