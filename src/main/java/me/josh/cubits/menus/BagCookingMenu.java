package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CreateCubitHead;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.items.CookingItem;
import me.josh.cubits.items.CubitItemStack;
import me.josh.cubits.items.ItemBase;
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

public class BagCookingMenu extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static final String INVENTORY_NAME = ChatColor.DARK_PURPLE + "Cooking";
    private static final ItemStack BACK_ICON;
    private static final int ITEMS_PER_PAGE = 28;
    private static final ItemStack PAGE_BACK;
    private static final ItemStack PAGE_NEXT;

    static {
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);

        PAGE_BACK = new ItemStack(Material.ARROW);
        ItemMeta backMeta = PAGE_BACK.getItemMeta();
        backMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Page Back");
        PAGE_BACK.setItemMeta(backMeta);

        PAGE_NEXT = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = PAGE_NEXT.getItemMeta();
        nextMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Next Page");
        PAGE_NEXT.setItemMeta(nextMeta);
    }

    private BagCookingMenu(){

    }

    public static void OpenBagCooking(Main plugin, Player p, int page) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        List<CubitItemStack> cookingCubitItemStacks = playerProfile.getCubitItemByType(ItemType.COOKING_ITEM);
        List<CookingItem> cookingItems = new ArrayList<>();
        for(CubitItemStack cubitItemStack : cookingCubitItemStacks)
            cookingItems.add((CookingItem)cubitItemStack.getItemBase());

        if (page < 1)
            page = 1;

        // Determine page
        if((page - 1) * ITEMS_PER_PAGE >= cookingItems.size()) {
            page = (int)Math.ceil(cookingItems.size() / (double)ITEMS_PER_PAGE);
        }

        // Set items into their proper slots
        addBorderTrim(gui);
        if(page > 1)
            gui.setItem(49, PAGE_BACK);
        if (cookingItems.size() > page * ITEMS_PER_PAGE)
            gui.setItem(8, PAGE_NEXT);
        gui.setItem(4, getPlayerPetHead(plugin, p, playerProfile));
        gui.setItem(49, BACK_ICON);

        // Add unlocked cubits on page to gui
        int firstItemIndex = (page - 1) * ITEMS_PER_PAGE;
        int lastItemIndex = ITEMS_PER_PAGE * page;
        for (int i = firstItemIndex; i < lastItemIndex; i++) {
            if (i >= cookingItems.size())
                break;

            CookingItem cookingItemBase = cookingItems.get(i);
            // Set Item Details
            ItemStack cookingItem = new ItemStack(Material.CLOCK);
            ItemMeta meta = cookingItem.getItemMeta();

            meta.setDisplayName(ChatColor.DARK_PURPLE + cookingItemBase.getName());
            meta.setCustomModelData(cookingItemBase.getCustomModelData());

            NamespacedKey key = new NamespacedKey(plugin, "identifier");
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, cookingItemBase.getIdentifier());

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.LIGHT_PURPLE + cookingItemBase.getDescription());
            //lore.add(ChatColor.WHITE + item.getIngredients());

            if(!playerProfile.containsCubitItem(cookingItemBase.getId1())) {
                lore.add(ChatColor.WHITE + cookingItemBase.getId1().getName() + " x" + cookingItemBase.getAmount1() + " (0)");
            }else{
                lore.add(ChatColor.WHITE + cookingItemBase.getId1().getName() + " x" + cookingItemBase.getAmount1() + " (" + playerProfile.getCubitItemByIdentifier(cookingItemBase.getId1().getIdentifier()).getAmount() + ")");
            }

            if(cookingItemBase.getAmount2() != 0) {
                if (!playerProfile.containsCubitItem(cookingItemBase.getId2())) {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId2().getName() + " x" + cookingItemBase.getAmount2() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId2().getName() + " x" + cookingItemBase.getAmount2() + " (" + playerProfile.getCubitItemByIdentifier(cookingItemBase.getId2().getIdentifier()).getAmount() + ")");
                }
            }

            if(cookingItemBase.getAmount3() != 0) {
                if (!playerProfile.containsCubitItem(cookingItemBase.getId3())) {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId3().getName() + " x" + cookingItemBase.getAmount3() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId3().getName() + " x" + cookingItemBase.getAmount3() + " (" + playerProfile.getCubitItemByIdentifier(cookingItemBase.getId3().getIdentifier()).getAmount() + ")");
                }
            }

            if(cookingItemBase.getAmount4() != 0) {
                if (!playerProfile.containsCubitItem(cookingItemBase.getId4())) {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId4().getName() + " x" + cookingItemBase.getAmount4() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId4().getName() + " x" + cookingItemBase.getAmount4() + " (" + playerProfile.getCubitItemByIdentifier(cookingItemBase.getId4().getIdentifier()).getAmount() + ")");
                }
            }

            if(cookingItemBase.getAmount5() != 0) {
                if (!playerProfile.containsCubitItem(cookingItemBase.getId5())) {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId5().getName() + " x" + cookingItemBase.getAmount5() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + cookingItemBase.getId5().getName() + " x" + cookingItemBase.getAmount5() + " (" + playerProfile.getCubitItemByIdentifier(cookingItemBase.getId5().getIdentifier()).getAmount() + ")");
                }
            }

            meta.setLore(lore);
            cookingItem.setItemMeta(meta);

            gui.addItem(cookingItem);
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
