package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.menus.SlayerMenu;
import me.josh.cubits.menus.SlayerTask;
import me.josh.cubits.menus.SlayerUpgradeShop;
import me.josh.cubits.menus.shopkeepers.SetDailyShopStock;
import me.josh.cubits.menus.shopkeepers.SlayerShop;
import me.josh.cubits.playerdata.MiniGameToken;
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
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT) == 0) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                SlayerTask.getRandomEntry(plugin, p);
            }else if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT) >= playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT)){
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                int reward = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_POINTS_REWARD);
                playerProfile.addMiniGameTokens(MiniGameToken.SLAYER_TOKENS, reward);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_POINTS_REWARD, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_TARGET_AMOUNT, 0);
                playerProfile.addPlayerVariables(PlayerVariables.SLAYER_COMPLETED, 1);
                playerProfile.addPlayerVariables(PlayerVariables.SLAYER_STREAK, 1);
                SlayerTask.getRandomEntry(plugin, p);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }
            SlayerMenu.openSlayerMenu(plugin, p);
        } else if (e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
            SlayerShop.OpenSlayerStore(plugin, p, "Slayer Shop", SetDailyShopStock.slayer_store_Item1, SetDailyShopStock.slayer_store_Item2, SetDailyShopStock.slayer_store_Item3, playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_SLAYER_SHOP));
        } else if (e.getCurrentItem().getType().equals(Material.MAP)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);

        } else if (e.getCurrentItem().getType().equals(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
            SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            p.closeInventory();
        }

    }



}
