package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.menus.FishermanMenu;
import me.josh.cubits.menus.FishingTask;
import me.josh.cubits.menus.FishingUpgradeShop;
import me.josh.cubits.menus.TreasureTrackerMenu;
import me.josh.cubits.menus.shopkeepers.FishermanShop;
import me.josh.cubits.menus.shopkeepers.SetDailyShopStock;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.treasuretracker.TreasureTrackingManager;
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

public class TreasureTrackerMenuListener implements Listener {
    private final Main plugin;

    public TreasureTrackerMenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        if(e.getRightClicked() instanceof Villager) {
            Villager v = (Villager)e.getRightClicked();

            // Open the correct shop menu (Add other slayer master later)
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Montgomery")) {
                TreasureTrackerMenu.openTreasureTrackerMenu(plugin, p);
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_YES, 1, 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Montgomery: " + ChatColor.WHITE + "You came at the right time ol' bean, I'm hot on a new lead!");
                e.setCancelled(true);
                return;
            }
            // Add other slayer masters here

            // End of checking which villager was right-clicked
        }
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Treasure Tracker")) return;
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
        } else if (e.getCurrentItem().getType().equals(Material.COMPASS)) {
            if (!plugin.getTreasureTrackingManager().hasActiveTreasure(p)) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                plugin.getTreasureTrackingManager().startTreasureTracking(p);
                p.closeInventory();
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
                plugin.getTreasureTrackingManager().giveCurrentTreasureCompass(p);
                p.closeInventory();
            }
        } else if (e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
            FishermanShop.OpenFishermanShop(plugin, p, "Fisherman Shop", SetDailyShopStock.fishing_store_Item1, SetDailyShopStock.fishing_store_Item2, SetDailyShopStock.fishing_store_Item3, playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_FISHERMAN));
        } else if (e.getCurrentItem().getType().equals(Material.MAP)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);

        } else if (e.getCurrentItem().getType().equals(Material.PAPER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
        } else if (e.getCurrentItem().getType().equals(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
            FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            p.closeInventory();
        }

    }



}
