package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class StarterListener implements Listener {
    private final Main plugin;

    public StarterListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Choose your Starter!")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
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
        String chosenStarter = null;
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "clickedHead");

        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;
        } else if (container.has(key, PersistentDataType.STRING)) {
            chosenStarter = container.get(key, PersistentDataType.STRING);
            p.closeInventory();
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK) && customModelDataValue == 1010) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
            return;
        }

        if(chosenStarter == null) {
            Utils.msg(p, "Error in StarterListener class! Returned null!");
            return;
        }

        // Give starter Cubit, and set as active Cubit
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        CubitBase cubitBase = CubitDatabase.getCubitBase(chosenStarter);
        plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId()).addCubit(cubitBase);

        Utils.msg(p, "Your " + cubitBase.getName() + " look up at you endearingly!");

        // Equip your first Cubit in the Cubit Menu
        UUID cubitUUID = playerProfile.getCubits().get(0).getUuid();
        Cubit selectedCubit = playerProfile.getCubitByUUID(cubitUUID);
        playerProfile.equipActiveCubit(plugin, p, selectedCubit);
        playerProfile.addPlayerVariables(PlayerVariables.IF_STARTER, 1);

        // Give Starting Recipes and Gold
        playerProfile.addMiniGameTokens(MiniGameToken.COINS, 50);
        playerProfile.addCubitItem(ItemBase.HONEYBUN, 1);
        playerProfile.addCubitItem(ItemBase.SAPPLEBERRY_PIE, 1);
        playerProfile.addCubitItem(ItemBase.BREAD, 1);
        playerProfile.addCubitItem(ItemBase.COBBLEROLL, 1);

        // Close Inventory
        e.getWhoClicked().closeInventory();

    }

}
