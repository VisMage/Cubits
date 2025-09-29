package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.commands.PetMenuCommand;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SummeryListener implements Listener {

    private final Main plugin;

    public SummeryListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().startsWith(ChatColor.DARK_PURPLE + "Summery")) return;
        if (e.getClickedInventory() == null) return;
        if (!e.getClickedInventory().equals(e.getView().getTopInventory())) return; // Error line, added above null check
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());


        if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            e.getWhoClicked().closeInventory();

        } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            new PetMenuCommand().executeCommand(plugin, player, new String[]{"1"});

        } else if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
            return;

        } else if (e.getCurrentItem().getType().equals(Material.GRAY_DYE)) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            //Check if player has cubit equipped
            if (playerProfile.getActiveCubitEntity().getCubit() != null){
                //Despawn cubit
                playerProfile.getActiveCubitEntity().UnequipCubit();
                //Send message
                e.getWhoClicked().sendMessage(ChatColor.RED + "Cubit was unequipped.");
                e.getWhoClicked().closeInventory();

            }else {
                e.getWhoClicked().sendMessage(ChatColor.RED + "You don't have a cubit equipped!");
                return;
            }

        } else if (e.getCurrentItem().getType().equals(Material.LEAD)) {
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
            //Check if player has cubit equipped
            if (playerProfile.getActiveCubitEntity().getCubit() != null){
                //Despawn cubit
                playerProfile.getActiveCubitEntity().UnequipCubit();
                //Send message
                e.getWhoClicked().sendMessage(ChatColor.RED + "Cubit was unequipped.");
                e.getWhoClicked().closeInventory();
            }else {
                e.getWhoClicked().sendMessage(ChatColor.RED + "You don't have a cubit equipped!");
                return;
            }


        } //ADD MORE CLICKABLE ITEMS HERE (with an else if)




    }


}
