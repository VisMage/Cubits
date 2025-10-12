package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.WeightedEntry;
import me.josh.cubits.utils.WeightedList;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import java.util.Random;

public class FishingTask {

    public static WeightedList<ItemBase> DEFAULT_TASKS;

    static{
        DEFAULT_TASKS = new WeightedList<>();
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CHUB, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CHUB_TITANIC, 3));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_SUNFISH, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_MOONFISH, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_SHROOMA_RED, 5));
        DEFAULT_TASKS.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_SHROOMA_BROWN, 5));
    }

    private FishingTask(){}

    public static ItemBase getRandomEntry(Main plugin, Player player){

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        WeightedList<ItemBase> traits = new WeightedList<>(DEFAULT_TASKS.getWeightedEntries());

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.DESERT)) {
            traits.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 15));
        }
//
//        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_DRAGON) == 1){
//            traits.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 5));
//        }
//
//        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_WITHER) == 1){
//            traits.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 5));
//        }
//
//        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_ELDERGUARDIAN) == 1){
//            traits.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 5));
//        }
//
//        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_WARDEN) == 1){
//            traits.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 5));
//        }
//
//        if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_BOSSRUSH) == 1){
//            traits.getWeightedEntries().add(new WeightedEntry<>(ItemBase.FISH_CARP, 5));
//        }



        // Default Values
        int min = 30;
        int max = 50;
        int tokens = 1;
        ItemBase mob = traits.getWeightedValue();

        // Set Values Based on Target
        if(mob == ItemBase.FISH_CARP) {
            min = 15;
            max = 30;
        }

        if(mob == ItemBase.FISH_CHUB) {
            min = 20;
            max = 30;
            tokens = 2;
        }

        if(mob == ItemBase.FISH_CHUB_TITANIC) {
            min = 3;
            max = 5;
            tokens = 10;
        }

        if(mob == ItemBase.FISH_SUNFISH) {
            min = 15;
            max = 25;
            tokens = 3;
        }

        if(mob == ItemBase.FISH_MOONFISH) {
            min = 20;
            max = 30;
            tokens = 4;
        }

        if(mob == ItemBase.FISH_SHROOMA_RED) {
            min = 10;
            max = 20;
            tokens = 2;
        }

        if(mob == ItemBase.FISH_SHROOMA_BROWN) {
            min = 10;
            max = 20;
            tokens = 2;
        }



        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        int temp;

        // Add increase to mob amount and token reward for longer streaks, potions, extensions, and other buffs here
        if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_STREAK) >= 10){
            temp = playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_STREAK) / 10;
            tokens = tokens + temp;
        }

        playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT, randomNumber);
        playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_ORIGINAL_AMOUNT, randomNumber);
        playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_REWARD, tokens);
        playerProfile.setQuestFish(traits.getWeightedValue());

        return mob;
    }

}
