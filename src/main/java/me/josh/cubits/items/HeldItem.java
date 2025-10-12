package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.playerdata.PlayerProfile;

import java.util.HashMap;

public class HeldItem extends ItemBase{

    public HashMap<CubitStat, Integer> boostStats;

    public HeldItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost, HashMap<CubitStat, Integer> boostStats) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.HELD_ITEM;
        this.boostStats = boostStats;

    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        if(cubit.getHeldItem() != ItemBase.NONE){
            playerProfile.addCubitItem(cubit.getHeldItem(), 1);
        }
        cubit.setHeldItem(this);
    }


    public void OnUnequip(Cubit cubit, PlayerProfile playerProfile) {
        playerProfile.addCubitItem(cubit.getHeldItem(), 1);
        cubit.setHeldItem(ItemBase.NONE);
    }

}
