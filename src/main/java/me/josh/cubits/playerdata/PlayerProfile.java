package me.josh.cubits.playerdata;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitdata.Traits;
import me.josh.cubits.cubitentity.CubitEntity;
import me.josh.cubits.items.CubitItemStack;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ItemType;
import me.josh.cubits.items.ObtainTreat;
import me.josh.cubits.menus.shopkeepers.ShopkeeperRandomStock;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    private CubitPlayerInventory cubitPlayerInventory;
    private EntityType slayerMob;
    private EntityType slayerBlock;
    private EntityType questMob1;
    private EntityType questMob2;
    private EntityType questMob3;
    private ItemBase questFish;
    private ItemBase questFishBlocked;

    public PlayerProfile(){}

    public PlayerProfile(UUID uuid, Player player){
        this.uuid = uuid;
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
        playerVariables = new HashMap<>();
        for(PlayerVariables token : PlayerVariables.values()) {
            playerVariables.put(token, 0);
        }

        cubitPlayerInventory = new CubitPlayerInventory();

        //slayerMob = EntityType.ZOMBIE;
        slayerMob = null;
        slayerBlock = null;
        questMob1 = null;
        questMob2 = null;
        questMob3 = null;
        questFish = null;
        questFishBlocked = null;

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
        int shinyBoost = playerVariables.get(PlayerVariables.SHINY_CHARMS) * 5;
        if (chance <= (200 + shinyBoost)/100000f) { // 1/500 Base odds, 20 shiny charms halves it to 1/250
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







// End of Getters/Setters
}
