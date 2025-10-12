package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.menus.shopkeepers.BobaShop;
import me.josh.cubits.menus.shopkeepers.SellItemStore;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class SellitemStoreListener implements Listener {

    private final Main plugin;

    public SellitemStoreListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof Villager) {
            Villager v = (Villager)e.getRightClicked();

            // Open the correct shop menu
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Sell Shop")) {
                SellItemStore.OpenSellItemStore(plugin, p);
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_YES, 1, 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Jace: " + ChatColor.WHITE + "You got the goods? I got the coin!");
                e.setCancelled(true);
                return;
            }

            // End of checking which villager was right-clicked
        }

        if(e.getRightClicked() instanceof Frog) {
            Frog v = (Frog) e.getRightClicked();

            // Open the correct shop menu
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Boba")){
                BobaShop.OpenBobaShop(plugin, p);
                SoundUtil.PlaySoundAll(Sound.ENTITY_FROG_AMBIENT, 1, 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Boba: " + ChatColor.WHITE + "Ribbit ribbit!");
                e.setCancelled(true);
                return;
            }

            // End of checking which villager was right-clicked
        }




    }



    // Check for clicks on items
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Sell Shop") && !e.getView().getTitle().startsWith("Boba Shop")) return;
        if (e.getCurrentItem() == null) return;
        int shopID = 1;

        if(e.getView().getTitle().startsWith("Boba Shop")){
            shopID = 2;
        }

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create a NamespacedKey
        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        ItemBase usedItem = null;

        // Get the data from the PDC
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING)) {
            usedItem = CubitDatabase.getAllItem(container.get(key, PersistentDataType.STRING));
        }

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
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK)) {

            int money = 0;
            money = playerProfile.getMiniGameTokens().get(MiniGameToken.COINS);

            if(!playerProfile.containsCubitItem(usedItem)){
                if(shopID == 2){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_FROG_DEATH, 1, 1);
                }else{
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                }
                return;
            }

            if(playerProfile.getCubitItemByIdentifier(usedItem.getIdentifier()).getAmount() == 0){
                if(shopID == 2){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_FROG_DEATH, 1, 1);
                }else{
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                }
                return;
            }

            if(shopID == 2){
                SoundUtil.PlaySoundAll(Sound.ENTITY_FROG_EAT, 1, 1);
                playerProfile.addPlayerVariables(PlayerVariables.FAVOR_BOBA, 1);
                BobaShop.OpenBobaShop(plugin, p);
            }else{
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_TRADE, 1, 1);
                playerProfile.addPlayerVariables(PlayerVariables.FAVOR_SELLSHOP, 1);
                SellItemStore.OpenSellItemStore(plugin, p);
            }

            playerProfile.addMiniGameTokens(MiniGameToken.COINS, usedItem.getCost());
            playerProfile.removeCubitItem(usedItem, 1);
            return;

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            p.closeInventory();
        }



    }






    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getView().getTitle().equals("Sell Shop") || e.getView().getTitle().equals("Boba Shop")) {
            e.setCancelled(true);
        }
    }
    //End
}
