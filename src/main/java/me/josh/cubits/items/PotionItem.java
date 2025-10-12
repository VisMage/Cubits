package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;

public class PotionItem extends ItemBase{

    public PotionItem(){}

    public PotionItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.POTION_ITEM;
    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        System.out.println("Potion Item was consumed!");
    }

    public void OnUnequip(Cubit cubit, PlayerProfile playerProfile){}
}
