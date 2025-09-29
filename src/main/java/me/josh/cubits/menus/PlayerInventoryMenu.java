package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CreateCubitHead;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.items.CubitItemStack;
import me.josh.cubits.items.ItemType;
import me.josh.cubits.menus.shopkeepers.CubitGui;
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
import java.util.List;

public class PlayerInventoryMenu extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static final int ITEMS_PER_PAGE = 28;
    private static final ItemStack BACK_ICON;
    private static final ItemStack PAGE_BACK_ICON;
    private static final ItemStack PAGE_NEXT_ICON;

    static {
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);

        PAGE_BACK_ICON = new ItemStack(Material.ARROW);
        ItemMeta backMeta = PAGE_BACK_ICON.getItemMeta();
        backMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Back");
        PAGE_BACK_ICON.setItemMeta(backMeta);

        PAGE_NEXT_ICON = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = PAGE_NEXT_ICON.getItemMeta();
        nextMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Next Page");
        PAGE_NEXT_ICON.setItemMeta(nextMeta);
    }

    private PlayerInventoryMenu(){

    }

    public static void OpenBagByItemType(Main plugin, Player p, ItemType itemType, int page) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, itemType.getName() + " Bag");

        List<CubitItemStack> cubitItemsStacks = playerProfile.getCubitItemByType(itemType);

        if (page < 1)
            page = 1;

        // Determine page
        if(cubitItemsStacks.isEmpty()){
            page = 1;
        }
        else if((page - 1) * ITEMS_PER_PAGE >= cubitItemsStacks.size()) {
            page = (int)Math.ceil(cubitItemsStacks.size() / (double)ITEMS_PER_PAGE);
        }

        addBorderTrim(gui);
        if (page > 1)
            gui.setItem(0, PAGE_BACK_ICON);
        if (cubitItemsStacks.size() > page * ITEMS_PER_PAGE)
            gui.setItem(8, PAGE_NEXT_ICON);
        gui.setItem(49, BACK_ICON);
        gui.setItem(4, getPlayerPetHead(plugin, p, playerProfile));

        int firstCubitIndex = (page - 1) * ITEMS_PER_PAGE;
        int lastCubitIndex = ITEMS_PER_PAGE * page;
        for(int i = firstCubitIndex; i < lastCubitIndex; i++) {
            if(i >= cubitItemsStacks.size())
                break;

            CubitItemStack itemStack = cubitItemsStacks.get(i); //Issue?

            ItemStack guiItem = new ItemStack(Material.CLOCK);
            ItemMeta meta = guiItem.getItemMeta();

            meta.setDisplayName(itemStack.getItemBase().getName());
            meta.setCustomModelData(itemStack.getItemBase().getCustomModelData());

            NamespacedKey key = new NamespacedKey(plugin, "itemIdentifier");
            //meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, i);
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, itemStack.getItemBase().getIdentifier());

            ArrayList<String> lore = new ArrayList<>();
            lore.add(itemStack.getItemBase().getDescription());
            lore.add(ChatColor.WHITE + "Amount: " + itemStack.getAmount());

            meta.setLore(lore);
            guiItem.setItemMeta(meta);

            gui.addItem(guiItem);
        }

        // Runs after the loop is complete
        p.openInventory(gui);
    }


    private static ItemStack getPlayerPetHead(Main plugin, Player player, PlayerProfile playerProfile) {
        ItemStack petItemHead;

        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();
        if (cubit == null) {
            petItemHead = new ItemStack(Material.PAPER, 1);
            ItemMeta petItemHead_meta = petItemHead.getItemMeta();
            petItemHead_meta.setDisplayName("No Equipped Cubit");
            petItemHead.setItemMeta(petItemHead_meta);
        } else {
            petItemHead = new CreateCubitHead(plugin).NewCubitHead(player, cubit);
        }

        return petItemHead;
    }


}
