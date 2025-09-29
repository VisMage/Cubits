package me.josh.cubits.listeners.bag;

import me.josh.cubits.Main;
import me.josh.cubits.commands.BagCategoryCommand;
import me.josh.cubits.menus.BagCategoryMenu;
import me.josh.cubits.menus.BagCookingMenu;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.CookingItem;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BagCookingListener implements Listener {

    private final Main plugin;
    public BagCookingListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith(ChatColor.DARK_PURPLE + "Cooking")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        int customModelDataValue;
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();

        if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            new BagCategoryCommand().executeCommand(plugin, p, new String[]{"0"});
            return;
        }

        // Check if player has an equipped Cubit
        if(cubit == null){
            return;
        }

        // Create a NamespacedKey
        NamespacedKey key = new NamespacedKey(plugin, "identifier");
        CookingItem item = null;

        // Get the data from the PDC
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING)) {
            item = CubitDatabase.getCookingItem(container.get(key, PersistentDataType.STRING));
        }else{
            System.out.println("Persistat data is null");
            return;
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




        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;
        } else if (e.getCurrentItem().getType().equals(Material.CLOCK)) {

            if(!playerProfile.containsCubitItem(item.getId1())){
                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                return;
            }

            if(item.getAmount2() != 0) {
                if(!playerProfile.containsCubitItem(item.getId2())){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                    return;
                }
            }

            if(item.getAmount3() != 0) {
                if(!playerProfile.containsCubitItem(item.getId3())){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                    return;
                }
            }

            if(item.getAmount4() != 0) {
                if(!playerProfile.containsCubitItem(item.getId4())){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                    return;
                }
            }

            if(item.getAmount5() != 0) {
                if(!playerProfile.containsCubitItem(item.getId5())){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
                    return;
                }
            }

            if(item.getAmount1() == 0 || playerProfile.getCubitItemByIdentifier(item.getId1().getIdentifier()).getAmount() >= item.getAmount1()) {
                if(item.getAmount2() == 0 || playerProfile.getCubitItemByIdentifier(item.getId2().getIdentifier()).getAmount() >= item.getAmount2()) {
                    if(item.getAmount3() == 0 || playerProfile.getCubitItemByIdentifier(item.getId3().getIdentifier()).getAmount() >= item.getAmount3()) {
                        if(item.getAmount4() == 0 || playerProfile.getCubitItemByIdentifier(item.getId4().getIdentifier()).getAmount() >= item.getAmount4()) {
                            if(item.getAmount5() == 0 || playerProfile.getCubitItemByIdentifier(item.getId5().getIdentifier()).getAmount() >= item.getAmount5()) {
                                playerProfile.addCubitItem(item , 1);
                                item.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
                                playerProfile.removeCubitItem(item.getId1() , item.getAmount1());
                                playerProfile.removeCubitItem(item.getId2() , item.getAmount2());
                                playerProfile.removeCubitItem(item.getId3() , item.getAmount3());
                                playerProfile.removeCubitItem(item.getId4() , item.getAmount4());
                                playerProfile.removeCubitItem(item.getId5() , item.getAmount5());
                                BagCookingMenu.OpenBagCooking(plugin, p, 1);
                                SoundUtil.PlaySoundAll(Sound.ENTITY_PLAYER_BURP, 1, 1);
                                return;
                            }
                        }
                    }
                }
            }

            SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
            return;

//            if(playerProfile.getPlayerInventory().get(item.getId1()) >= item.getAmount1()
//                    && playerProfile.getPlayerInventory().get(item.getId2()) >= item.getAmount2()
//                    && playerProfile.getPlayerInventory().get(item.getId3()) >= item.getAmount3()){
//                playerProfile.addItem(item , 1);
//                item.OnConsume(playerProfile.getActiveCubitEntity().getCubit(), playerProfile);
//                playerProfile.removeItem(item.getId1() , item.getAmount1());
//                playerProfile.removeItem(item.getId2() , item.getAmount2());
//                playerProfile.removeItem(item.getId3() , item.getAmount3());
//                playerProfile.removeItem(item.getId4() , item.getAmount4());
//                playerProfile.removeItem(item.getId5() , item.getAmount5());
//                BagCookingMenu.OpenBagCooking(plugin, p, 1);
//                SoundUtil.PlaySoundAll(Sound.ENTITY_PLAYER_BURP, 1, 1);
//                return;
//            }else{
//                SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_NO, 1, 1);
//                return;
//            }

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            new BagCategoryCommand().executeCommand(plugin, p, new String[]{"0"});
            //p.closeInventory();
        }

    }

}
