package me.josh.cubits.lootbox;

import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.PlayerProfile;

public class ItemLootboxEntry implements LootboxEntry{

    private ItemBase itemBase;
    private int amount;

    public ItemLootboxEntry(ItemBase itemBase, int amount){
        this.itemBase = itemBase;
        this.amount = amount;
    }

    @Override
    public void obtain(PlayerProfile playerProfile) {
        playerProfile.addCubitItem(itemBase, amount);
        System.out.println("You got " + amount + " " + itemBase.getName());
    }


}
