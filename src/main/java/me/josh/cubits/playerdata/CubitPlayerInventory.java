package me.josh.cubits.playerdata;

import me.josh.cubits.items.CubitItemStack;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ItemType;

import java.util.ArrayList;
import java.util.List;

public class CubitPlayerInventory {
    private List<CubitItemStack> inventory;

    public CubitPlayerInventory() {
        inventory = new ArrayList<>();
    }

    public void addItem(ItemBase itemBase, int amount) {
        if(amount <= 0){
            return;
        }

        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemBase().equals(itemBase)){
                inventory.get(i).setAmount(inventory.get(i).getAmount() + amount);
                return;
            }
        }
        inventory.add(new CubitItemStack(itemBase, amount));
    }

    public void removeItem(ItemBase itemBase, int amount) {
        if(amount <= 0){
            return;
        }

        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemBase().equals(itemBase)){
                inventory.get(i).setAmount(inventory.get(i).getAmount() - amount);

                if(inventory.get(i).getAmount() <= 0){
                    inventory.remove(i);
                }
                break;
            }
        }
    }

    public List<CubitItemStack> getByType(ItemType itemType) {
        ArrayList<CubitItemStack> items = new ArrayList<>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemBase().getItemType().equals(itemType)){
                items.add(inventory.get(i));
            }
        }
        return items;
    }

    public CubitItemStack getByIdentifier(String identifier) {
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemBase().getIdentifier().equals(identifier)){
                return inventory.get(i);
            }
        }
        return null;
    }

    public boolean contains(ItemBase itemBase) {
        for(CubitItemStack cubitItemStack : inventory) {
            if(cubitItemStack.getItemBase().getIdentifier().equals(itemBase.getIdentifier()))
                return true;
        }

        return false;
    }

    public List<CubitItemStack> getInventory() {
        return inventory;
    }

}
