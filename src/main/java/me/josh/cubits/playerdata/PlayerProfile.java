package me.josh.cubits.playerdata;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.cubitdata.Traits;
import me.josh.cubits.cubitentity.CubitEntity;
import me.josh.cubits.items.CubitItemStack;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ItemType;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;

import java.util.*;

public class PlayerProfile {
    private static final int STARTING_EXP = 100;
    private static final double EXP_MULTIPLIER = 0.1;

    private int exp;
    private UUID uuid;
    private String username;
    private List<Cubit> cubits;
    private CubitEntity activeCubitEntity;
    private HashMap<MiniGameToken, Integer> miniGameTokens;
    private HashMap<PlayerVariables, Integer> playerVariables;
    private HashMap<PlayerStat, Integer> stats;
    private HashMap<PlayerUpgrades, Boolean> upgrades;
    private CubitPlayerInventory cubitPlayerInventory;
    private EntityType slayerMob;
    private EntityType slayerBlock;
    private EntityType questMob1;
    private EntityType questMob2;
    private EntityType questMob3;
    private ItemBase questFish;
    private ItemBase questFishBlocked;
    private boolean tradeReady;
    private PlayerProfile tradePlayer;
    private boolean ach1;
    private boolean ach2;
    private boolean ach3;
    private boolean ach4;
    private boolean ach5;
    private CubitStat ach1Stat;
    private ItemBase ach2ItemBase;
    private EntityType ach3Mob;
    private Material ach4Block;
    private Material ach4BlockAlt;
    private ItemBase ach5Fish;
    private String achievementRewards;
    private boolean achievementLast;
    private boolean activateFishingFrenzy;
    private boolean activateDoubleHaul;


    public PlayerProfile(){}

    public PlayerProfile(Player player){
        this.uuid = player.getUniqueId();
        username = player.getName();
        cubits = new ArrayList<Cubit>() {};
        activeCubitEntity = new CubitEntity();
        stats = new HashMap<>();
        for(PlayerStat stat : PlayerStat.values()) {
            stats.put(stat, 0);
        }
        miniGameTokens = new HashMap<>();
        for(MiniGameToken token : MiniGameToken.values()) {
            miniGameTokens.put(token, 0);
        }

        miniGameTokens.put(MiniGameToken.COINS, 100);

        upgrades = new HashMap<>();
        for(PlayerUpgrades setupgrade : PlayerUpgrades.values()) {
            upgrades.put(setupgrade, false);
        }

        playerVariables = new HashMap<>();
        for(PlayerVariables token : PlayerVariables.values()) {
            playerVariables.put(token, 0);
            playerVariables.put(PlayerVariables.ACHIEVEMENT_TIER, 1);
            playerVariables.put(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1, 1000);
            playerVariables.put(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2, 30);
            playerVariables.put(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3, 50);
            playerVariables.put(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4, 100);
            playerVariables.put(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5, 10);
        }

        cubitPlayerInventory = new CubitPlayerInventory();

        tradeReady = false;
        tradePlayer = null;

        //slayerMob = EntityType.ZOMBIE;
        slayerMob = null;
        slayerBlock = null;
        questMob1 = null;
        questMob2 = null;
        questMob3 = null;
        questFish = null;
        questFishBlocked = null;
        ach1 = false;
        ach2 = false;
        ach3 = false;
        ach4 = false;
        ach5 = false;
        ach1Stat = CubitStat.STAMINA;
        ach2ItemBase = ItemBase.WHEAT;
        ach3Mob = EntityType.SPIDER;
        ach4Block = Material.COAL_ORE;
        ach4BlockAlt = Material.DEEPSLATE_COAL_ORE;
        ach5Fish = ItemBase.FISH_CARP;
        achievementRewards = "100 Coins, 20 Sappleberries, 10 Fishy Crackers";
        achievementLast = false;
        activateFishingFrenzy = false;
        activateDoubleHaul = false;



    }

    public void addCubit(Cubit cubit) {
        cubits.add(cubit);
    }

    public void addCubit(CubitBase cubitBase) {
        Player player = Bukkit.getPlayer(uuid);
        Main.getInstance().getGlobalCubitStatistics().AddCubitStatistic(player, cubitBase);
        Cubit cubit = new Cubit(cubitBase, player);
        cubit.setOriginalOwnerUUID(uuid);
        cubit.setOriginalOwnerName(player.getName());
        cubit.setSerialNumber(Main.getInstance().getGlobalCubitStatistics().getCubitsObtainedByCubitBase().get(cubitBase));

        if(playerVariables.get(PlayerVariables.IF_STARTER) == 1) {
            cubit.setStarter(0);
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found a " + cubitBase.getName() + "!");
            //SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            SoundUtil.PlaySoundAll(Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
            cubit.setTrait(Traits.getRandomEntry(player));
        }else{
            cubit.setStarter(1);
            cubit.setTrait("Fledgling");
        }

        Random r = new Random();
        float chance = r.nextFloat();
        int shinyBoost = playerVariables.get(PlayerVariables.SHINY_CHARMS) * 10;
        if (chance <= (500 + shinyBoost)/100000f) { // At 50 shiny charms, 1/100 shiny odds
            // (IF x5 and 200+, 1/500 Base odds, 20 shiny charms halves it to 1/250
            cubit.setShiny(1);
            SoundUtil.PlaySoundAll(Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
        }

        addCubit(cubit);
    }

    public void removeCubit(Cubit cubit) {
        cubits.remove(cubit);
    }

    public Cubit getCubitByUUID(UUID uuid){
        for(int i = 0; i < cubits.size(); i++) {
            if(uuid.equals(cubits.get(i).getUuid()))
                return cubits.get(i);
        }
        return null;
    }

    public void equipActiveCubit(Main plugin, Player player, Cubit selectedCubit) {
        for(Cubit cubitElement : cubits){
            if(selectedCubit == cubitElement){
                activeCubitEntity.EquipCubit(plugin, player, selectedCubit);
            }
        }
    }

    public void addCubitItem(ItemBase itemBase, int amount) {
        cubitPlayerInventory.addItem(itemBase, amount);
    }

    public void removeCubitItem(ItemBase itemBase, int amount) {
        cubitPlayerInventory.removeItem(itemBase, amount);
    }

    public List<CubitItemStack> getCubitItemByType(ItemType itemType) {
        return cubitPlayerInventory.getByType(itemType);
    }

    public CubitItemStack getCubitItemByIdentifier(String identifier) {
        return cubitPlayerInventory.getByIdentifier(identifier);
    }

    public boolean containsCubitItem(ItemBase itemBase) {
        return cubitPlayerInventory.contains(itemBase);
    }

    public int getPlayerLevel(PlayerStat whichStat) {
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

    //Hashmap Getters and Setters
    public void addMiniGameTokens(MiniGameToken tokenType, int amt) {
        amt = amt < 0 ? 0 : amt;
        miniGameTokens.replace(tokenType, amt + miniGameTokens.get(tokenType));
    }

    public void removeMiniGameTokens(MiniGameToken tokenType, int amt) {
        amt = amt < 0 ? 0 : amt;
        int tokenValue = miniGameTokens.get(tokenType) - amt >= 0 ? miniGameTokens.get(tokenType) - amt : 0;
        //miniGameTokens.replace(tokenType, amt + miniGameTokens.get(tokenType));
        miniGameTokens.replace(tokenType, tokenValue);
    }

    public void addPlayerVariables(PlayerVariables variableName, int amt) {
        amt = amt < 0 ? 0 : amt;
        playerVariables.replace(variableName, amt + playerVariables.get(variableName));
    }

    public void removePlayerVariables(PlayerVariables variableName, int amt) {
        amt = amt < 0 ? 0 : amt;
        int variableValue = playerVariables.get(variableName) - amt >= 0 ? playerVariables.get(variableName) - amt : 0;
        playerVariables.replace(variableName, amt + playerVariables.get(variableName));
    }

    public void setPlayerVariable(PlayerVariables variableName, int amt) {
        //amt = amt < 0 ? 0 : amt; // Add to protect against negative values
        playerVariables.replace(variableName, amt);
    }

    // Getters and Setters
    public UUID getUuid() {
        return uuid;
    }

    public List<Cubit> getCubits() {
        return cubits;
    }

    public void setCubits(List<Cubit> cubits) {
        this.cubits = cubits;
    }

    public CubitEntity getActiveCubitEntity() {
        return activeCubitEntity;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActiveCubitEntity(CubitEntity activeCubitEntity) {
        this.activeCubitEntity = activeCubitEntity;
    }

    public void setMiniGameTokens(HashMap<MiniGameToken, Integer> miniGameTokens) {
        this.miniGameTokens = miniGameTokens;
    }

    public void setPlayerVariables(HashMap<PlayerVariables, Integer> playerVariables) {
        this.playerVariables = playerVariables;
    }

    public HashMap<MiniGameToken, Integer> getMiniGameTokens() {
        return miniGameTokens;
    }

    public HashMap<PlayerVariables, Integer> getPlayerVariables() {
        return playerVariables;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public CubitPlayerInventory getCubitPlayerInventory() {
        return cubitPlayerInventory;
    }

    public HashMap<PlayerStat, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<PlayerStat, Integer> stats) {
        this.stats = stats;
    }

    public void addStats(PlayerStat statName, int amt) {
        amt = amt < 0 ? 0 : amt;
        stats.replace(statName, amt + stats.get(statName));
    }

    public void removeStats(PlayerStat statName, int amt) {
        amt = amt < 0 ? 0 : amt;
        int statValue = stats.get(statName) - amt >= 0 ? stats.get(statName) - amt : 0;
        stats.replace(statName, amt + stats.get(statName));
    }

    public EntityType getQuestMob1() {
        return questMob1;
    }

    public void setQuestMob1(EntityType questMob1) {
        this.questMob1 = questMob1;
    }

    public EntityType getQuestMob2() {
        return questMob2;
    }

    public void setQuestMob2(EntityType questMob2) {
        this.questMob2 = questMob2;
    }

    public EntityType getQuestMob3() {
        return questMob3;
    }

    public void setQuestMob3(EntityType questMob3) {
        this.questMob3 = questMob3;
    }

    public EntityType getSlayerMob() {
        return slayerMob;
    }

    public void setSlayerMob(EntityType slayerMob) {
        this.slayerMob = slayerMob;
    }

    public EntityType getSlayerBlock() {
        return slayerBlock;
    }

    public void setSlayerBlock(EntityType slayerBlock) {
        this.slayerBlock = slayerBlock;
    }

    public ItemBase getQuestFish() {
        return questFish;
    }

    public void setQuestFish(ItemBase questFish) {
        this.questFish = questFish;
    }

    public ItemBase getQuestFishBlocked() {
        return questFishBlocked;
    }

    public void setQuestFishBlocked(ItemBase questFishBlocked) {
        this.questFishBlocked = questFishBlocked;
    }

    public boolean isAch5() {
        return ach5;
    }

    public void setAch5(boolean ach5) {
        this.ach5 = ach5;
    }

    public boolean isAch4() {
        return ach4;
    }

    public void setAch4(boolean ach4) {
        this.ach4 = ach4;
    }

    public boolean isAch3() {
        return ach3;
    }

    public void setAch3(boolean ach3) {
        this.ach3 = ach3;
    }

    public boolean isAch2() {
        return ach2;
    }

    public void setAch2(boolean ach2) {
        this.ach2 = ach2;
    }

    public boolean isAch1() {
        return ach1;
    }

    public void setAch1(boolean ach1) {
        this.ach1 = ach1;
    }

    public PlayerProfile getTradePlayer() {
        return tradePlayer;
    }

    public void setTradePlayer(PlayerProfile tradePlayer) {
        this.tradePlayer = tradePlayer;
    }

    public boolean isTradeReady() {
        return tradeReady;
    }

    public void setTradeReady(boolean tradeReady) {
        this.tradeReady = tradeReady;
    }

    public ItemBase getAch5Fish() {
        return ach5Fish;
    }

    public void setAch5Fish(ItemBase ach5Fish) {
        this.ach5Fish = ach5Fish;
    }

    public Material getAch4BlockAlt() {
        return ach4BlockAlt;
    }

    public void setAch4BlockAlt(Material ach4BlockAlt) {
        this.ach4BlockAlt = ach4BlockAlt;
    }

    public Material getAch4Block() {
        return ach4Block;
    }

    public void setAch4Block(Material ach4Block) {
        this.ach4Block = ach4Block;
    }

    public EntityType getAch3Mob() {
        return ach3Mob;
    }

    public void setAch3Mob(EntityType ach3Mob) {
        this.ach3Mob = ach3Mob;
    }

    public ItemBase getAch2ItemBase() {
        return ach2ItemBase;
    }

    public void setAch2ItemBase(ItemBase ach2ItemBase) {
        this.ach2ItemBase = ach2ItemBase;
    }

    public CubitStat getAch1Stat() {
        return ach1Stat;
    }

    public void setAch1Stat(CubitStat ach1Stat) {
        this.ach1Stat = ach1Stat;
    }

    public String getAchievementRewards() {
        return achievementRewards;
    }

    public void setAchievementRewards(String achievementRewards) {
        this.achievementRewards = achievementRewards;
    }

    public boolean isAchievementLast() {
        return achievementLast;
    }

    public void setAchievementLast(boolean achievementLast) {
        this.achievementLast = achievementLast;
    }

    public HashMap<PlayerUpgrades, Boolean> getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(PlayerUpgrades upgradeName, boolean value) {
        //amt = amt < 0 ? 0 : amt; // Add to protect against negative values
        upgrades.replace(upgradeName, value);
    }

    public boolean isActivateFishingFrenzy() {
        return activateFishingFrenzy;
    }

    public void setActivateFishingFrenzy(boolean activateFishingFrenzy) {
        this.activateFishingFrenzy = activateFishingFrenzy;
    }

    public boolean isActivateDoubleHaul() {
        return activateDoubleHaul;
    }

    public void setActivateDoubleHaul(boolean activateDoubleHaul) {
        this.activateDoubleHaul = activateDoubleHaul;
    }

    // End of Getters/Setters
}
