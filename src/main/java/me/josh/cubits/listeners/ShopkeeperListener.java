package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.menus.shopkeepers.GeneralStoreMenu;
import me.josh.cubits.menus.shopkeepers.SetDailyShopStock;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ShopkeeperListener implements Listener {

    private final Main plugin;

    public ShopkeeperListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        if(e.getRightClicked() instanceof Villager) {
            Villager v = (Villager)e.getRightClicked();

            // Open the correct shop menu
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Treat Shop")) {
                GeneralStoreMenu.OpenTreatStore(plugin, p, "Treat Shop", SetDailyShopStock.general_store_Item1, SetDailyShopStock.general_store_Item2, SetDailyShopStock.general_store_Item3, SetDailyShopStock.general_store_Item4, SetDailyShopStock.general_store_Item5, playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_GENERALSHOP));
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_YES, 1, 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Carrot: " + ChatColor.WHITE + "Welcome to my tasty treat shop! Anything catch your eye?");
                e.setCancelled(true);
                return;
            }

            // Open the correct shop menu
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("Desert Trader")) {
                GeneralStoreMenu.OpenTreatStore(plugin, p, "Desert Trader", SetDailyShopStock.desert_store_Item1, SetDailyShopStock.desert_store_Item2, SetDailyShopStock.desert_store_Item3, SetDailyShopStock.desert_store_Item4, SetDailyShopStock.desert_store_Item5, playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_DESERT_TRADER));
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_YES, 1, 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Shayde: " + ChatColor.WHITE + "Welcome weary traveler!");
                e.setCancelled(true);
                return;
            }



        // End of checking which villager was right-clicked
        }
    }



    // Check for clicks on items
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        String tempShopName;

        if (e.getView().getTitle().startsWith("Treat Shop")){
            tempShopName = "Treat Shop";
        }else if (e.getView().getTitle().startsWith("Desert Trader")){
            tempShopName = "Desert Trader";
        }else{
            return;
        }

        if (e.getCurrentItem() == null) return;
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

            if(money == 0){
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                return;
            }

            if(money < usedItem.getCost()){
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                return;
            }

            SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_TRADE, 1, 1);
            playerProfile.removeMiniGameTokens(MiniGameToken.COINS, usedItem.getCost());
            playerProfile.addCubitItem(usedItem, 1);

            if(tempShopName.equals("Treat Shop")){
                playerProfile.addPlayerVariables(PlayerVariables.FAVOR_GENERALSHOP, 1);
                GeneralStoreMenu.OpenTreatStore(plugin, p, "Treat Shop", SetDailyShopStock.general_store_Item1, SetDailyShopStock.general_store_Item2, SetDailyShopStock.general_store_Item3, SetDailyShopStock.general_store_Item4, SetDailyShopStock.general_store_Item5, playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_GENERALSHOP));
            }else if(tempShopName.equals("Desert Trader")){
                playerProfile.addPlayerVariables(PlayerVariables.FAVOR_DESERT_TRADER, 1);
                GeneralStoreMenu.OpenTreatStore(plugin, p, "Desert Trader", SetDailyShopStock.desert_store_Item1, SetDailyShopStock.desert_store_Item2, SetDailyShopStock.desert_store_Item3, SetDailyShopStock.desert_store_Item4, SetDailyShopStock.desert_store_Item5, playerProfile.getPlayerVariables().get(PlayerVariables.FAVOR_DESERT_TRADER));
            }else{
                return;
            }


        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
        }


    }


    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getView().getTitle().equals("Treat Shop") || e.getView().getTitle().equals("Desert Trader")) {
            e.setCancelled(true);
        }
    }


  //End
}
