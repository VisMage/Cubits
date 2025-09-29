package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerStat;
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
    }

    private SlayerTask(){}

    public static EntityType getRandomEntry(Main plugin, Player player){

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        WeightedList<EntityType> traits = new WeightedList<>(DEFAULT_TASKS.getWeightedEntries());

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.DESERT)) {
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.HUSK, 15));
        }

        if(playerProfile.getStats().get(PlayerStat.SLAYER) >= 10){
            traits.getWeightedEntries().add(new WeightedEntry<>(EntityType.BOGGED, 5));
        }

        // Default Values
        int min = 30;
        int max = 50;
        int tokens = 1;

        // Set Values Based on Target
        if(traits.getWeightedValue() == EntityType.ZOMBIE) {
            min = 40;
            max = 85;
        }

        if(traits.getWeightedValue() == EntityType.SKELETON) {
            min = 30;
            max = 75;
            tokens = 2;
        }

        if(traits.getWeightedValue() == EntityType.SPIDER) {
            min = 35;
            max = 70;
            tokens = 2;
        }

        if(traits.getWeightedValue() == EntityType.HUSK) {
            min = 35;
            max = 65;
            tokens = 3;
        }

        if(traits.getWeightedValue() == EntityType.WITHER_SKELETON) {
            min = 20;
            max = 40;
            tokens = 4;
        }

        if(traits.getWeightedValue() == EntityType.ENDER_DRAGON) {
            min = 3;
            max = 8;
            tokens = 10;
        }

        if(traits.getWeightedValue() == EntityType.WITHER) {
            min = 3;
            max = 5;
            tokens = 10;
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
        playerProfile.setPlayerVariable(PlayerVariables.SLAYER_POINTS_REWARD, tokens);
        playerProfile.setSlayerMob(traits.getWeightedValue());

        return traits.getWeightedValue();
    }

}
