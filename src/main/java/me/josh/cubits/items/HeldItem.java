package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;

public class HeldItem extends ItemBase{

    public HeldItem(){}

    public HeldItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.HELD_ITEM;
    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        System.out.println("Held Item was consumed!");
    }
}
