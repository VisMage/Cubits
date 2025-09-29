package me.josh.cubits.cubitdata;

import me.josh.cubits.items.CookingItem;
import me.josh.cubits.items.ItemBase;

import java.util.ArrayList;
import java.util.List;

public class CubitDatabase {

    private static List<CubitBase> CubitBaseDatabase;
    private static List<ItemBase> StatBoostItemDatabase;
    private static List<ItemBase> HeldItemDatabase;
    private static List<ItemBase> CosmeticItemDatabase;
    private static List<ItemBase> DummyItemDatabase;
    private static List<CookingItem> CookingItemDatabase;
    private static List<ItemBase> PotionItemDatabase;
    private static List<ItemBase> AllItemDatabase;

    private CubitDatabase() {

    }

    public static void init() {
        CubitBaseDatabase = new ArrayList<>();
        //Cubit Bases
        //Starters
        CubitBaseDatabase.add(CubitBase.SHEEP);
        CubitBaseDatabase.add(CubitBase.CRABBY);
        CubitBaseDatabase.add(CubitBase.PENGIN);
        CubitBaseDatabase.add(CubitBase.AXIE);
        CubitBaseDatabase.add(CubitBase.CUBEE);
        //
        CubitBaseDatabase.add(CubitBase.FLOPPER);
        CubitBaseDatabase.add(CubitBase.FLOPPER_ANGRY);
        CubitBaseDatabase.add(CubitBase.FLOPPER_RADIOACTIVE);
        CubitBaseDatabase.add(CubitBase.FLOPPER_KOI);
        CubitBaseDatabase.add(CubitBase.FLOPPER_CLOWN);
        CubitBaseDatabase.add(CubitBase.FLOPPER_IRIDIUM);
        CubitBaseDatabase.add(CubitBase.FLOPPER_SAND);
        CubitBaseDatabase.add(CubitBase.FLOPPER_RAINSKIPPER);

        CubitBaseDatabase.add(CubitBase.PUFFER);
        CubitBaseDatabase.add(CubitBase.PUFFER_QWILL);
        CubitBaseDatabase.add(CubitBase.PUFFER_GRASS);
        CubitBaseDatabase.add(CubitBase.PUFFER_MC);
        CubitBaseDatabase.add(CubitBase.PUFFER_LUNAR);
        CubitBaseDatabase.add(CubitBase.PUFFER_FROZEN);
        CubitBaseDatabase.add(CubitBase.PUFFER_GUARDIAN);
        CubitBaseDatabase.add(CubitBase.PUFFER_ELDER);

        CubitBaseDatabase.add(CubitBase.JELLY_GLOW);
        CubitBaseDatabase.add(CubitBase.JELLY_COBALT);

        CubitBaseDatabase.add(CubitBase.BLOOP);
        CubitBaseDatabase.add(CubitBase.BLOOP_GLOW);

        CubitBaseDatabase.add(CubitBase.AXIE_SCULK);

        CubitBaseDatabase.add(CubitBase.SHEEP_SILLY);
        CubitBaseDatabase.add(CubitBase.SHEEP_PUMPKIN);
        CubitBaseDatabase.add(CubitBase.COOKIE);

        CubitBaseDatabase.add(CubitBase.CHUPPO);

        CubitBaseDatabase.add(CubitBase.GOOBER);
        CubitBaseDatabase.add(CubitBase.GOOBER_GARDEN);
        CubitBaseDatabase.add(CubitBase.GOOBER_HONEY);

        CubitBaseDatabase.add(CubitBase.ROOTLING_OAK);
        CubitBaseDatabase.add(CubitBase.ROOTLING_BIRCH);
        CubitBaseDatabase.add(CubitBase.ROOTLING_SPRUCE);
        CubitBaseDatabase.add(CubitBase.ROOTLING_DARK_OAK);
        CubitBaseDatabase.add(CubitBase.ROOTLING_ACACIA);
        CubitBaseDatabase.add(CubitBase.ROOTLING_MANGROVE);
        CubitBaseDatabase.add(CubitBase.ROOTLING_CHERRY);
        CubitBaseDatabase.add(CubitBase.ROOTLING_CRIMSON);
        CubitBaseDatabase.add(CubitBase.ROOTLING_WARPED);

        CubitBaseDatabase.add(CubitBase.DRAKE_PLUM);
        CubitBaseDatabase.add(CubitBase.DRAKE_CYAN);
        CubitBaseDatabase.add(CubitBase.DRAKE_PEACH);
        CubitBaseDatabase.add(CubitBase.DRAKE_LEMON);
        CubitBaseDatabase.add(CubitBase.DRAKE_CITRUS);
        CubitBaseDatabase.add(CubitBase.DRAKE_LIME);
        CubitBaseDatabase.add(CubitBase.DRAKE_WHITE);

        CubitBaseDatabase.add(CubitBase.BLOCKBUG_COAL);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_COPPER);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_IRON);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_GOLD);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_REDSTONE);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_LAPIS);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_DIAMOND);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_EMERALD);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_CRYSTAL);
        CubitBaseDatabase.add(CubitBase.BLOCKBUG_SANDSTONE);

        CubitBaseDatabase.add(CubitBase.CUBEE_BUSINESS);
        CubitBaseDatabase.add(CubitBase.CUBEE_LGBEE);
        CubitBaseDatabase.add(CubitBase.CUBEE_PRIDE);
        CubitBaseDatabase.add(CubitBase.CUBEE_ZOMBEE);
        CubitBaseDatabase.add(CubitBase.CUBEE_RGB);
        CubitBaseDatabase.add(CubitBase.CUBEE_PHANTOM);
        CubitBaseDatabase.add(CubitBase.CUBEE_SPIDER);
        CubitBaseDatabase.add(CubitBase.CUBEE_SAKURA);
        CubitBaseDatabase.add(CubitBase.CUBEE_PHARAOH);

        CubitBaseDatabase.add(CubitBase.PUFFSTOOL_CRIMSON);
        CubitBaseDatabase.add(CubitBase.PUFFSTOOL_COBALT);

        CubitBaseDatabase.add(CubitBase.BEETLE_COBALT);

        CubitBaseDatabase.add(CubitBase.FROGGO);
        CubitBaseDatabase.add(CubitBase.FROGGO_TEMPERATE);
        CubitBaseDatabase.add(CubitBase.FROGGO_TUNDRA);
        CubitBaseDatabase.add(CubitBase.FROGGO_GOLDEN);
        CubitBaseDatabase.add(CubitBase.FROGGO_CRIMSON);
        CubitBaseDatabase.add(CubitBase.FROGGO_WARPED);
        CubitBaseDatabase.add(CubitBase.FROGGO_MYSTIC);

        CubitBaseDatabase.add(CubitBase.FLUFFLE_SILVER);
        CubitBaseDatabase.add(CubitBase.FLUFFLE_HAZEL);
        CubitBaseDatabase.add(CubitBase.FLUFFLE_MARSHMALLOW);
        CubitBaseDatabase.add(CubitBase.FLUFFLE_CREAM);

        CubitBaseDatabase.add(CubitBase.CREEPER_BABY);
        CubitBaseDatabase.add(CubitBase.TURTLE);
        CubitBaseDatabase.add(CubitBase.PHOENIX);
        CubitBaseDatabase.add(CubitBase.WARDEN);
        CubitBaseDatabase.add(CubitBase.ROCK);




        //Stat Boost Items
        StatBoostItemDatabase = new ArrayList<>();
        StatBoostItemDatabase.add(ItemBase.BRAMBLE_FRUIT);
        StatBoostItemDatabase.add(ItemBase.GOLDEN_BRAMBLE_FRUIT);
        StatBoostItemDatabase.add(ItemBase.SAPPLEBERRY);
        StatBoostItemDatabase.add(ItemBase.FISHY_CRACKER);
        StatBoostItemDatabase.add(ItemBase.GOLDEN_FISHY_CRACKER);
        StatBoostItemDatabase.add(ItemBase.MULCHBERRY);
        StatBoostItemDatabase.add(ItemBase.WYNDBERRY);
        StatBoostItemDatabase.add(ItemBase.COBBLE_CRUNCHIES);
        StatBoostItemDatabase.add(ItemBase.SUKISUKI_FRUIT);
        StatBoostItemDatabase.add(ItemBase.PRETZEL);
        StatBoostItemDatabase.add(ItemBase.HEARTY_TURNIP);
        StatBoostItemDatabase.add(ItemBase.GOLDEN_HEARTY_TURNIP);
        StatBoostItemDatabase.add(ItemBase.CURACURACARROT);
        StatBoostItemDatabase.add(ItemBase.GOLDEN_CURACURACARROT);
        StatBoostItemDatabase.add(ItemBase.STRAWBERRY);
        StatBoostItemDatabase.add(ItemBase.GREEN_APPLE);
        StatBoostItemDatabase.add(ItemBase.DUSTBERRY);
        StatBoostItemDatabase.add(ItemBase.SNOWTATO);
        StatBoostItemDatabase.add(ItemBase.CINNAMONROLL);
        StatBoostItemDatabase.add(ItemBase.DEEPSEA_SUSHI);
        StatBoostItemDatabase.add(ItemBase.MILK);
        StatBoostItemDatabase.add(ItemBase.CHOCOLATE_MILK);
        StatBoostItemDatabase.add(ItemBase.SUGAR_COOKIE);
        StatBoostItemDatabase.add(ItemBase.CLOVER_COOKIE);
        StatBoostItemDatabase.add(ItemBase.CONFETTI_COOKIE);
        StatBoostItemDatabase.add(ItemBase.DOUBLE_CHERRIES);
        StatBoostItemDatabase.add(ItemBase.DRAGONFRUIT);
        StatBoostItemDatabase.add(ItemBase.MUFFIN);
        StatBoostItemDatabase.add(ItemBase.PURE_HONEY);
        StatBoostItemDatabase.add(ItemBase.ROYAL_HONEY);
        StatBoostItemDatabase.add(ItemBase.RICE);
        StatBoostItemDatabase.add(ItemBase.WILD_GRAPES);
        StatBoostItemDatabase.add(ItemBase.NAZOBERRY);

        // Grade Boost Items
        StatBoostItemDatabase.add(ItemBase.MYSTIC_POWER_FRUIT);
        StatBoostItemDatabase.add(ItemBase.MYSTIC_SWIM_FRUIT);
        StatBoostItemDatabase.add(ItemBase.MYSTIC_RUN_FRUIT);
        StatBoostItemDatabase.add(ItemBase.MYSTIC_FLY_FRUIT);
        StatBoostItemDatabase.add(ItemBase.MYSTIC_STAMINA_FRUIT);



        //Cosmetic Items
        CosmeticItemDatabase = new ArrayList<>();
        CosmeticItemDatabase.add(ItemBase.ROCK_PELT);

        //Dummy Items
        DummyItemDatabase = new ArrayList<>();
        DummyItemDatabase.add(ItemBase.KEY_MOSSY);
        DummyItemDatabase.add(ItemBase.KEY_DUSTY);
        DummyItemDatabase.add(ItemBase.KEY_ICY);


        DummyItemDatabase.add(ItemBase.WHEAT);
        DummyItemDatabase.add(ItemBase.SUNKISSED_WHEAT);
        DummyItemDatabase.add(ItemBase.BANANA);
        DummyItemDatabase.add(ItemBase.BEETROOT);
        DummyItemDatabase.add(ItemBase.BLUEBERRY);
        DummyItemDatabase.add(ItemBase.CAVE_CARROT);
        DummyItemDatabase.add(ItemBase.COCOA_BEANS);
        DummyItemDatabase.add(ItemBase.COLIFLOWER);
        DummyItemDatabase.add(ItemBase.COLIFLOWER_YELLOW);
        DummyItemDatabase.add(ItemBase.COLIFLOWER_PURPLE);
        DummyItemDatabase.add(ItemBase.CORN);
        DummyItemDatabase.add(ItemBase.GARLIC);
        DummyItemDatabase.add(ItemBase.PLUMPKIN);
        DummyItemDatabase.add(ItemBase.PLUMPKIN_PALE);
        DummyItemDatabase.add(ItemBase.PLUMPKIN_GOLDEN);
        DummyItemDatabase.add(ItemBase.HONEYDEW);
        DummyItemDatabase.add(ItemBase.LEMON);
        DummyItemDatabase.add(ItemBase.GLACIER_LETTUCE);
        DummyItemDatabase.add(ItemBase.LIME);
        DummyItemDatabase.add(ItemBase.DESERT_ONION);
        DummyItemDatabase.add(ItemBase.ORANGE);
        DummyItemDatabase.add(ItemBase.WILD_PEPPER);
        DummyItemDatabase.add(ItemBase.PINEAPPLE);
        DummyItemDatabase.add(ItemBase.SQUASH);
        DummyItemDatabase.add(ItemBase.SUGARCANE);
        DummyItemDatabase.add(ItemBase.TAMAGO);
        DummyItemDatabase.add(ItemBase.TOMATO);
        DummyItemDatabase.add(ItemBase.WATER);
        DummyItemDatabase.add(ItemBase.CACTUS_BUD);
        DummyItemDatabase.add(ItemBase.ROCK_SHROOM);
        DummyItemDatabase.add(ItemBase.IRONSHROOM);
        DummyItemDatabase.add(ItemBase.LEEK);
        DummyItemDatabase.add(ItemBase.GINGER);
        DummyItemDatabase.add(ItemBase.SUGARPOP_BUD);
        DummyItemDatabase.add(ItemBase.TRUFFLE);
        DummyItemDatabase.add(ItemBase.SEAWEED);

        // Alchemy Items
        DummyItemDatabase.add(ItemBase.ARIA_POWDER);
        DummyItemDatabase.add(ItemBase.ARIA_FLOWER);
        DummyItemDatabase.add(ItemBase.MAHNA_PETALS);
        DummyItemDatabase.add(ItemBase.ROVITA);
        DummyItemDatabase.add(ItemBase.BELLETHORN);


        // Fish
        DummyItemDatabase.add(ItemBase.FISH_CARP);
        DummyItemDatabase.add(ItemBase.FISH_CHUB);
        DummyItemDatabase.add(ItemBase.FISH_CHUB_TITANIC);
        DummyItemDatabase.add(ItemBase.FISH_SUNFISH);
        DummyItemDatabase.add(ItemBase.FISH_MOONFISH);
        DummyItemDatabase.add(ItemBase.FISH_SHROOMA_RED);
        DummyItemDatabase.add(ItemBase.FISH_SHROOMA_BROWN);


        // Fishing Bait
        DummyItemDatabase.add(ItemBase.BAIT_DEEPSEA);
        DummyItemDatabase.add(ItemBase.BAIT_TROPICAL);



        //Held Items
        HeldItemDatabase = new ArrayList<>();
        HeldItemDatabase.add(ItemBase.WHITE_PARTY_HAT);



        //Potions
        PotionItemDatabase = new ArrayList<>();
        PotionItemDatabase.add(ItemBase.LUCKY_POTION_1);


        //Cooking Items
        CookingItemDatabase = new ArrayList<>();
        CookingItemDatabase.add(ItemBase.BREAD);
        CookingItemDatabase.add(ItemBase.BURGER);
        CookingItemDatabase.add(ItemBase.BURRITO);
        CookingItemDatabase.add(ItemBase.COBBLEROLL);
        CookingItemDatabase.add(ItemBase.CROISSANT);
        CookingItemDatabase.add(ItemBase.DANGO);
        CookingItemDatabase.add(ItemBase.DRAGON_FRUIT_PIE);
        CookingItemDatabase.add(ItemBase.EGG_TOAST);
        CookingItemDatabase.add(ItemBase.FRUIT_SALAD);
        CookingItemDatabase.add(ItemBase.FRUIT_SANDWICH);
        CookingItemDatabase.add(ItemBase.GRAPE_DOUGHNUT);
        CookingItemDatabase.add(ItemBase.GRILLED_CHEESE);
        CookingItemDatabase.add(ItemBase.HONEYBUN);
        CookingItemDatabase.add(ItemBase.ICE_CREAM);
        CookingItemDatabase.add(ItemBase.ICE_CREAM_SANDWICH);
        CookingItemDatabase.add(ItemBase.RAMEN);
        CookingItemDatabase.add(ItemBase.SALMON_SUSHI);
        CookingItemDatabase.add(ItemBase.SAPPLEBERRY_PIE);
        CookingItemDatabase.add(ItemBase.SPICY_CURRY);
        CookingItemDatabase.add(ItemBase.STRAWBERRY_CAKE);
        CookingItemDatabase.add(ItemBase.STRAWBERRY_DOUGHNUT);
        CookingItemDatabase.add(ItemBase.SUSHI_ROLL);
        CookingItemDatabase.add(ItemBase.TACO);
        CookingItemDatabase.add(ItemBase.TAMAGO_NIGIRI);
        CookingItemDatabase.add(ItemBase.TAMAGO_SANDO);
        CookingItemDatabase.add(ItemBase.TANOOKI_COOKIE);
        CookingItemDatabase.add(ItemBase.TUNA_SUSHI);
        CookingItemDatabase.add(ItemBase.WAFFLE);
        CookingItemDatabase.add(ItemBase.WAFFLE_PLATTER);
        CookingItemDatabase.add(ItemBase.DUMPLING);
        CookingItemDatabase.add(ItemBase.LEMONADE);
        CookingItemDatabase.add(ItemBase.MACAROON);
        CookingItemDatabase.add(ItemBase.MINT_COOKIE);
        CookingItemDatabase.add(ItemBase.VANILLA_COOKIE);
        CookingItemDatabase.add(ItemBase.FORBIDDEN_TREAT);
        CookingItemDatabase.add(ItemBase.MYSTERY_MEAL);



        // ALL IEMS DATABASE
        AllItemDatabase = new ArrayList<>();
        AllItemDatabase.addAll(StatBoostItemDatabase);
        AllItemDatabase.addAll(HeldItemDatabase);
        AllItemDatabase.addAll(CosmeticItemDatabase);
        AllItemDatabase.addAll(DummyItemDatabase);
        AllItemDatabase.addAll(PotionItemDatabase);
        AllItemDatabase.addAll(CookingItemDatabase);

    }


    public static List<CubitBase> getCubitBaseDatabase() {
        return CubitBaseDatabase;
    }

    public static CubitBase getCubitBase(String name) {
        for(CubitBase base : CubitBaseDatabase) {
            if(base.getName().toLowerCase().equals(name.toLowerCase())){
                return base;
            }

        }
        return null;

    }

    public static List<ItemBase> getStatBoostItemDatabase() {
        return StatBoostItemDatabase;
    }

    public static ItemBase getStatBoostItem(String identifier) {
        for(ItemBase base : StatBoostItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }

    public static List<ItemBase> getHeldItemDatabase() {
        return HeldItemDatabase;
    }

    public static ItemBase getHeldItem(String identifier) {
        for(ItemBase base : HeldItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }


    public static List<ItemBase> getCosmeticItemDatabase() {
        return CosmeticItemDatabase;
    }

    public static ItemBase getCosmeticItem(String identifier) {
        for(ItemBase base : CosmeticItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }


    public static List<ItemBase> getDummyItemDatabase() {
        return DummyItemDatabase;
    }

    public static ItemBase getDummyItem(String identifier) {
        for(ItemBase base : DummyItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }


    public static List<ItemBase> getPotionItemDatabase() {
        return PotionItemDatabase;
    }

    public static ItemBase getPotionItem(String identifier) {
        for(ItemBase base : PotionItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }


    public static List<CookingItem> getCookingItemDatabase() {
        return CookingItemDatabase;
    }

    public static CookingItem getCookingItem(String identifier) {
        for(CookingItem base : CookingItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }

    public static List<ItemBase> getAllItemDatabase() {
        return AllItemDatabase;
    }

    public static ItemBase getAllItem(String identifier) {
        for(ItemBase base : AllItemDatabase) {
            if(base.getIdentifier().toLowerCase().equals(identifier.toLowerCase())){
                return base;
            }

        }
        return null;

    }


}
