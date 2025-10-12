package me.josh.cubits.cubitdata;

import me.josh.cubits.items.ItemBase;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Cubit {
    private static final int STARTING_EXP = 100;
    private static final double EXP_MULTIPLIER = 0.1;

    private CubitBase cubitBase;
    private UUID uuid;
    private String name;
    private  String description;
    private int exp;
    private int rarity;
    private int starter;
    private int shiny;
    private String trait;
    private String trait2;
    private String trait3;
    private String trait4;
    private String trait5;
    private Map<CubitStat, Integer> grades;
    private Map<CubitStat, Integer> stats;
    private String altSkin;
    private int serialNumber;
    private int rebirth;
    private UUID originalOwnerUUID;
    private String originalOwnerName;
    private ItemBase heldItem;



    public Cubit(CubitBase cubitBase, Player player){
        uuid = UUID.randomUUID();
        this.cubitBase = cubitBase;
        name = cubitBase.getName();
        description = cubitBase.getDescription();
        grades = new HashMap<>();
        stats = new HashMap<>();

        Random rand = new Random(); // nextInt as provided by Random is exclusive of the top value so you need to add 1

        for(CubitStat stat : CubitStat.values()) {
            grades.put(stat, rand.nextInt(5));
        }
        for(CubitStat stat : CubitStat.values()) {
            stats.put(stat, 0);
        }
        starter = 0;
        shiny = 0;
        serialNumber = 0;
        rebirth = 0;
        trait = "---";
        trait2 = "---";
        trait3 = "---";
        trait4 = "---";
        trait5 = "---";
        heldItem = ItemBase.NONE;
        originalOwnerUUID = player.getUniqueId();
        originalOwnerName = player.getName();
    }

    public Cubit(UUID uuid, CubitBase cubitBase){
        this.uuid = uuid;
        this.cubitBase = cubitBase;
        name = cubitBase.getName();
        description = cubitBase.getDescription();
        grades = new HashMap<>();
        stats = new HashMap<>();

        Random rand = new Random(); // nextInt as provided by Random is exclusive of the top value so you need to add 1

        for(CubitStat stat : CubitStat.values()) {
            grades.put(stat, rand.nextInt(5));
        }
        for(CubitStat stat : CubitStat.values()) {
            stats.put(stat, 0);
        }
        starter = 0;
        shiny = 0;
        serialNumber = 0;
        rebirth = 0;
        trait = "---";
        trait2 = "---";
        trait3 = "---";
        trait4 = "---";
        trait5 = "---";
        heldItem = ItemBase.NONE;
        //originalOwner = ;
    }


    // Getters and Setters

    public CubitBase getCubitBase() {
        return cubitBase;
    }

    public void setCubitBase(CubitBase cubitBase) {
        this.cubitBase = cubitBase;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Map<CubitStat, Integer> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<CubitStat, Integer> grades) {
        this.grades = grades;
    }

    public Map<CubitStat, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<CubitStat, Integer> stats) {
        this.stats = stats;
    }

    public void addStat(CubitStat cubitStat, int amount) {
        stats.replace(cubitStat, stats.get(cubitStat) + amount);
    }

    public void addGrade(CubitStat cubitStat, int amount) {
        grades.replace(cubitStat, grades.get(cubitStat) + amount);
    }

    public String getAltSkin() {
        return altSkin;
    }

    public void setAltSkin(String altSkin) {
        this.altSkin = altSkin;
    }

    public int getCubitLevel(CubitStat whichStat) {
        int statAmount = stats.get(whichStat);

        int level = 1;
        int currentExpCeiling = STARTING_EXP;
        while(exp >= currentExpCeiling) {
            System.out.println("Level " + level + ": " + currentExpCeiling);
            currentExpCeiling += STARTING_EXP + (STARTING_EXP * level * EXP_MULTIPLIER);
            level++;
        }
        return level;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public UUID getOriginalOwnerUUID() {
        return originalOwnerUUID;
    }

    public void setOriginalOwnerUUID(UUID originalOwnerUUID) {
        this.originalOwnerUUID = originalOwnerUUID;
    }

    public String getOriginalOwnerName() {
        return originalOwnerName;
    }

    public void setOriginalOwnerName(String originalOwnerName) {
        this.originalOwnerName = originalOwnerName;
    }

    public int getRebirth() {
        return rebirth;
    }

    public void setRebirth(int rebirth) {
        this.rebirth = rebirth;
    }

    public int getStarter() {
        return starter;
    }

    public void setStarter(int starter) {
        this.starter = starter;
    }

    public int getShiny() {
        return shiny;
    }

    public void setShiny(int shiny) {
        this.shiny = shiny;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getTrait2() {
        return trait2;
    }

    public void setTrait2(String trait2) {
        this.trait2 = trait2;
    }

    public String getTrait3() {
        return trait3;
    }

    public void setTrait3(String trait3) {
        this.trait3 = trait3;
    }

    public String getTrait4() {
        return trait4;
    }

    public void setTrait4(String trait4) {
        this.trait4 = trait4;
    }

    public String getTrait5() {
        return trait5;
    }

    public void setTrait5(String trait5) {
        this.trait5 = trait5;
    }

    public ItemBase getHeldItem() {
        return heldItem;
    }

    public void setHeldItem(ItemBase heldItem) {
        this.heldItem = heldItem;
    }

    //End of Getters and Setters





    //END
}
