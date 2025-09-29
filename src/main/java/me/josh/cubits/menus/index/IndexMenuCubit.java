package me.josh.cubits.menus.index;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.cubitentity.CreateHead;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.UUID;

public class IndexMenuCubit {

    private static final  String ERROR_COLOR = "&c";
    private static final int ITEMS_PER_PAGE = 28;

    private IndexMenuCubit(){}

    public static void OpenIndexMenuCubit(Main plugin, Player p, int page) {

        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        if(page == 0){page = 1;}

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, 54, "Cubit Index - Page " + page);

        // Create Items to place in inventory
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = back.getItemMeta();
        back_meta.setDisplayName("Back");
        back.setItemMeta(back_meta);

        ItemStack filling = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta filling_meta = filling.getItemMeta();
        filling_meta.setDisplayName(" ");
        filling.setItemMeta(filling_meta);

        ItemStack page_back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = page_back.getItemMeta();
        backMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Back");
        NamespacedKey nextPageKey = new NamespacedKey(plugin, "changePage");
        backMeta.getPersistentDataContainer().set(nextPageKey, PersistentDataType.INTEGER, page -1);
        page_back.setItemMeta(backMeta);

        ItemStack page_next = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = page_next.getItemMeta();
        nextMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Next Page");
        nextMeta.getPersistentDataContainer().set(nextPageKey, PersistentDataType.INTEGER, page +1);
        page_next.setItemMeta(nextMeta);

        // Loop to fill in remaining slots with Gray Stained Glass Panes
        for (int i = 0; i < 54; i++) {
            if(i < 9 || i > 45 || i % 9 == 0 || i % 9 == 8){
                gui.setItem(i, filling);
            }
        }

        int databaseSize = CubitDatabase.getCubitBaseDatabase().size();

        if (page > 1)
            gui.setItem(0, page_back);

        if (databaseSize > page * ITEMS_PER_PAGE) {
            gui.setItem(8, page_next);
        }

        // Set items into their proper slots
        gui.setItem(49, back);

        if((page - 1) * ITEMS_PER_PAGE >= databaseSize) {
            page = (int)Math.ceil(databaseSize / (double)ITEMS_PER_PAGE);
        }

        for (int i = (page - 1) * 28; i < 28 * page; i++) {
            if (i >= databaseSize || databaseSize == 0) {
                break;
            }

            ItemBase item;
            CubitBase current;
            ItemStack currentPet;

            current = CubitDatabase.getCubitBaseDatabase().get(i);
            currentPet = CreateHead.createHead(current.getDefaultSkin());

            ItemMeta currentPetMeta = currentPet.getItemMeta();

            NamespacedKey keyCurrent = new NamespacedKey(plugin, "uuid");
            currentPetMeta.getPersistentDataContainer().set(keyCurrent, PersistentDataType.STRING, current.toString());

            String skinCurrent;
            skinCurrent = current.getDefaultSkin();

            ArrayList<String> lore = new ArrayList<>();
            //lore.add(current.getName());
            lore.add(current.getDescription());
            lore.add(current.getObtain());
            //lore.add(current.getAbility());

            UUID firstUuid = plugin.getGlobalCubitStatistics().getFirstPlayerByCubitBase().get(current);

            if(plugin.getGlobalCubitStatistics().getCubitsObtainedByCubitBase().containsKey(current)){
                lore.add("Found: " + plugin.getGlobalCubitStatistics().getCubitsObtainedByCubitBase().get(current));
                lore.add("First Owner: " + Bukkit.getOfflinePlayer(firstUuid).getPlayer());
                //lore.add("First Owner: " + Bukkit.getOfflinePlayer(plugin.getGlobalCubitStatistics().getFirstPlayerByCubitBase().get(current)));
            }else{
                lore.add("Found: 0");
                lore.add("First Owner: ---");
            }

            currentPetMeta.setLore(lore);
            currentPetMeta.setDisplayName(ChatColor.LIGHT_PURPLE + current.getName());
            currentPet.setItemMeta(currentPetMeta);

            int slot = 0;

            for(int j = 0; j < 45; j++){
                if(gui.getItem(j) == null){
                    slot = j;
                    break;
                }
            }
            gui.setItem(slot, currentPet);

        }
        p.openInventory(gui);
    }

}
