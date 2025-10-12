package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.playerdata.PlayerProfile;

import java.util.HashMap;
import java.util.Map;

public class GradeBoostItem extends ItemBase{


    private final HashMap<CubitStat, Integer> boostStats;
    private HashMap<CubitStat, Integer> boostGrades;

    public GradeBoostItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost, HashMap<CubitStat, Integer> boostStats, HashMap<CubitStat, Integer> boostGrades) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.STAT_BOOST_ITEM;
        this.boostGrades = boostGrades;
        this.boostStats = boostStats;

    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        for(Map.Entry<CubitStat, Integer> gradeEntry : boostGrades.entrySet()) {
            cubit.addGrade(gradeEntry.getKey(), gradeEntry.getValue());
        }
        for(Map.Entry<CubitStat, Integer> statEntry : boostStats.entrySet()) {
            cubit.addStat(statEntry.getKey(), statEntry.getValue());
        }

    }

    public void OnUnequip(Cubit cubit, PlayerProfile playerProfile){}


}
