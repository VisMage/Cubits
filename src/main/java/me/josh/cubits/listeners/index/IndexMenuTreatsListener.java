package me.josh.cubits.listeners.index;

import me.josh.cubits.Main;
import me.josh.cubits.menus.index.IndexMenu;
import me.josh.cubits.menus.index.IndexMenuTreats;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

public class IndexMenuTreatsListener implements Listener {

    private final Main plugin;

    public IndexMenuTreatsListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Treat Index")) return;
        if (e.getCurrentItem() == null) return;
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();

        // Check for clicked item
        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
            NamespacedKey changeKey = new NamespacedKey(plugin, "changePage");
            if(e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(changeKey)){
                int page = e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(changeKey, PersistentDataType.INTEGER);
                IndexMenuTreats.OpenIndexMenuTreats(plugin, p, page);
            }
//
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            new IndexMenu().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }

    }

}
