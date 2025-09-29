package me.josh.cubits.listeners.bag;

import me.josh.cubits.Main;
import me.josh.cubits.commands.BagCategoryCommand;
import me.josh.cubits.menus.BagCategoryMenu;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BagDummyListener implements Listener {
    private final Main plugin;

    public BagDummyListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Item Bag")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            new BagCategoryCommand().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }


    }

}
