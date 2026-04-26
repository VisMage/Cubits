package me.josh.cubits.cubitdata;

import me.josh.cubits.utils.WeightedEntry;
import me.josh.cubits.utils.WeightedList;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import java.time.LocalDate;
import java.util.Random;

public class Traits {

    public static WeightedList<String> DEFAULT_TRAITS;

    static{
        DEFAULT_TRAITS = new WeightedList<>();
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Cheerful", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Gloomy", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Lazy", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Quiet", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Carefree", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Sleepy", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Easygoing", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Adamant", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Modest", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Lucky", 2));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Cuddly", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Stubborn", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Moody", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Brave", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Rash", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Jolly", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Silly", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Fierce", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Lax", 5));
        DEFAULT_TRAITS.getWeightedEntries().add(new WeightedEntry<>("Bashful", 5));
    }

    private Traits(){}

    public static String getRandomEntry(Player player){

        WeightedList<String> traits = new WeightedList<>(DEFAULT_TRAITS.getWeightedEntries());

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.DESERT)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Sunkissed", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.BADLANDS) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.WOODED_BADLANDS) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.ERODED_BADLANDS)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Dusty", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.JUNGLE) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.BAMBOO_JUNGLE) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.SPARSE_JUNGLE)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Mossy", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.LUSH_CAVES)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Glowing", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.CRIMSON_FOREST)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Emberlight", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.WARPED_FOREST)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Warped", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.PALE_GARDEN)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Pale", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                .getBlockZ()).equals(Biome.DEEP_DARK)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Abyssal", 35));
        }

        if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.SWAMP) ||
                player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Slimey", 35));
        }

        if (player.getLocation().getBlock().getBiome().name().contains("OCEAN")) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Soaked", 35));
        }

        long b = player.getWorld().getTime();
        if (b > 13000 ) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Sleepy", 20));
        }
        if (b < 13000 ) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Energetic", 20));
        }

        LocalDate today = LocalDate.now();
        int dayOfYear = today.getDayOfYear();

        if (dayOfYear >= 1 && dayOfYear <= 80) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Blooming", 15));
        }

        if (dayOfYear >= 81 && dayOfYear <= 172) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Hazy", 15));
        }

        if (dayOfYear >= 173 && dayOfYear <= 264) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Maple", 15));
        }

        if (dayOfYear >= 265 && dayOfYear <= 365) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Chilly", 15));
        }



        if (dayOfYear >= 90 && dayOfYear <= 105) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Minty", 40));
        }

        if (dayOfYear >= 182 && dayOfYear <= 189) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Festive", 40));
        }

        if (dayOfYear >= 288 && dayOfYear <= 304) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Spooky", 40));
        }

        if (dayOfYear >= 334 && dayOfYear <= 354) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Frosty", 40));
        }

        if (dayOfYear >= 355 && dayOfYear <= 365) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Frosty", 10));
        }

        if (dayOfYear >= 355 && dayOfYear <= 365) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Holly", 40));
        }



        Location loc = new Location(player.getWorld(), 3800, 64, 1000);
        if(player.getLocation().distance(loc) < 200) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Radioactive", 20));
        }

        loc = new Location(player.getWorld(), 3835, 64, 1350);
        if(player.getLocation().distance(loc) < 70) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Runic", 20));
        }

        loc = new Location(player.getWorld(), 4600, 100, 2520);
        if(player.getLocation().distance(loc) < 150) {
            traits.getWeightedEntries().add(new WeightedEntry<>("Hardy", 20));
        }







        return traits.getWeightedValue();
    }

}
