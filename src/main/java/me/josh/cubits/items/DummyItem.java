package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;

public class DummyItem extends ItemBase{

    public DummyItem(){}

    public DummyItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.DUMMY_ITEM;
    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        System.out.println("Error - Dummy Item was consumed!");
    }

    public void OnUnequip(Cubit cubit, PlayerProfile playerProfile){}
}
