package me.josh.cubits.lootbox;

import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.WeightedEntry;
import me.josh.cubits.utils.WeightedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lootbox {

    public static final Lootbox MOSSY_LOOTBOX;
    public static final Lootbox DUSTY_LOOTBOX;
    public static final Lootbox FROSTY_LOOTBOX;
    private WeightedList<LootboxEntry> weightedLootboxEnteries;

    private Lootbox(){
        weightedLootboxEnteries = new WeightedList<>();
    }

    static {
        MOSSY_LOOTBOX = new Lootbox();
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new CubitLootboxEntry(CubitBase.PUFFSTOOL_CRIMSON), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new CubitLootboxEntry(CubitBase.FROGGO_MYSTIC), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new CubitLootboxEntry(CubitBase.CUBEE_RGB), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.SAPPLEBERRY, 5), 10));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.BRAMBLE_FRUIT, 5), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.GOLDEN_BRAMBLE_FRUIT, 1), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.MULCHBERRY, 3), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.WHEAT, 15), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.SUGARPOP_BUD, 5), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.TOMATO, 5), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.BLUEBERRY, 10), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.ARIA_FLOWER, 3), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.MAHNA_PETALS, 3), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.COBBLE_CRUNCHIES, 5), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.ROVITA, 2), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.HONEYDEW, 2), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.BELLETHORN, 1), 6));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 100), 10));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 200), 4));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 500), 1));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 10), 3));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 35), 2));
        MOSSY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 50), 1));




        DUSTY_LOOTBOX = new Lootbox();
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new CubitLootboxEntry(CubitBase.CUBEE_PHARAOH), 2));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new CubitLootboxEntry(CubitBase.FROGGO_TEMPERATE), 2));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.DUSTBERRY, 15), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.CURACURACARROT, 10), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.GOLDEN_CURACURACARROT, 1), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.SUNKISSED_WHEAT, 8), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.DESERT_ONION, 8), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.COCOA_BEANS, 5), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.GARLIC, 5), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.GINGER, 5), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.LEMON, 3), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.LIME, 3), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.WILD_PEPPER, 3), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.NAZOBERRY, 1), 6));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.BELLETHORN, 1), 100));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 100), 10));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 200), 4));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 500), 1));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 10), 3));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 35), 2));
        DUSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 50), 1));



        FROSTY_LOOTBOX = new Lootbox();
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new CubitLootboxEntry(CubitBase.FROGGO_TUNDRA), 2));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.GLACIER_LETTUCE, 5), 8));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.TOMATO, 5), 6));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.COLIFLOWER, 5), 6));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.COLIFLOWER_PURPLE, 1), 1));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.COLIFLOWER_YELLOW, 1), 1));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.BEETROOT, 6), 6));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.ROCK_SHROOM, 4), 4));

        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new ItemLootboxEntry(ItemBase.BELLETHORN, 1), 6));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 100), 10));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 200), 4));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.COINS, 500), 1));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 10), 3));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 35), 2));
        FROSTY_LOOTBOX.weightedLootboxEnteries.add(new WeightedEntry<>(new TokenLootboxEntry(MiniGameToken.GEMS, 50), 1));


    }

    public WeightedList<LootboxEntry> getWeightedLootboxEnteries() {
        return weightedLootboxEnteries;
    }

}
