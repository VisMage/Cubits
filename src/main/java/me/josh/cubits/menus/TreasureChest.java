package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TreasureChest {

    public void OpenTreasureChest(Main plugin, Player p, ItemBase itemBase, int treasureType, int treasureSlot){

        // Create Inventory
        Inventory gui;

        if(treasureType == 2){
            gui = Bukkit.createInventory(p, 27, "Treasure Chest - Foraging");
        } else if(treasureType == 3){
            gui = Bukkit.createInventory(p, 27, "Treasure Chest - Mining");
        } else{
            gui = Bukkit.createInventory(p, 27, "Treasure Chest - Fishing");
        }

        // Create Items to place in inventory
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = back.getItemMeta();
        back_meta.setDisplayName("Back");
        back.setItemMeta(back_meta);

        ItemStack filling = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta filling_meta = filling.getItemMeta();
        filling_meta.setDisplayName(" ");
        filling.setItemMeta(filling_meta);

        ItemStack filling1 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta filling1_meta = filling1.getItemMeta();
        filling1_meta.setDisplayName("???");
        filling1_meta.setCustomModelData(1);
        filling1.setItemMeta(filling1_meta);

        ItemStack filling2 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta filling2_meta = filling2.getItemMeta();
        filling2_meta.setDisplayName("???");
        filling2_meta.setCustomModelData(2);
        filling2.setItemMeta(filling2_meta);

        ItemStack filling3 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta filling3_meta = filling3.getItemMeta();
        filling3_meta.setDisplayName("???");
        filling3_meta.setCustomModelData(3);
        filling3.setItemMeta(filling3_meta);

        ItemStack filling4 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta filling4_meta = filling4.getItemMeta();
        filling4_meta.setDisplayName("???");
        filling4.setItemMeta(filling4_meta);

        ItemStack treasure = new ItemStack(Material.CLOCK, 1);
        ItemMeta treasure_meta = treasure.getItemMeta();
        if(itemBase != ItemBase.DUMMY){
            treasure_meta.setDisplayName(itemBase.getName());
            treasure_meta.setCustomModelData(itemBase.getCustomModelData());
            treasure.setItemMeta(treasure_meta);
        }else{
            treasure_meta.setDisplayName("Blank Treasure (Report if seen)");
            treasure_meta.setCustomModelData(10106);
            treasure.setItemMeta(treasure_meta);
        }

        // Loop to fill in remaining slots with Gray Stained Glass Panes
        for (int i = 0; i < 27; i++) {
            if(i < 9 || i > 18 || i % 9 == 0 || i % 9 == 8){
                gui.setItem(i, filling);
            }
        }

        // Set items into their proper slots
        if(treasureSlot == 0){
            gui.setItem(11, filling1);
            gui.setItem(13, filling2);
            gui.setItem(15, filling3);
        } else if(treasureSlot == 1){
            gui.setItem(11, treasure);
            gui.setItem(13, filling4);
            gui.setItem(15, filling4);

        } else if(treasureSlot == 2){
            gui.setItem(11, filling4);
            gui.setItem(13, treasure);
            gui.setItem(15, filling4);

        } else if(treasureSlot == 3){
            gui.setItem(11, filling4);
            gui.setItem(13, filling4);
            gui.setItem(15, treasure);

        } else if(treasureSlot == 4){
            gui.setItem(22, back);
        }

        p.openInventory(gui);

    }


}
