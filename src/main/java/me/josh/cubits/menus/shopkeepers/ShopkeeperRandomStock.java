package me.josh.cubits.menus.shopkeepers;

import me.josh.cubits.items.ItemBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShopkeeperRandomStock {

    public static final ShopkeeperRandomStock GENERAL_STORE;
    public static final ShopkeeperRandomStock GENERAL_STORE_RARE;
    public static final ShopkeeperRandomStock FARMER_SHOP;
    public static final ShopkeeperRandomStock DESERT_TRADER;
    public static final ShopkeeperRandomStock TUNDRA_TRADER;
    public static final ShopkeeperRandomStock SELL_SHOP;
    public static final ShopkeeperRandomStock CURIOSITY_MERCHANT;
    public static final ShopkeeperRandomStock WANDERING_TRADER;
    public static final ShopkeeperRandomStock FISHING_SHOP;
    public static final ShopkeeperRandomStock BOBA_SHOP;
    public static final ShopkeeperRandomStock SLAYER_SHOP;

    public static final ShopkeeperRandomStock FISHING_TREASURE;
    public static final ShopkeeperRandomStock FORAGING_TREASURE;
    public static final ShopkeeperRandomStock MINING_TREASURE;


    private Map<ItemBase, Integer> weightByShopEntry;

    private ShopkeeperRandomStock(){
        weightByShopEntry = new HashMap<>();
    }

    static {
        GENERAL_STORE = new ShopkeeperRandomStock();
        GENERAL_STORE.weightByShopEntry.put(ItemBase.SAPPLEBERRY, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.BRAMBLE_FRUIT, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.COBBLE_CRUNCHIES, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.FISHY_CRACKER, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.PRETZEL, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.HEARTY_TURNIP, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.CURACURACARROT, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.STRAWBERRY, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.CINNAMONROLL, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MILK, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.CHOCOLATE_MILK, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.GREEN_APPLE, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MUFFIN, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.SNOWTATO, 5);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.SUGAR_COOKIE, 2);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MYSTIC_POWER_FRUIT, 1);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MYSTIC_FLY_FRUIT, 1);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MYSTIC_RUN_FRUIT, 1);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MYSTIC_SWIM_FRUIT, 1);
        GENERAL_STORE.weightByShopEntry.put(ItemBase.MYSTIC_STAMINA_FRUIT, 1);


        GENERAL_STORE_RARE = new ShopkeeperRandomStock();
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.MUFFIN, 5);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.PRETZEL, 5);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.HEARTY_TURNIP, 5);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.CINNAMONROLL, 5);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.SUGAR_COOKIE, 2);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.MYSTIC_POWER_FRUIT, 1);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.MYSTIC_FLY_FRUIT, 1);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.MYSTIC_RUN_FRUIT, 1);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.MYSTIC_SWIM_FRUIT, 1);
        GENERAL_STORE_RARE.weightByShopEntry.put(ItemBase.MYSTIC_STAMINA_FRUIT, 1);


        FARMER_SHOP = new ShopkeeperRandomStock();
        FARMER_SHOP.weightByShopEntry.put(ItemBase.SAPPLEBERRY, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.BRAMBLE_FRUIT, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.GOLDEN_BRAMBLE_FRUIT, 1);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.MULCHBERRY, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.WHEAT, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.SUGARPOP_BUD, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.TOMATO, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.BLUEBERRY, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.ARIA_FLOWER, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.MAHNA_PETALS, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.ROVITA, 5);
        FARMER_SHOP.weightByShopEntry.put(ItemBase.HONEYDEW, 5);


        DESERT_TRADER = new ShopkeeperRandomStock();
        DESERT_TRADER.weightByShopEntry.put(ItemBase.DUSTBERRY, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.CURACURACARROT, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.GOLDEN_CURACURACARROT, 1);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.SUNKISSED_WHEAT, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.DESERT_ONION, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.COCOA_BEANS, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.GARLIC, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.GINGER, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.LEMON, 5);
        DESERT_TRADER.weightByShopEntry.put(ItemBase.LIME, 5);


        TUNDRA_TRADER = new ShopkeeperRandomStock();
        TUNDRA_TRADER.weightByShopEntry.put(ItemBase.GLACIER_LETTUCE, 3);
        TUNDRA_TRADER.weightByShopEntry.put(ItemBase.SAPPLEBERRY, 1);


        SELL_SHOP = new ShopkeeperRandomStock();
        SELL_SHOP.weightByShopEntry.put(ItemBase.SAPPLEBERRY, 2);
        SELL_SHOP.weightByShopEntry.put(ItemBase.BRAMBLE_FRUIT, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.GOLDEN_BRAMBLE_FRUIT, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.MULCHBERRY, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.WHEAT, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.HEARTY_TURNIP, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.GOLDEN_HEARTY_TURNIP, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.SUGARPOP_BUD, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.TOMATO, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.BLUEBERRY, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.ARIA_FLOWER, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.MAHNA_PETALS, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.ROVITA, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.HONEYDEW, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.DUSTBERRY, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.CURACURACARROT, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.GOLDEN_CURACURACARROT, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.SUNKISSED_WHEAT, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.DESERT_ONION, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.COCOA_BEANS, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.GARLIC, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.GINGER, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.LEMON, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.LIME, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.GLACIER_LETTUCE, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.BELLETHORN, 1);
        SELL_SHOP.weightByShopEntry.put(ItemBase.NAZOBERRY, 1);


        CURIOSITY_MERCHANT = new ShopkeeperRandomStock();
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.MUFFIN, 3);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.PRETZEL, 3);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.HEARTY_TURNIP, 3);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.CINNAMONROLL, 3);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.SUGAR_COOKIE, 2);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.BELLETHORN, 2);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.MYSTIC_POWER_FRUIT, 1);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.MYSTIC_FLY_FRUIT, 1);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.MYSTIC_RUN_FRUIT, 1);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.MYSTIC_SWIM_FRUIT, 1);
        CURIOSITY_MERCHANT.weightByShopEntry.put(ItemBase.MYSTIC_STAMINA_FRUIT, 1);


        WANDERING_TRADER = new ShopkeeperRandomStock();
        WANDERING_TRADER.weightByShopEntry.put(ItemBase.SAPPLEBERRY, 3);
        WANDERING_TRADER.weightByShopEntry.put(ItemBase.BRAMBLE_FRUIT, 2);


        FISHING_TREASURE = new ShopkeeperRandomStock();
        FISHING_TREASURE.weightByShopEntry.put(ItemBase.FISHY_CRACKER, 10);
        FISHING_TREASURE.weightByShopEntry.put(ItemBase.GOLDEN_FISHY_CRACKER, 1);
        FISHING_TREASURE.weightByShopEntry.put(ItemBase.DEEPSEA_SUSHI, 4);
        FISHING_TREASURE.weightByShopEntry.put(ItemBase.BAIT_DEEPSEA, 4);
        FISHING_TREASURE.weightByShopEntry.put(ItemBase.BAIT_TROPICAL, 4);
        FISHING_TREASURE.weightByShopEntry.put(ItemBase.BANANA, 4);


        FORAGING_TREASURE = new ShopkeeperRandomStock();
        FORAGING_TREASURE.weightByShopEntry.put(ItemBase.BRAMBLE_FRUIT, 10);
        FORAGING_TREASURE.weightByShopEntry.put(ItemBase.GOLDEN_BRAMBLE_FRUIT, 1);
        FORAGING_TREASURE.weightByShopEntry.put(ItemBase.GREEN_APPLE, 6);
        FORAGING_TREASURE.weightByShopEntry.put(ItemBase.WILD_GRAPES, 6);
        FORAGING_TREASURE.weightByShopEntry.put(ItemBase.MULCHBERRY, 6);


        MINING_TREASURE = new ShopkeeperRandomStock();
        MINING_TREASURE.weightByShopEntry.put(ItemBase.COBBLE_CRUNCHIES, 10);
        MINING_TREASURE.weightByShopEntry.put(ItemBase.ROCK_SHROOM, 10);
        MINING_TREASURE.weightByShopEntry.put(ItemBase.IRONSHROOM, 3);
        MINING_TREASURE.weightByShopEntry.put(ItemBase.ROCK_PELT, 1);


        FISHING_SHOP = new ShopkeeperRandomStock();
        FISHING_SHOP.weightByShopEntry.put(ItemBase.FISHY_CRACKER, 100);
        FISHING_SHOP.weightByShopEntry.put(ItemBase.GOLDEN_FISHY_CRACKER, 1);
        FISHING_SHOP.weightByShopEntry.put(ItemBase.DEEPSEA_SUSHI, 40);
        FISHING_SHOP.weightByShopEntry.put(ItemBase.BAIT_DEEPSEA, 40);
        FISHING_SHOP.weightByShopEntry.put(ItemBase.BAIT_TROPICAL, 40);


        BOBA_SHOP = new ShopkeeperRandomStock();
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_CARP, 10);
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_CHUB, 10);
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_CHUB_TITANIC, 5);
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_SUNFISH, 10);
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_MOONFISH, 10);
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_SHROOMA_RED, 10);
        BOBA_SHOP.weightByShopEntry.put(ItemBase.FISH_SHROOMA_BROWN, 10);




        SLAYER_SHOP = new ShopkeeperRandomStock();
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.DUSTBERRY, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.BRAMBLE_FRUIT, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.MULCHBERRY, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.CAVE_CARROT, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.COCOA_BEANS, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.GARLIC, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.ROCK_SHROOM, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.IRONSHROOM, 10);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.SLAYER_BANDANA, 30);
        SLAYER_SHOP.weightByShopEntry.put(ItemBase.SPIKED_BARB, 30);




    }


    public ItemBase getRandomEntry(){
        if(weightByShopEntry.isEmpty()) {
            return null;
        }

        ItemBase itemBase = null;
        int totalWeight = 0;

        for(Map.Entry<ItemBase, Integer> entry : weightByShopEntry.entrySet()){
            totalWeight += entry.getValue();
        }

        Random rand = new Random();
        int weightValue = rand.nextInt(totalWeight);

        for(Map.Entry<ItemBase, Integer> entry : weightByShopEntry.entrySet()){
            if(weightValue <= entry.getValue()){
                return entry.getKey();
            }

            weightValue -= entry.getValue();

        }

        return itemBase;
    }



}
