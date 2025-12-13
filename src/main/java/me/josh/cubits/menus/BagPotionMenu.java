package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CreateCubitHead;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.items.CookingItem;
import me.josh.cubits.items.CubitItemStack;
import me.josh.cubits.items.ItemType;
import me.josh.cubits.items.PotionItem;
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

public class BagPotionMenu extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static final String INVENTORY_NAME = ChatColor.DARK_PURPLE + "Alchemy";
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

    private BagPotionMenu(){

    }

    public static void OpenBagPotion(Main plugin, Player p, int page) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        List<CubitItemStack> potionCubitItemStacks = playerProfile.getCubitItemByType(ItemType.POTION_ITEM);
        List<PotionItem> potionItems = new ArrayList<>();
        for(CubitItemStack cubitItemStack : potionCubitItemStacks)
            potionItems.add((PotionItem)cubitItemStack.getItemBase());

        if (page < 1)
            page = 1;

        // Determine page
        if((page - 1) * ITEMS_PER_PAGE >= potionItems.size()) {
            page = (int)Math.ceil(potionItems.size() / (double)ITEMS_PER_PAGE);
        }

        // Set items into their proper slots
        addBorderTrim(gui);
        if(page > 1)
            gui.setItem(49, PAGE_BACK);
        if (potionItems.size() > page * ITEMS_PER_PAGE)
            gui.setItem(8, PAGE_NEXT);
        gui.setItem(4, getPlayerPetHead(plugin, p, playerProfile));
        gui.setItem(49, BACK_ICON);

        // Add unlocked cubits on page to gui
        int firstItemIndex = (page - 1) * ITEMS_PER_PAGE;
        int lastItemIndex = ITEMS_PER_PAGE * page;
        for (int i = firstItemIndex; i < lastItemIndex; i++) {
            if (i >= potionItems.size())
                break;

            PotionItem potionItemBase = potionItems.get(i);
            // Set Item Details
            ItemStack potionItem = new ItemStack(Material.CLOCK);
            ItemMeta meta = potionItem.getItemMeta();

            meta.setDisplayName(ChatColor.DARK_PURPLE + potionItemBase.getName());
            meta.setCustomModelData(potionItemBase.getCustomModelData());

            NamespacedKey key = new NamespacedKey(plugin, "identifier");
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, potionItemBase.getIdentifier());

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.LIGHT_PURPLE + potionItemBase.getDescription());
            //lore.add(ChatColor.WHITE + item.getIngredients());


            lore.add(ChatColor.WHITE + "Uses - 0");
//            if(potionItemBase.getAmount2() != 0) {
//                if (!playerProfile.containsCubitItem(potionItemBase.getId2())) {
//                    lore.add(ChatColor.WHITE + "Uses - 0");
//                } else {
//                    lore.add(ChatColor.WHITE + "Uses - " + playerProfile.getCubitItemByIdentifier(potionItemBase.getId2().getIdentifier()).getAmount());
//                }
//            }


            if(!playerProfile.containsCubitItem(potionItemBase.getId1())) {
                lore.add(ChatColor.WHITE + potionItemBase.getId1().getName() + " x" + potionItemBase.getAmount1() + " (0)");
            }else{
                lore.add(ChatColor.WHITE + potionItemBase.getId1().getName() + " x" + potionItemBase.getAmount1() + " (" + playerProfile.getCubitItemByIdentifier(potionItemBase.getId1().getIdentifier()).getAmount() + ")");
            }

            if(potionItemBase.getAmount2() != 0) {
                if (!playerProfile.containsCubitItem(potionItemBase.getId2())) {
                    lore.add(ChatColor.WHITE + potionItemBase.getId2().getName() + " x" + potionItemBase.getAmount2() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + potionItemBase.getId2().getName() + " x" + potionItemBase.getAmount2() + " (" + playerProfile.getCubitItemByIdentifier(potionItemBase.getId2().getIdentifier()).getAmount() + ")");
                }
            }

            if(potionItemBase.getAmount3() != 0) {
                if (!playerProfile.containsCubitItem(potionItemBase.getId3())) {
                    lore.add(ChatColor.WHITE + potionItemBase.getId3().getName() + " x" + potionItemBase.getAmount3() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + potionItemBase.getId3().getName() + " x" + potionItemBase.getAmount3() + " (" + playerProfile.getCubitItemByIdentifier(potionItemBase.getId3().getIdentifier()).getAmount() + ")");
                }
            }

            if(potionItemBase.getAmount4() != 0) {
                if (!playerProfile.containsCubitItem(potionItemBase.getId4())) {
                    lore.add(ChatColor.WHITE + potionItemBase.getId4().getName() + " x" + potionItemBase.getAmount4() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + potionItemBase.getId4().getName() + " x" + potionItemBase.getAmount4() + " (" + playerProfile.getCubitItemByIdentifier(potionItemBase.getId4().getIdentifier()).getAmount() + ")");
                }
            }

            if(potionItemBase.getAmount5() != 0) {
                if (!playerProfile.containsCubitItem(potionItemBase.getId5())) {
                    lore.add(ChatColor.WHITE + potionItemBase.getId5().getName() + " x" + potionItemBase.getAmount5() + " (0)");
                } else {
                    lore.add(ChatColor.WHITE + potionItemBase.getId5().getName() + " x" + potionItemBase.getAmount5() + " (" + playerProfile.getCubitItemByIdentifier(potionItemBase.getId5().getIdentifier()).getAmount() + ")");
                }
            }

            meta.setLore(lore);
            potionItem.setItemMeta(meta);

            gui.addItem(potionItem);
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
