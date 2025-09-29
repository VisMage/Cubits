package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.commands.MenuCommand;
import me.josh.cubits.commands.SummeryCommand;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerStatMenuListener implements Listener {
    private final Main plugin;

    public PlayerStatMenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        if (!e.getView().getTitle().startsWith("Stat Menu")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        int customModelDataValue;

        //Fix error?
        if(e.getCurrentItem() == null){
            return;
        }

        // Check if clicked item has CustomModelData. If it does, saves it to int. If not, int set to 0.
        if(e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasCustomModelData()){
            customModelDataValue = e.getCurrentItem().getItemMeta().getCustomModelData();
        }else{
            customModelDataValue = 0;
        }

        // Check for individual item types, CustomModelData, or Item Name
        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)){
            return;
        }else if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){
            if(playerProfile.getActiveCubitEntity().getCubit() != null) {
                new SummeryCommand().executeCommand(plugin, p, new String[]{"1"});
            }
        }else if (e.getCurrentItem().getType().equals(Material.BARRIER)){
            new MenuCommand().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }else if (e.getCurrentItem().getType().equals(Material.GRAY_DYE)){
            return;
        }else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 10010){ // Options
            return;
        }


    }

}
