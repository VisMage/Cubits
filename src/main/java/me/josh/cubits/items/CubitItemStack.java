package me.josh.cubits.items;

public class CubitItemStack {

    private ItemBase itemBase;
    private  int amount;

    public CubitItemStack(ItemBase itemBase, int amount){
        this.itemBase = itemBase;
        this.amount = amount;
    }

    public ItemBase getItemBase() {
        return itemBase;
    }

    public void setItemBase(ItemBase itemBase) {
        this.itemBase = itemBase;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
