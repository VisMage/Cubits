package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.playerdata.PlayerProfile;

import java.util.HashMap;

public abstract class ItemBase {

    // STAT BOOST ITEMS
    public static final StatBoostItem BRAMBLE_FRUIT = new StatBoostItem("Bramble Fruit", "BRAMBLE_FRUIT",
            "POW + 40, STAMINA + 40", 8,
            "Chopping Logs 1/200", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 40); put(CubitStat.POWER, 40); }});

    public static final StatBoostItem GOLDEN_BRAMBLE_FRUIT = new StatBoostItem("Golden Bramble Fruit", "GOLDEN_BRAMBLE_FRUIT",
            "POW + 800, STAMINA +600", 9,
            "Chopping Logs 1/1000", 500,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.POWER, 40); }});

    public static final StatBoostItem SAPPLEBERRY = new StatBoostItem("Sappleberries", "SAPPLEBERRY",
            "FLY/SWIM + 40", 5,
            "Harvesting Sweet Berries 1/30", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.FLY, 40); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem FISHY_CRACKER = new StatBoostItem("Fishy Cracker", "FISHY_CRACKER",
            "SWIM + 80", 25,
            "Fishing 1/15", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 60); }});

    public static final StatBoostItem GOLDEN_FISHY_CRACKER = new StatBoostItem("Golden Fishy Cracker", "GOLDEN_FISHY_CRACKER",
            "SWIM + 1200, STAMINA + 600", 25,
            "Fishing 1/100", 500,
            new HashMap<>(){{ put(CubitStat.STAMINA, 600); put(CubitStat.SWIM, 1200); }});


    public static final StatBoostItem MULCHBERRY = new StatBoostItem("Mulchberry", "MULCHBERRY",
            "POW + 80", 4,
            "Breaking Dirt Block while Raining 1/250", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.POWER, 80); }});

    public static final StatBoostItem WYNDBERRY = new StatBoostItem("Wyndberry", "WYNDBERRY",
            "FLY + 80", 14,
            "Break Grass in Meadow Biome 1/75", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.FLY, 80); }});

    public static final StatBoostItem COBBLE_CRUNCHIES = new StatBoostItem("Cobble Crunchies", "COBBLE_CRUNCHIES",
            "POW + 40, STAMINA +50", 22,
            "Mining Stone 1/1000", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 50); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem SUKISUKI_FRUIT = new StatBoostItem("Sukisuki Fruit", "SUKISUKI_FRUIT",
            "RUN/FLY + 40, STAMINA +60", 30,
            "Breeding Any Animals 1/50", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 60); put(CubitStat.RUN, 40); put(CubitStat.FLY, 40); }});

    public static final StatBoostItem PRETZEL = new StatBoostItem("Big Pretzel", "PRETZEL",
            "STAMINA + 200", 10,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 200); }});

    public static final StatBoostItem HEARTY_TURNIP = new StatBoostItem("Hearty Turnip", "HEARTY_TURNIP",
            "RUN/FLY +30, STAMINA +80", 6,
            "Harvest Beetroots 1/64", 50,
            new HashMap<>(){{ put(CubitStat.STAMINA, 80); put(CubitStat.RUN, 30); put(CubitStat.FLY, 30); }});

    public static final StatBoostItem GOLDEN_HEARTY_TURNIP = new StatBoostItem("Golden Hearty Turnip", "GOLDEN_HEARTY_TURNIP",
            "RUN/FLY +400, STAMINA +750", 6,
            "Harvest Beetroots 1/360", 500,
            new HashMap<>(){{ put(CubitStat.STAMINA, 750); put(CubitStat.RUN, 400); put(CubitStat.FLY, 400); }});

    public static final StatBoostItem CURACURACARROT = new StatBoostItem("Curacura Carrot", "CURACURACARROT",
            "RUN + 60", 7,
            "Harvesting Carrots 1/200", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.RUN, 60); }});

    public static final StatBoostItem GOLDEN_CURACURACARROT = new StatBoostItem("Golden Curacura Carrot", "GOLDEN_CURACURACARROT",
            "RUN + 1200 + STAMINA + 600", 999,
            "???", 500,
            new HashMap<>(){{ put(CubitStat.STAMINA, 600); put(CubitStat.RUN, 1200); }});

    public static final StatBoostItem STRAWBERRY = new StatBoostItem("Strawberry", "STRAWBERRY",
            "SWIM + 60", 3,
            "Harvest Glow Berries 1/30", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 60); }});

    public static final StatBoostItem GREEN_APPLE = new StatBoostItem("Green Apple", "GREEN_APPLE",
            "SWIM + 40", 13,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem DUSTBERRY = new StatBoostItem("Dustberry", "DUSTBERRY",
            "POW/SWIM + 60", 15,
            "Breaking Dead Bush 1/10", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.POWER, 60); put(CubitStat.SWIM, 60); }});

    public static final StatBoostItem SNOWTATO = new StatBoostItem("Snowtato", "SNOWTATO",
            "POW + 60, STAMINA + 80", 12,
            "Harvesting Potatoes in Cold Biomes 1/200", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 80); put(CubitStat.POWER, 60); }});

    public static final StatBoostItem CINNAMONROLL = new StatBoostItem("Cinnamon Roll", "CINNAMONROLL",
            "FLY + 40, STAMINA + 80", 11,
            "Cooking Baked Potato 1/50", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 80); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem DEEPSEA_SUSHI = new StatBoostItem("Deepsea Sushi", "DEEPSEA_SUSHI",
            "SWIM + 800", 27,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 800); }});

    public static final StatBoostItem CHOCOLATE_MILK = new StatBoostItem("Chocolate Milk", "CHOCOLATE_MILK",
            "POW/SWIM + 40, STAMINA + 50", 29,
            "Breeding Cows 1/35", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 50); put(CubitStat.POWER, 40); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem SUGAR_COOKIE = new StatBoostItem("Sugar Cookie", "SUGAR_COOKIE",
            "SWIM + 40", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem CLOVER_COOKIE = new StatBoostItem("Clover Cookie", "CLOVER_COOKIE",
            "SWIM + 40", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem CONFETTI_COOKIE = new StatBoostItem("Confetti Cookie", "CONFETTI_COOKIE",
            "SWIM + 40", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); put(CubitStat.SWIM, 40); }});

    public static final StatBoostItem DOUBLE_CHERRIES = new StatBoostItem("Double Cherries", "DOUBLE_CHERRIES",
            "RUN/FLY + 40, STAMINA + 50", 1,
            "Breaking Cherry Leaves 1/250", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 50); put(CubitStat.RUN, 40); put(CubitStat.FLY, 40); }});

    public static final StatBoostItem DRAGONFRUIT = new StatBoostItem("Dragonfruit", "DRAGONFRUIT",
            "ALL + 1000", 28,
            "Killing the Ender Dragon 1/3", 1000,
            new HashMap<>(){{ put(CubitStat.STAMINA, 1000); put(CubitStat.POWER, 1000); put(CubitStat.SWIM, 1000); put(CubitStat.RUN, 1000); put(CubitStat.FLY, 1000); }});

    public static final StatBoostItem MUFFIN = new StatBoostItem("Muffin", "MUFFIN",
            "ALL + 40", 999,
            "???", 30,
            new HashMap<>(){{ put(CubitStat.STAMINA, 40); put(CubitStat.POWER, 40); put(CubitStat.SWIM, 40); put(CubitStat.RUN, 40); put(CubitStat.FLY, 40); }});
    public static final StatBoostItem PURE_HONEY = new StatBoostItem("Pure Honey", "PURE_HONEY",
            "STAMINA + 40", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 40); }});

    public static final StatBoostItem ROYAL_HONEY = new StatBoostItem("Royal Honey", "ROYAL_HONEY",
            "ALL + 1200", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 1200); put(CubitStat.POWER, 1200); put(CubitStat.SWIM, 1200); put(CubitStat.RUN, 1200); put(CubitStat.FLY, 1200); }});

    public static final StatBoostItem WILD_GRAPES = new StatBoostItem("Wild Grapes", "WILD_GRAPES",
            "SWIM + 50", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 50); }});

    public static final StatBoostItem MILK = new StatBoostItem("Milk", "MILK",
            "SWIM + 50", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 50); }});

    public static final StatBoostItem RICE = new StatBoostItem("Rice", "RICE",
            "SWIM + 50", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 50); }});

    public static final StatBoostItem NAZOBERRY = new StatBoostItem("Nazoberry", "NAZOBERRY",
            "???", 999,
            "???", 20,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10); }});






    // GRADE BOOST ITEMS
    public static final GradeBoostItem MYSTIC_POWER_FRUIT = new GradeBoostItem("Mystic Power Fruit", "MYSTIC_POWER_FRUIT",
            "Boost POW grade by 1, POW/STAMINA + 10000", 998,
            "Oddity Merchant, Crate Rewards", 10000,
            new HashMap<>(){{ put(CubitStat.POWER, 10000); put(CubitStat.STAMINA, 10000); }}, new HashMap<>(){{ put(CubitStat.POWER, 1); }});

    public static final GradeBoostItem MYSTIC_SWIM_FRUIT = new GradeBoostItem("Mystic Swim Fruit", "MYSTIC_SWIM_FRUIT",
            "Boost SWIM grade by 1, SWIM/STAMINA + 10000", 998,
            "Oddity Merchant, Crate Rewards", 10000,
            new HashMap<>(){{ put(CubitStat.SWIM, 10000); put(CubitStat.STAMINA, 10000); }}, new HashMap<>(){{ put(CubitStat.SWIM, 1); }});

    public static final GradeBoostItem MYSTIC_RUN_FRUIT = new GradeBoostItem("Mystic Run Fruit", "MYSTIC_RUN_FRUIT",
            "Boost RUN grade by 1, RUN/STAMINA + 10000", 998,
            "Oddity Merchant, Crate Rewards", 10000,
            new HashMap<>(){{ put(CubitStat.RUN, 10000); put(CubitStat.STAMINA, 10000); }}, new HashMap<>(){{ put(CubitStat.RUN, 1); }});

    public static final GradeBoostItem MYSTIC_FLY_FRUIT = new GradeBoostItem("Mystic Fly Fruit", "MYSTIC_FLY_FRUIT",
            "Boost FLY grade by 1, FLY/STAMINA + 10000", 998,
            "Oddity Merchant, Crate Rewards", 10000,
            new HashMap<>(){{ put(CubitStat.FLY, 10000); put(CubitStat.STAMINA, 10000); }}, new HashMap<>(){{ put(CubitStat.FLY, 1); }});

    public static final GradeBoostItem MYSTIC_STAMINA_FRUIT = new GradeBoostItem("Mystic Stamina Fruit", "MYSTIC_STAMINA_FRUIT",
            "Boost STAMINA grade by 1, STAMINA + 10000", 998,
            "Oddity Merchant, Crate Rewards", 10000,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10000); }}, new HashMap<>(){{ put(CubitStat.STAMINA, 1); }});





    // COSMETIC ITEMS
    public static final CosmeticItem ROCK_PELT = new CosmeticItem("Rock Pelt", "ROCK_PELT",
            "Gives your Pet Rock a fancy new look!", 1001,
            "Oddity Merchant, Crate Rewards", 10000,
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGQyZjc4MWYwM2MzNjViYmM1ZGQxZTcxODZhYjM4ZGM2OTQ2NWU4MzZjOWZlMDY2YTlhODQ0ZjM0YTRkYTkyIn19fQ==" );





    // DUMMY ITEMS
    public static final DummyItem KEY_MOSSY = new DummyItem("Mossy Key", "KEY_MOSSY",
            "Opens the mossy chest! Good luck!", 999,
            "Finding treats in Plains-like biomes", 100);
    public static final DummyItem KEY_DUSTY = new DummyItem("Dusty Key", "KEY_DUSTY",
            "Opens the dusty chest! Good luck!", 999,
            "Findings treats in Desert-like biomes", 100);
    public static final DummyItem KEY_ICY = new DummyItem("Frosty Key", "KEY_FROSTY",
            "Opens the dusty chest! Good luck!", 999,
            "Findings treats in Tundra-like biomes", 100);



    public static final DummyItem WHEAT = new DummyItem("Wheat", "WHEAT",
            "A high-quality ingredient used in cooking.", 999,
            "Harvesting Wheat 1/200", 10);
    public static final DummyItem SUNKISSED_WHEAT = new DummyItem("Sunkissed Wheat", "SUNKISSED_WHEAT",
            "A high-quality ingredient used in cooking.", 999,
            "Harvesting Wheat in Desert biomes 1/350", 10);
    public static final DummyItem DUMMY = new DummyItem("Dummy", "DUMMY",
            "A developer item, report if you see this!", 999,
            "???", 10);

    public static final DummyItem BANANA = new DummyItem("Banana", "BANANA",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem BEETROOT = new DummyItem("Beetroot", "BEETROOT",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem BLUEBERRY = new DummyItem("Blueberry", "BLUEBERRY",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem CAVE_CARROT = new DummyItem("Cave Carrot", "CAVE_CARROT",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem COCOA_BEANS = new DummyItem("Cocoa", "COCOA_BEANS",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem COLIFLOWER = new DummyItem("Coliflower", "COLIFLOWER",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem COLIFLOWER_PURPLE = new DummyItem("Purple Coliflower", "COLIFLOWER_PURPLE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem COLIFLOWER_YELLOW = new DummyItem("Yellow Coliflower", "COLIFLOWER_YELLOW",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem CORN = new DummyItem("Corn", "CORN",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem GARLIC = new DummyItem("Garlic", "GARLIC",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem PLUMPKIN = new DummyItem("Plumpkin", "PLUMPKIN",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem PLUMPKIN_PALE = new DummyItem("Pale Plumpkin", "PLUMPKIN_PALE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem PLUMPKIN_GOLDEN = new DummyItem("Golden Plumpkin", "PLUMPKIN_GOLDEN",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem HONEYDEW = new DummyItem("Honeydew", "HONEYDEW",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem LEMON = new DummyItem("Lemon", "LEMON",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem GLACIER_LETTUCE = new DummyItem("Glacier Lettuce", "GLACIER_LETTUCE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem LIME = new DummyItem("Lime", "LIME",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem DESERT_ONION = new DummyItem("Desert Onion", "DESERT_ONION",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem ORANGE = new DummyItem("Orange", "ORANGE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem WILD_PEPPER = new DummyItem("Wild Pepper", "WILD_PEPPER",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem PINEAPPLE = new DummyItem("Pineapple", "PINEAPPLE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem SQUASH = new DummyItem("Squash", "SQUASH",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem SUGARCANE = new DummyItem("Sugarcane", "SUGARCANE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem TAMAGO = new DummyItem("Tamago", "TAMAGO",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem TOMATO = new DummyItem("Tomato", "TOMATO",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem WATER = new DummyItem("Water", "WATER",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem CACTUS_BUD = new DummyItem("Cactus Bud", "CACTUS_BUD",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem ROCK_SHROOM = new DummyItem("Rock Shroom", "ROCK_SHROOM",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem IRONSHROOM = new DummyItem("Ironshroom", "IRONSHROOM",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem LEEK = new DummyItem("Leek", "LEEK",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem GINGER = new DummyItem("Ginger", "GINGER",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem SUGARPOP_BUD = new DummyItem("Sugarpop Bud", "SUGARPOP_BUD",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem TRUFFLE = new DummyItem("Truffle", "TRUFFLE",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem SEAWEED = new DummyItem("Seaweed", "SEAWEED",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);


    //ALCHEMY ITEMS
    public static final DummyItem ARIA_POWDER = new DummyItem("Aria Powder", "ARIA_POWDER",
            "A high-quality ingredient used in cooking.", 999,
            "Harvesting Wheat 1/200", 10);
    public static final DummyItem ARIA_FLOWER = new DummyItem("Aria Flower", "ARIA_FLOWER",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem MAHNA_PETALS = new DummyItem("Mahna Petals", "MAHNA_PETALS",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem ROVITA = new DummyItem("Rovita", "ROVITA",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);
    public static final DummyItem BELLETHORN = new DummyItem("Bellethorn", "BELLETHORN",
            "A high-quality ingredient used in cooking.", 999,
            "???", 10);



    //FISH
    public static final DummyItem FISH_CARP= new DummyItem("Carp", "FISH_CARP",
            "Sought after by fishermen.", 999,
            "HUB - Various Islands, Various Biomes", 10);
    public static final DummyItem FISH_CHUB = new DummyItem("Chub", "FISH_CHUB",
            "Sought after by fishermen.", 999,
            "HUB - Jungle Island, Jungle Fishing", 10);
    public static final DummyItem FISH_CHUB_TITANIC = new DummyItem("Titanic Chub", "FISH_CHUB_TITANIC",
            "Sought after by fishermen.", 999,
            "HUB - Jungle Island, Jungle Fishing", 10);
    public static final DummyItem FISH_SUNFISH = new DummyItem("Sunfish", "FISH_SUNFISH",
            "Sought after by fishermen.", 999,
            "HUB - Jungle Island, Jungle Fishing during Day", 10);
    public static final DummyItem FISH_MOONFISH = new DummyItem("Moonfish", "FISH_MOONFISH",
            "Sought after by fishermen.", 999,
            "HUB - Jungle Island, Jungle Fishing during Night", 10);
    public static final DummyItem FISH_SHROOMA_RED = new DummyItem("Red Shrooma", "FISH_SHROOMA_RED",
            "Sought after by fishermen.", 999,
            "HUB - Cubit Island, Roofed Forst and Mushroom Biome Fishing", 10);
    public static final DummyItem FISH_SHROOMA_BROWN = new DummyItem("Brown Shrooma", "FISH_SHROOMA_BROWN",
            "Sought after by fishermen.", 999,
            "HUB - Cubit Island, Roofed Forst and Mushroom Biome Fishing", 10);



    //FISHING BAIT
    public static final DummyItem BAIT_DEEPSEA = new DummyItem("Deepsea Bait", "BAIT_DEEPSEA",
            "Fishing bait used to lure deepsea creatures.", 999,
            "???", 10);
    public static final DummyItem BAIT_TROPICAL = new DummyItem("Tropical Bait", "BAIT_TROPICAL",
            "Fishing bait used to lure tropical creatures.", 999,
            "???", 10);



    // TRINKETS
    public static final HeldItem WHITE_PARTY_HAT = new HeldItem("White Party Hat", "WHITE_PARTY_HAT",
            "???", 999,
            "???", 10);



    // POTIONS
    public static final PotionItem LUCKY_POTION_1 = new PotionItem("Lucky Potion I", "LUCKY_POTION_1",
            "Boosts luck for finding Cubits and Cubit items.", 999,
            "???", 10);



    // COOKING
    public static final CookingItem HONEYBUN = new CookingItem("Honeybun", "HONEYBUN",
            "STAMINA +350", 999,
            "Cooking", 100, "Pure Honey x5, Wheat 8, Aria Powder x1",
            ItemBase.PURE_HONEY, ItemBase.WHEAT, ItemBase.ARIA_POWDER, ItemBase.DUMMY, ItemBase.DUMMY, 5, 8, 1, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 350);  }});
    public static final CookingItem SAPPLEBERRY_PIE = new CookingItem("Sappleberry Pie", "SAPPLEBERRY_PIE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.SAPPLEBERRY, ItemBase.WHEAT, ItemBase.STRAWBERRY, ItemBase.DUMMY, ItemBase.DUMMY, 10, 10, 3, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem BREAD = new CookingItem("Bread", "BREAD",
            "STAMINA +400", 999,
            "Cooking", 100, "Wheat x10",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 10, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); }});
    public static final CookingItem COBBLEROLL = new CookingItem("Cobbleroll", "COBBLEROLL",
            "STAMINA +600", 999,
            "Cooking", 100, "Cobble Crunchies x10, Wheat x10, Strawberry x3",
            ItemBase.COBBLE_CRUNCHIES, ItemBase.WHEAT, ItemBase.STRAWBERRY, ItemBase.DUMMY, ItemBase.DUMMY, 10, 10, 3, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 600); }});




    public static final CookingItem FRUIT_SALAD = new CookingItem("Fruit Salad", "FRUIT_SALAD",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Wheat x1",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem SPICY_CURRY = new CookingItem("Spicy Curry", "SPICY_CURRY",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem BURGER = new CookingItem("Burger", "BURGER",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem BURRITO = new CookingItem("Burrito", "BURRITO",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem CROISSANT = new CookingItem("Croissant", "CROISSANT",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem DANGO = new CookingItem("Dango", "DANGO",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem DRAGON_FRUIT_PIE = new CookingItem("Dragon Fruit Pie", "DRAGON_FRUIT_PIE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem EGG_TOAST = new CookingItem("Egg Toast", "EGG_TOAST",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem FRUIT_SANDWICH = new CookingItem("Fruit Sandwich", "FRUIT_SANDWICH",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem GRAPE_DOUGHNUT = new CookingItem("Grape Doughnut", "GRAPE_DOUGHNUT",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem GRILLED_CHEESE = new CookingItem("Grilled Cheese", "GRILLED_CHEESE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem ICE_CREAM = new CookingItem("Ice Cream", "ICE_CREAM",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem ICE_CREAM_SANDWICH = new CookingItem("Ice Cream Sandwich", "ICE_CREAM_SANDWICH",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem RAMEN = new CookingItem("Ramen", "RAMEN",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem SALMON_SUSHI = new CookingItem("Salmon Sushi", "SALMON_SUSHI",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem STRAWBERRY_DOUGHNUT = new CookingItem("Strawberry Doughnut", "STRAWBERRY_DOUGHNUT",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem STRAWBERRY_CAKE = new CookingItem("Strawberry Cake", "STRAWBERRY_CAKE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem SUSHI_ROLL = new CookingItem("Sushi Roll", "SUSHI_ROLL",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem TACO = new CookingItem("Taco", "TACO",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem TAMAGO_SANDO = new CookingItem("Tamago Sando", "TAMAGO_SANDO",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem TAMAGO_NIGIRI = new CookingItem("Tamago Nigiri", "TAMAGO_NIGIRI",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem TANOOKI_COOKIE = new CookingItem("Tanooki Cookie", "TANOOKI_COOKIE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem TUNA_SUSHI = new CookingItem("Tuna Sushi", "TUNA_SUSHI",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem WAFFLE = new CookingItem("Waffle", "WAFFLE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem WAFFLE_PLATTER = new CookingItem("Waffle Platter", "WAFFLE_PLATTER",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem DUMPLING = new CookingItem("Dumpling", "DUMPLING",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem LEMONADE = new CookingItem("Lemonade", "LEMONADE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem MACAROON = new CookingItem("Macaroon", "MACAROON",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem MINT_COOKIE = new CookingItem("Mint Cookie", "MINT_COOKIE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});
    public static final CookingItem VANILLA_COOKIE = new CookingItem("Vanilla Cookie", "VANILLA_COOKIE",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Sappleberries x10, Wheat x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});

    public static final CookingItem FORBIDDEN_TREAT = new CookingItem("Forbidden Treat", "FORBIDDEN_TREAT",
            "POW/SWIM/RUN/FLY +15000, STAMINA +25000", 999,
            "Cooking", 100, "---",
            ItemBase.DRAGONFRUIT, ItemBase.BELLETHORN, ItemBase.NAZOBERRY, ItemBase.GOLDEN_BRAMBLE_FRUIT, ItemBase.PURE_HONEY, 10, 3, 3, 3, 1,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});

    public static final CookingItem MYSTERY_MEAL = new CookingItem("Mystery Meal", "MYSTERY_MEAL",
            "Gives a random boost of 1-1000 to every stat!", 999,
            "Cooking", 100, "---",
            ItemBase.NAZOBERRY, ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 10, 10, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 10);  }});

    public static final CookingItem OKONOMIYAKI = new CookingItem("Okonomiyaki", "OKONOMIYAKI",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Dragonfruit x10, Bellethorn x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});

    public static final CookingItem IKURA = new CookingItem("Ikura", "IKURA",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Dragonfruit x10, Bellethorn x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});

    public static final CookingItem SAKURA_MOCHI = new CookingItem("Sakura Mochi", "SAKURA_MOCHI",
            "FLY/SWIM + 600, STAMINA +400", 999,
            "Cooking", 100, "Dragonfruit x10, Bellethorn x10, Strawberry x3",
            ItemBase.WHEAT, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, ItemBase.DUMMY, 1, 0, 0, 0, 0,
            new HashMap<>(){{ put(CubitStat.STAMINA, 400); put(CubitStat.FLY, 600); put(CubitStat.SWIM, 600); }});






    protected String name;
    protected String identifier;
    protected String description;
    protected int customModelData;
    protected String glosseryObtain;
    protected int cost;
    protected ItemType itemType;

    public ItemBase(){}

    protected ItemBase(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost) {
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.customModelData = customModeldata;
        this.glosseryObtain = glosseryObtain;
        this.cost = cost;
    }

    public abstract void OnConsume(Cubit cubit, PlayerProfile playerProfile);

    // Getters
    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public int getCustomModelData() {
        return customModelData;
    }

    public String getGlosseryObtain() {
        return glosseryObtain;
    }

    public int getCost() {
        return cost;
    }

    public ItemType getItemType() {
        return itemType;
    }


}
