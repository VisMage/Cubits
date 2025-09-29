package me.josh.cubits.cubitdata;

import me.josh.cubits.utils.WeightedEntry;
import me.josh.cubits.utils.WeightedList;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

public class Traits {

    public static WeightedList<String> DEFAULT_TRAITS;

    static{
        DEFAULT_TRAITS = new WeightedList<>();
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Cheerful", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Gloomy", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Lazy", 5));
    }

    private Traits(){}

    public static String getRandomEntry(Player player){

        WeightedList<String> traits = new WeightedList<>(DEFAULT_TRAITS.getWeightedEntries());

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.DESERT)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Sunkissed", 15));
        }

        return traits.getWeightedValue();
    }

}
