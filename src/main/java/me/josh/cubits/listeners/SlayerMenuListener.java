package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.menus.SlayerMenu;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class SlayerMenuListener implements Listener {
    private final Main plugin;

    public SlayerMenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        if(e.getRightClicked() instanceof Villager) {
            Villager v = (Villager)e.getRightClicked();

            // Open the correct shop menu (Add other slayer master later)
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Slayer Master")) {
                SlayerMenu.openSlayerMenu(plugin, p);
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_YES, 1, 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Gregor: " + ChatColor.WHITE + "Aye, lookin' for a slayer task?");
                e.setCancelled(true);
                return;
            }
            // Add other slayer masters here

            // End of checking which villager was right-clicked
        }
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Slayer Menu")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
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
        } else if (e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT) == 0 || playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT) >= playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT)) {
                // GIVE NEW SLAYER TASK
            }
            //Add test to give new slayer task, and claim prior reward. Add actual slayer master to claim and shop
            //Also add quest claiming
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
        }


        // ADD Redeem slayer task if above target, and give task. If target is 0, just give task
        // ADD slayer shop menu


    }





}
