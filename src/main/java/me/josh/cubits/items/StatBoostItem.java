package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.playerdata.PlayerProfile;

import java.util.HashMap;
import java.util.Map;

public class StatBoostItem extends ItemBase {

    private HashMap<CubitStat, Integer> boostStats;

    public StatBoostItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost, HashMap<CubitStat, Integer> boostStats) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.STAT_BOOST_ITEM;
        this.boostStats = boostStats;

    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        for(Map.Entry<CubitStat, Integer> statEntry : boostStats.entrySet()) {
            cubit.addStat(statEntry.getKey(), statEntry.getValue());
        }

    }





}
