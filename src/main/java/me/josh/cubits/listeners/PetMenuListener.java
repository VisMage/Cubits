package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.commands.MenuCommand;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.menus.RebirthMenu;
import me.josh.cubits.menus.PetMenu;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;


public class PetMenuListener implements Listener {

    private final Main plugin;
    private static final  String ERROR_COLOR = "&c";

    public PetMenuListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().startsWith(ChatColor.DARK_PURPLE + "Cubits")) return;
        //if (!e.getClickedInventory().equals(e.getView().getTopInventory())) return;
        if (e.getCurrentItem() == null) return;
        Player player = (Player) e.getWhoClicked();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        e.setCancelled(true);

        if (e.getCurrentItem().getType().equals(Material.BARRIER)) {

            new MenuCommand().executeCommand(plugin, player, new String[]{"0"});
            //e.getWhoClicked().closeInventory();

        } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {

            int page = Integer.parseInt(e.getView().getTitle().replace(ChatColor.DARK_PURPLE + "Cubits - page ", ""));
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Back")) {
                PetMenu.OpenPetMenu(plugin, player, page - 1);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Next")) {
                PetMenu.OpenPetMenu(plugin, player, page + 1);
            }

        } else if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
            if (!e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Current Cubit")) {

                /*if(plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId()).getActiveCubit() != null) {
                    Cubit current = plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId()).getActiveCubit().getCubit();
                }

                if (current != null) {
                    // Do nothing, and play a noteblock sound
                }*/

                // Create a NamespacedKey
                NamespacedKey key = new NamespacedKey(plugin, "uuid");

                // Get the data from the PDC
                PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
                if (container.has(key, PersistentDataType.STRING)) {
                    UUID cubitUUID = UUID.fromString(container.get(key, PersistentDataType.STRING));
                    Cubit selectedCubit = playerProfile.getCubitByUUID(cubitUUID);
                    if(selectedCubit != null) {
                        // Equip Cubit
                        playerProfile.equipActiveCubit(plugin, player, selectedCubit);
                        e.getWhoClicked().closeInventory();

                        Utils.msg(player, "&aEquipped " + playerProfile.getActiveCubitEntity().getCubit().getName());
                        //Utils.msg(player, "&aEquipped Cubit UUID is " + playerProfile.getActiveCubit().getCubit().getUuid().toString());
                    }else{
                        Utils.msg(player, String.format("%sError equipping Cubit in PetMenuListener class!", ERROR_COLOR));
                    }
                }
            }
        } else if (e.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
            //e.getWhoClicked().sendMessage(ChatColor.RED + "Rebirth coming soon!");
            RebirthMenu.OpenRebirthMenu(plugin, player, 1);

        } else if (e.getCurrentItem().getType().equals(Material.LEAD)) {

            //Check if player has a cubit equipped
            if (plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).getActiveCubitEntity() == null) {
                e.getWhoClicked().sendMessage(ChatColor.RED + "You don't have a cubit equipped!");
                return;
            }

            //Unequip cubit
            playerProfile.getActiveCubitEntity().UnequipCubit();
            Utils.msg(player, "&aUnequipped a Cubit!");
            e.getWhoClicked().closeInventory();
        }




    }


}
