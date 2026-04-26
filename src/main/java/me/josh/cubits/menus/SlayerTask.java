package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerUpgrades;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.WeightedEntry;
import me.josh.cubits.utils.WeightedList;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Random;

public class SlayerTask {

    public static WeightedList<EntityType> DEFAULT_TASKS;

    static{
        DEFAULT_TASKS = new WeightedList<>();
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.ZOMBIE, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.SKELETON, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.SPIDER, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.CAVE_SPIDER, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.HUSK, 6));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.STRAY, 6));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.BOGGED, 6));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.BLAZE, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.BREEZE, 4));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.ZOMBIE_VILLAGER, 2));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.PIGLIN, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.ZOMBIFIED_PIGLIN, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.PIGLIN_BRUTE, 2));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.WITHER_SKELETON, 2));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.PILLAGER, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.WITCH, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.RAVAGER, 2));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.ENDERMAN, 2));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.GHAST, 2));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.DROWNED, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(EntityType.GUARDIAN, 5));


    }

    private SlayerTask(){}

    public static EntityType getRandomEntry(Main plugin, Player player){

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        WeightedList<EntityType> traits = new WeightedList<>(DEFAULT_TASKS.getWeightedEntries());

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.DESERT)) {
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.HUSK, 15));
        }

        if(playerProfile.getUpgrades().get(PlayerUpgrades.SLAYER_UPGRADE_DRAGON)){
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.ENDER_DRAGON, 5));
        }

        if(playerProfile.getUpgrades().get(PlayerUpgrades.SLAYER_UPGRADE_WITHER)){
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.WITHER, 5));
        }

        if(playerProfile.getUpgrades().get(PlayerUpgrades.SLAYER_UPGRADE_ELDERGUARDIAN)){
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.ELDER_GUARDIAN, 5));
        }

        if(playerProfile.getUpgrades().get(PlayerUpgrades.SLAYER_UPGRADE_WARDEN)){
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.WARDEN, 5));
        }

        if(playerProfile.getUpgrades().get(PlayerUpgrades.SLAYER_UPGRADE_BOSSRUSH)){
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.EVOKER, 5));
        }



        // Default Values
        int min = 30;
        int max = 50;
        int tokens = 1;
        EntityType mob = traits.getWeightedValue();

        // Set Values Based on Target
        if(mob == EntityType.ZOMBIE) {
            min = 40;
            max = 85;
        }

        if(mob == EntityType.SKELETON) {
            min = 30;
            max = 75;
            tokens = 2;
        }

        if(mob == EntityType.SPIDER) {
            min = 35;
            max = 70;
            tokens = 2;
        }

        if(mob == EntityType.HUSK) {
            min = 35;
            max = 65;
            tokens = 3;
        }

        if(mob == EntityType.WITHER_SKELETON) {
            min = 20;
            max = 40;
            tokens = 4;
        }

        if(mob == EntityType.ENDER_DRAGON) {
            min = 3;
            max = 8;
            tokens = 10;
        }

        if(mob == EntityType.WITHER) {
            min = 3;
            max = 5;
            tokens = 10;
        }

        if(mob == EntityType.WARDEN) {
            min = 3;
            max = 5;
            tokens = 10;
        }

        if(mob == EntityType.ELDER_GUARDIAN) {
            min = 3;
            max = 5;
            tokens = 10;
        }

        if(mob == EntityType.EVOKER) {
            min = 4;
            max = 6;
            tokens = 10;
        }

        if(mob == EntityType.RAVAGER) {
            min = 2;
            max = 3;
            tokens = 6;
        }

        if(mob == EntityType.BREEZE) {
            min = 6;
            max = 8;
            tokens = 5;
        }

        if(mob == EntityType.PIGLIN_BRUTE) {
            min = 6;
            max = 8;
            tokens = 6;
        }

        if(mob == EntityType.GHAST) {
            min = 3;
            max = 8;
            tokens = 5;
        }

        if(mob == EntityType.ZOMBIE_VILLAGER) {
            min = 3;
            max = 4;
            tokens = 4;
        }

        if(mob == EntityType.CAVE_SPIDER) {
            min = 21;
            max = 28;
            tokens = 4;
        }



        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        int temp;

        // Add increase to mob amount and token reward for longer streaks, potions, extensions, and other buffs here
        if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_STREAK) >= 10){
            temp = playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_STREAK) / 10;
            tokens = tokens + temp;
        }

        playerProfile.setPlayerVariable(PlayerVariables.SLAYER_TARGET_AMOUNT, randomNumber);
        playerProfile.setPlayerVariable(PlayerVariables.SLAYER_ORIGINAL_TARGET_AMOUNT, randomNumber);
        playerProfile.setPlayerVariable(PlayerVariables.SLAYER_POINTS_REWARD, tokens);
        playerProfile.setSlayerMob(traits.getWeightedValue());

        return mob;
    }

}
