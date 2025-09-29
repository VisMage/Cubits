package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CreateCubitHead;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitentity.CreateHead;
import me.josh.cubits.menus.shopkeepers.CubitGui;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class RebirthMenu extends CubitGui {
    private static final int INVENTORY_SIZE = 54;
    private static final String INVENTORY_NAME = ChatColor.DARK_PURPLE + "Rebirth - page ";
    private static final int CUBITS_PER_PAGE = 28;
    private static final String ERROR_COLOR = "&c";
    private static final ItemStack CLOSE_ICON;
    private static final ItemStack BACK_ICON;
    private static final ItemStack NEXT_ICON;
    private static final ItemStack PICKUP_ICON;

    static {
        CLOSE_ICON = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = CLOSE_ICON.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        CLOSE_ICON.setItemMeta(closeMeta);

        BACK_ICON = new ItemStack(Material.ARROW);
        ItemMeta backMeta = BACK_ICON.getItemMeta();
        backMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Back");
        BACK_ICON.setItemMeta(backMeta);

        NEXT_ICON = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = NEXT_ICON.getItemMeta();
        nextMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Next");
        NEXT_ICON.setItemMeta(nextMeta);

        PICKUP_ICON = new ItemStack(Material.PAPER);
        ItemMeta pickupMeta = PICKUP_ICON.getItemMeta();
        pickupMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Rebirth Info");
        ArrayList<String> loreRebirth = new ArrayList<>();
        loreRebirth.add("Duplicate Cubits can be fused with the equipped Cubit.");
        loreRebirth.add("80% of stat points are carried over.");
        loreRebirth.add("If the tributed Cubit has any higher grades, the active Cubit's grade increases by 1.");
        loreRebirth.add("If no grades are higher, a random grade increases by 1.");
        loreRebirth.add("Each rebirth grants a small stat boost in minigames.");
        //lore.add(ChatColor.GOLD + "Amount: " + playerProfile.getPlayerVariables().get(PlayerVariables.(statBoostItem.getIdentifier())));
        pickupMeta.setLore(loreRebirth);
        PICKUP_ICON.setItemMeta(pickupMeta);

    }

    private RebirthMenu() {

    }

    public static void OpenRebirthMenu(Main plugin, Player player, int page){
        List<Cubit> unlockedPets = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).getCubits();
        if (unlockedPets == null) {
            Utils.msg(player, String.format("%sInternal error. Cubits list never initialized.", ERROR_COLOR));
            return;
        }
        if (unlockedPets.size() == 0) {
            Utils.msg(player, String.format("%sVisit Professor Chupopo to start your Cubit journey!", ERROR_COLOR));
            return;
        }

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        //Create inventory
        Inventory gui = Bukkit.createInventory(null, INVENTORY_SIZE, INVENTORY_NAME + page);

        // Set GUI icons
        addBorderTrim(gui);
        if (page > 1)
            gui.setItem(0, BACK_ICON);
        if (unlockedPets.size() > page * CUBITS_PER_PAGE)
            gui.setItem(8, NEXT_ICON);
        gui.setItem(49, CLOSE_ICON);
        gui.setItem(4, getPlayerCurrentPetItemStack(plugin, playerProfile));
        gui.setItem(45, PICKUP_ICON);

        // Determine page
        if((page - 1) * CUBITS_PER_PAGE >= unlockedPets.size()) {
            page = (int)Math.ceil(unlockedPets.size() / (double)CUBITS_PER_PAGE);
        }

        // Add unlocked cubits on page to gui
        int firstCubitIndex = (page - 1) * CUBITS_PER_PAGE;
        int lastCubitIndex = CUBITS_PER_PAGE * page;
        for(int i = firstCubitIndex; i < lastCubitIndex; i++) {
            if (i >= unlockedPets.size())
                break;

            Cubit cubit = unlockedPets.get(i);

            if(cubit != playerProfile.getActiveCubitEntity().getCubit() && cubit.getCubitBase() == playerProfile.getActiveCubitEntity().getCubit().getCubitBase()){

                // REMOVED CODE HERE
                ItemStack petItem = new CreateCubitHead(plugin).NewCubitHead(player, cubit);

                // ADD Cubit UUID to get for equipping!
                //cubitID.put(slot, unlockedPets.get(i + (page - 1) * 28));
                gui.addItem(petItem);

            }

        }

        //cubitData.put(p.getUniqueId().toString(), cubitID);
        player.openInventory(gui);
    }

    private static ItemStack getPlayerCurrentPetItemStack(Main plugin, PlayerProfile playerProfile) {
        ItemStack currentPet;
        if (playerProfile.getActiveCubitEntity() == null || playerProfile.getActiveCubitEntity().getCubit() == null) {
            currentPet = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta currentPetMeta = (SkullMeta) currentPet.getItemMeta();
            currentPetMeta.setOwner("vvvvvvvvvvvv");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "None");
            currentPetMeta.setLore(lore);
            currentPetMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Current Cubit");
            currentPet.setItemMeta(currentPetMeta);
        } else {
            Cubit current = playerProfile.getActiveCubitEntity().getCubit();
            currentPet = new CreateCubitHead(plugin).NewCubitHead(Bukkit.getPlayer(playerProfile.getUuid()), current);
            ItemMeta currentPetMeta = currentPet.getItemMeta();
            currentPetMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Current Cubit");
            currentPet.setItemMeta(currentPetMeta);

//            currentPet = CreateHead.createHead(current.getCubitBase().getDefaultSkin());
//
//            ItemMeta currentPetMeta = currentPet.getItemMeta();
//
//            NamespacedKey keyCurrent = new NamespacedKey(plugin, "uuid");
//            currentPetMeta.getPersistentDataContainer().set(keyCurrent, PersistentDataType.STRING, current.getUuid().toString());
//
//            String skinCurrent;
//            if(current.getAltSkin() == null){
//                skinCurrent = current.getCubitBase().getDefaultSkin();
//            }else{
//                skinCurrent = current.getAltSkin();
//            }
//
//            ArrayList<String> lore = new ArrayList<>();
//            lore.add(current.getCubitBase().getName());
//            lore.add(current.getCubitBase().getDescription());
//            currentPetMeta.setLore(lore);
//            currentPetMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Current Cubit");
//            currentPet.setItemMeta(currentPetMeta);

        }

        return currentPet;
    }

}
