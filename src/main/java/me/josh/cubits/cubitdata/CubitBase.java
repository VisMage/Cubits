package me.josh.cubits.cubitdata;

import org.bukkit.ChatColor;

import java.util.HashMap;

public class CubitBase {
    //Starters
    public static final CubitBase SHEEP = new CubitBase("Sheepy", "Fluffy little friend!","http://textures.minecraft.net/texture/fdc7e7e5301a5df260b4e9b15ee5af6c355e173160001aa502eb92695e2a6f88",
            "Breed Sheep 1/500", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CRABBY = new CubitBase("Crabby", "Scuttle-scuttle!","http://textures.minecraft.net/texture/5ba696ed7bd1d9a0ee445058051726d2a61537a90ecd207a507c5cb0c49e3454",
            "Fishing in Mangrove Swamp 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PENGIN = new CubitBase("Pengin", "Tipping the iceberg!","http://textures.minecraft.net/texture/3e81c9c209f9c29380fd07e25dda8e789dba6c60f6a17543153c4833ae194159",
            "Fishing at the Snowy Village 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase AXIE = new CubitBase("Axie", "Kinda squishy!","http://textures.minecraft.net/texture/a773d8875c98911538e100ac02e17a2763ae7f71258224b8bf9557b3d5dde006",
            "Breed Axolotl 1/100", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE = new CubitBase("Bee", "Bumble buddy!","http://textures.minecraft.net/texture/4420c9c43e095880dcd2e281c81f47b163b478f58a584bb61f93e6e10a155f31",
            "Breed Bee 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase FLOPPER = new CubitBase("Flopper", "Blub blub!", "http://textures.minecraft.net/texture/40cd71fbbbbb66c7baf7881f415c64fa84f6504958a57ccdb8589252647ea",
            "Any Fish 1/750", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_ANGRY = new CubitBase("Angry Flopper", "Fishy with no chill!", "http://textures.minecraft.net/texture/f0a53339771edc2dc6eccb4f686fe6687bc0f0bf963f835eb839c749d4934862",
            "Any Fish 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_RADIOACTIVE = new CubitBase("Radioactive Flopper", "Only God knows what he's been swimming in!", "http://textures.minecraft.net/texture/b0e2363c2d41a9d323ba625de8c0637063a36fe85a045de275a7b7739ded6051",
            "Fishing at Torrin Ind. 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_KOI = new CubitBase("Koi Flopper", "Wise fishy of the sea, what is your wisdom?", "http://textures.minecraft.net/texture/fb6b8cedfead4286f6c0bba32bbd365d2a8ca2f1eacd7b9d95147417dbbae9d4",
            "Fishing in Warm Ocean 1/350", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_CLOWN = new CubitBase("Silly Flopper", "What a silly little guy!", "http://textures.minecraft.net/texture/d6dd5e6addb56acbc694ea4ba5923b1b25688178feffa72290299e2505c97281",
            "Catch a Tropical Fish in Warm Ocean 1/100", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_IRIDIUM = new CubitBase("Iridium Salmon", "Resilient treasure of the sea!", "http://textures.minecraft.net/texture/7b72fb5a3842c7c203984531d2722fa912fde026c8529d33f7113eacfd8a604d",
            "Catch a Salmon 1/3000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_SAND = new CubitBase("Sandfish", "An elusive fishy the burrows in sand.","http://textures.minecraft.net/texture/570087dde130846c0e975fe68435d8940f09339fabc6026a9699fdb612b4f121",
            "Fishing in Desert during Day 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLOPPER_RAINSKIPPER = new CubitBase("Rainskipper", "Legend says he can dodge the falling raindrops!","http://textures.minecraft.net/texture/d82efd885e6e2a964efb857de724b2ef043f1dcbbe618f10ec3742c6f2cecab",
            "Catch a Cod while Raining 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase PUFFER = new CubitBase("Puffer", "Bro thinks he's a cactus!","http://textures.minecraft.net/texture/292350c9f0993ed54db2c7113936325683ffc20104a9b622aa457d37e708d931",
            "Catch a Pufferfish 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_QWILL = new CubitBase("Qwill Puffer", "Watch the quills!","http://textures.minecraft.net/texture/6be7e3f5cf5820614ab529bbd01c702c885a6c49eab743d04b4403743843d9bf",
            "Catch a Pufferfsih (SWIM 10000+) 1/250", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_GRASS = new CubitBase("Grassy Puffer", "All terrain puffer!","http://textures.minecraft.net/texture/c3e93e5101b2cf057bcea64650c1ed89854bfb0f4798a183caf0e041975fcf9a",
            "Fishing at the Fishing Docks 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_MC = new CubitBase("McPuffer", "A productive member of society!","http://textures.minecraft.net/texture/815a0dfed9beb294f24dfca2c65f28146880ef029fb804f62dae2b0dae997703",
            "Catch a Pufferfish 1/1200", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_LUNAR = new CubitBase("Lunar Puffer", "A majestic glow radiates off this handsome fishy friend!","http://textures.minecraft.net/texture/b49f2a8ac85776a3f185c3d9bd849b25d5fadf4acda66686d9d82118e93fdb39",
            "???", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_FROZEN = new CubitBase("Frozen Puffer", "Get this man a sweater!","http://textures.minecraft.net/texture/1107b713e69d6d7eceb2fd50a23057963f47d94a829a6faa898791aa660b391e",
            "Fishing in a snowy biome 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_GUARDIAN = new CubitBase("Guardian Puffer", "What could he be guarding!","http://textures.minecraft.net/texture/bd10fb5a0eca694f782541186b20ac31df3b263f84eb88fc0728e22b64f78bad",
            "Killing a Guardian 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFER_ELDER = new CubitBase("Elder Guardian Puffer", "He knows...","http://textures.minecraft.net/texture/c94997ce2c4b11b07f5f7697f0daf74db6f2d80780a444ce8f4a8f7feba9a7cd",
            "Killing an Elder Guardian 1/100", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase JELLY_GLOW = new CubitBase("Glow Jelly", "A dazzling deepsea Jellyfish!","http://textures.minecraft.net/texture/1d072732db70fdaf0b2aae67bc415be15300ab336a14f199a4f4130db43551a2",
            "Catch a Cod in Warm Ocean at Night (SWIM 10000+) 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase JELLY_COBALT = new CubitBase("Cobalt Jelly", "A deep blue Jellyfish!","http://textures.minecraft.net/texture/60bbd731956affcf20fdf0e5004c20c96e94cfb38d45ed3e771bd070034a48b6",
            "???", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase BLOOP = new CubitBase("Inky Bloop", "Squishy little friend!","http://textures.minecraft.net/texture/464bdc6f600656511bef596c1a16aab1d3f5dbaae8bee19d5c04de0db21ce92c",
            "Kill a Squid 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOOP_GLOW = new CubitBase("Glow Bloop", "Glowy little friend!","http://textures.minecraft.net/texture/55e2b46e52ac92d419a2ddbcc9cdce7b451cb48ae739d85d607db0502a008ce0",
            "Fishing in Lush Cave 1/500", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase AXIE_SCULK = new CubitBase("Sculk Axie", "Even the Warden needs a silly little friend!","http://textures.minecraft.net/texture/bbebfca53938659e264c320c634fe1229a8aa3304005b1c1c479d40be35a44ea",
            "Fishing in Deep Dark 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase SHEEP_SILLY = new CubitBase("Silly Sheepy", "Silly little dude!","http://textures.minecraft.net/texture/ed78d26653a953b9e6ba9c7de8c01d204f40dcfffca051258ca7864c82ca355f",
            "Breed Sheep 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase SHEEP_PUMPKIN = new CubitBase("Pumpkin Sheepy", "Cute pumpkin sheep!","http://textures.minecraft.net/texture/c3fa1d9f2efd3a24c18ab259b4eb5750a6a0e119be7c86c70b615bba9c82f9ac",
            "Harvest Pumpkin 1/5000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase COOKIE = new CubitBase("Cookie Cubit", "Looks tasty!","http://textures.minecraft.net/texture/6fed4fedd539729f4749908bdef6218f89f999a2c2b4cad71274e3797a00789f",
            "Eat Cookie 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);





    public static final CubitBase CHUPPO = new CubitBase("Chuppo", "Little fella!","http://textures.minecraft.net/texture/1a174c1f004d1d19c3bf6723515ea0dc0d7c792a92e68238bb0a0c5a180d8842",
            "Exotic Cubit Merchant", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase GOOBER = new CubitBase("Goober", "Very squishy!","http://textures.minecraft.net/texture/61affd31efc37ba84f50187394d8688344ccd06cdc926ddfcf2df116986dca9",
            "Kill a Slime 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase GOOBER_GARDEN = new CubitBase("Garden Goober", "Extra squishy!","http://textures.minecraft.net/texture/db1298e3abaff653b877ac805ae611cb146a9e19a717c0561890e7f18e44d3ce",
            "Kill a Slime 1/4000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase GOOBER_HONEY = new CubitBase("Honey Goober", "Ooey and Gooey!","http://textures.minecraft.net/texture/9c5a2d9ca55bb123caf1c957e09b9f886d799d2a3c48bf6245f4ef85f36ffe20",
            "???", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);





    public static final CubitBase ROOTLING_OAK = new CubitBase("Oak Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Oak Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_BIRCH = new CubitBase("Birch Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Birch Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_SPRUCE = new CubitBase("Spruce Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Spruce Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_DARK_OAK = new CubitBase("Dark Oak Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Dark Oak Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_ACACIA = new CubitBase("Acacia Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Acacia Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_MANGROVE = new CubitBase("Mangrove Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Mangrove Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_CHERRY = new CubitBase("Cherry Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Cherry Log 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_CRIMSON = new CubitBase("Crimson Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Crimson Stem 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROOTLING_WARPED = new CubitBase("Warped Rootling", "One with nature.","http://textures.minecraft.net/texture/d18c20f8c5872eb1d80802f673122fbe308913d1b6ba4176a44e9d673d499e4",
            "Chop Warped Stem 1/10000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase DRAKE_PLUM = new CubitBase("Plum Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/dff816befd1e7979af1b200364da6e2e43f048bab4c01c863c58bfc8d729a323",
            "Kill the Ender Dragon 1/10", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase DRAKE_CYAN = new CubitBase("Cyan Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/231bea91bbed2c4435af656daf177d586feddf9d3c60efae8e58e300bc1aed38",
            "Kill the Ender Dragon 1/20", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase DRAKE_PEACH = new CubitBase("Peach Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/50b46f2063d0ca6c09dec393751d96be20acd959856439a32e509d9a7133d6ee",
            "Kill the Ender Dragon 1/30", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase DRAKE_LEMON = new CubitBase("Lemon Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/b8fc1a5fede8eed7d55c1018c4dd657069ecbdc5d6f297aae30b367b7df54ea",
            "Kill the Ender Dragon 1/40", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase DRAKE_CITRUS = new CubitBase("Citrus Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/e9b53f968922e9bfd54a278bbd945f0f5cab1b0b1f686af99997f3c04561fd84",
            "Kill the Ender Dragon 1/60", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase DRAKE_LIME = new CubitBase("Lime Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/5847b2a8403276a25110e834d7160145047e8d7627f63ca609aaf5aeecf3c2b8",
            "Kill the Ender Dragon 1/80", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase DRAKE_WHITE = new CubitBase("White Drake", "Loves to cuddle!","http://textures.minecraft.net/texture/cf883f7998343610e5f446fc3593ede142873e6760e6176e631e14fe22dd39a3",
            "Kill the Ender Dragon 1/100", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase BLOCKBUG_COAL = new CubitBase("Coal Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/d7153ac77ab162f336c3406eb1adb64f643b7d5c6e81b40a5ef0bc986bf43bab",
            "Mine Coal Ore 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_COPPER = new CubitBase("Copper Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/f355fd7b52baeff2adef808c140f063bec26f689aff51e62d19cd3c4ceaf2087",
            "Mine Copper Ore 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_IRON = new CubitBase("Iron Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/58a00dbc8c41430b191ae6900f795e629d9b43ef9f1524e63f6c33a10810fab6",
            "Mine Iron Ore 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_GOLD = new CubitBase("Gold Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/b3687356fbbaac088ffbdc4fd9aaa3fe65ba9fd7ce4c0f73ea56e73438440946",
            "Mine Gold Ore 1/1200", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_REDSTONE = new CubitBase("Redstone Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/3a06c1bf1e6cf073760855426e3addd97872fde55c107fe1a541fec556fc0021",
            "Mine Redstone Ore 1/750", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_LAPIS = new CubitBase("Lapis Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/de8da55ec46ed2f1a392f09d264467c814ac2f2dcc64d5455a9d26affc26f965",
            "Mine Lapis Ore 1/750", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_DIAMOND = new CubitBase("Diamond Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/18f8cab4766bff3f393d4f1c1e0385dbe28eb79912242a0b07cb7021e3a365bb",
            "Mine Diamond Ore 1/600", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_EMERALD = new CubitBase("Emerald Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/9f40c241f00c9c2e4e103c3435b0622d3f5556c527e91610d4be1f7d6d30ecb8",
            "Mine Emerald Ore 1/600", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_CRYSTAL = new CubitBase("Crystal Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/f45156d8f1f1d7095b24fedc810abc7f7c9427aaa44fb52d2d5f75f843c4014b",
            "Mine Any Ore 1/5000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase BLOCKBUG_SANDSTONE = new CubitBase("Sandstone Blockbug", "A shy little fella.","http://textures.minecraft.net/texture/f45156d8f1f1d7095b24fedc810abc7f7c9427aaa44fb52d2d5f75f843c4014b",
            "Mine Any Ore in Desert Biomes 1/1500", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase CUBEE_BUSINESS = new CubitBase("Business Bumble", "He do be hustlin'!","http://textures.minecraft.net/texture/4f29b05efe0665072c8eb7d69723e0ab3b65c2183890f893b5efe93bc204dfca",
            "Breed Bee 1/4000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_LGBEE = new CubitBase("LGBee", "Full of love!","http://textures.minecraft.net/texture/46d3be818c821c295bb02049fd49c58b95d7b2d2a971239172ea776d57d119e3",
            "Breed Bee with Pink Petals 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_PRIDE = new CubitBase("Pride Cubee", "Full of love!","http://textures.minecraft.net/texture/142111ad76f92c584ce1fabdd993dc73939b336d681dbf740d0f13365845c671",
            "Breed Bee with Blue Orchid 1/1000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_ZOMBEE = new CubitBase("Zombee", "He's coming for your honey!","http://textures.minecraft.net/texture/f6e1ae93ad5e94a0904a0877ff14a9de56083242a5786ac7dc503e098ae37120",
            "Kill a Bee at Night 1/333", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_RGB = new CubitBase("RGBee", "A truly epic gamer!","http://textures.minecraft.net/texture/46d3be818c821c295bb02049fd49c58b95d7b2d2a971239172ea776d57d119e3",
            "Mossy Loot Chest", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_PHANTOM = new CubitBase("Phantom Cubee", "The worst one.","http://textures.minecraft.net/texture/c4e22b9f9b568318f35821614a0821c642eb236eee90d9042bd39eca3a62e538",
            "Kill a Phantom 1/200", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_SPIDER = new CubitBase("Spider Cubee", "Oh dear god they can fly now!","http://textures.minecraft.net/texture/a2d60c4f2adb78bb77c7e99cc553f517da7af4688271010cfec5583624e1a0a9",
            "Kill a Phantom 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_SAKURA = new CubitBase("Sakura Cubee", "A single petal in the wind.","http://textures.minecraft.net/texture/b33bacafd2e474d18b8553a5628b3a086ed45e37158efca05ff41c4877d09b43",
            "Breed Bee in Cherry Blossom Biome 1/800", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase CUBEE_PHARAOH = new CubitBase("Pharaoh Cubee", "The ruthless leader of a long lost colony.","http://textures.minecraft.net/texture/cb7bc1536c393a0cb2c139af43e77825efe2edee7a2b3395414765d99f8fd525",
            "Dusty Loot Chest", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase PUFFSTOOL_CRIMSON = new CubitBase("Crimson Puffstool", "What a fun guy!","http://textures.minecraft.net/texture/3052520ee99b6fcdbe70ed1f7cfbc3fb7175f04a2ceb007c9b11d8d727bca044",
            "Chop Crimson Stem in Crimson Forest 1/3000, Mossy Loot Chest", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PUFFSTOOL_COBALT = new CubitBase("Cobalt Puffstool", "Friendly mushroom!","http://textures.minecraft.net/texture/3052520ee99b6fcdbe70ed1f7cfbc3fb7175f04a2ceb007c9b11d8d727bca044",
            "Chop Crimson Stem in Crimson Forest 1/3000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase BEETLE_COBALT = new CubitBase("Cobalt Beetle", "No touchy the horn!","http://textures.minecraft.net/texture/d685ea9ce0d3668692154439859d2863104b42fa082378d504ea66440875cbc2",
            "???", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase FROGGO = new CubitBase("Froggo", "Ribbit ribbit!","http://textures.minecraft.net/texture/45852a95928897746012988fbd5dbaa1b70b7a5fb65157016f4ff3f245374c08",
            "Fishing in Swamp or Mangrove Swamp 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FROGGO_TEMPERATE = new CubitBase("Temperate Froggo", "Ribbit ribbit!","http://textures.minecraft.net/texture/2ca4a8e494582c62aaa2c92474b16d69cd63baa3d3f50a4b631d6559ca0f33f5",
            "Breeding Frogs in Swamp or Mangrove Swamp 1/300", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FROGGO_TUNDRA = new CubitBase("Tundra Froggo", "Ribbit ribbit!","http://textures.minecraft.net/texture/4e86332bdd8567e39605f0d11bae2e45e8603a6d71da06208d81aa3e7e3971cd",
            "Chopping Mangrove Logs in Swamp or Mangrove Swamp 1/5000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FROGGO_GOLDEN = new CubitBase("Golden Froggo", "Vibing on his 24 karrot lillypad.","http://textures.minecraft.net/texture/382b2234cba02cdc386c15a3171f4bbd7506c734648cc0430eb5d6f8141e8245",
            "Change to replace obtained Froggo types 1/3", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FROGGO_CRIMSON = new CubitBase("Crimson Froggo", "He has a ribbeting tale to tell you!","http://textures.minecraft.net/texture/589404233e89a5c98ee9d69812311e7c54fd8300759e0a6525042a6f892e9dac",
            "Slaying mobs in Swamp or Mangrove Swamp 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FROGGO_WARPED = new CubitBase("Warped Froggo", "Down bad for the lillypad!","http://textures.minecraft.net/texture/880da1ee231700c697a482b18e74628177407edee3afa8c38dae45f7bad2e09a",
            "Harvesting crops in Swamp or Mangrove Swamp 1/8000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FROGGO_MYSTIC = new CubitBase("Mystic Froggo", "He has stared into the abyss, and 10,000 fireflies stared back.","http://textures.minecraft.net/texture/3e10e87c2485cefc15eb85ba0b8a5ca5da777740486729d5dfe0c731255de60d",
            "Loot from the Mossy Chest", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);



    public static final CubitBase FLUFFLE_SILVER = new CubitBase("Silver Fluffle", "Watch out for the snaggletooth!","http://textures.minecraft.net/texture/ee0c2566ddab3e7ad993b27c93e3b465c5bed1fd1574adbff237eed37b55ef84",
            "Exotic Cubit Merchant", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLUFFLE_HAZEL = new CubitBase("Hazel Fluffle", "Little bundle of energy!","http://textures.minecraft.net/texture/ee0c2566ddab3e7ad993b27c93e3b465c5bed1fd1574adbff237eed37b55ef84",
            "Exotic Cubit Merchant", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLUFFLE_MARSHMALLOW = new CubitBase("Marshmallow Fluffle", "Puffy little cloud!","http://textures.minecraft.net/texture/ee0c2566ddab3e7ad993b27c93e3b465c5bed1fd1574adbff237eed37b55ef84",
            "Exotic Cubit Merchant", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase FLUFFLE_CREAM = new CubitBase("Cream Fluffle", "Sweet little nugget!","http://textures.minecraft.net/texture/ee0c2566ddab3e7ad993b27c93e3b465c5bed1fd1574adbff237eed37b55ef84",
            "Exotic Cubit Merchant", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);




    public static final CubitBase CREEPER_BABY = new CubitBase("Baby Creeper", "Loves to cuddle!","http://textures.minecraft.net/texture/60ac18acdf87d980b9fdcd95c79c9743c99d0694a90d96e5ff4f06ee78815403",
            "Kill a Creeper 1/2000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase TURTLE = new CubitBase("Turtle", "Slow but steady!","http://textures.minecraft.net/texture/a7f493140887de4b22065d88bd85c5a42e2dffc6761dab0d0108cc04f6572bbc",
            "Breed Turtle 1/500", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase PHOENIX = new CubitBase("Phoenix", "The chosen one!","http://textures.minecraft.net/texture/2dfe58dca44688809a44c27367fcc2880897792af8838f93f2b585afcbe8f137",
            "Kill any Mob 1/1000000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase WARDEN = new CubitBase("Baby Warden", "Goo goo ga ga mother" + ChatColor.MAGIC + "******" + "!","http://textures.minecraft.net/texture/15feba3750caf3d81b645f7a38eadda96653d7b3ca28439b451514e4faaf4864",
            "Kill a Warden 1/20", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);
    public static final CubitBase ROCK = new CubitBase("Pet Rock", "Big thonk!", "http://textures.minecraft.net/texture/dd2f781f03c365bbc5dd1e7186ab38dc69465e836c9fe066a9a844f34a4da92",
            "Mine Stone 1/20000", "---", new HashMap<>(){{
        put(CubitStat.STAMINA, 1.0); put(CubitStat.FLY, 1.0); put(CubitStat.SWIM, 1.0); put(CubitStat.POWER, 1.0);
        put(CubitStat.RUN, 1.0); put(CubitStat.MYSTIC, 1.0); put(CubitStat.DARK_MAGIC, 1.0);
    }}, Rarity.COMMON);










    private String name;
    private String description;
    private String defaultSkin;
    private String obtain;
    private String ability;
    private HashMap<CubitStat, Double> baseStats;
    private Rarity rarity;

    public CubitBase(){}

    private CubitBase(String name, String description, String defaultSkin, String obtain, String ability, HashMap<CubitStat, Double> baseStats, Rarity rarity) {
        this.name = name;
        this.description = description;
        this.obtain = obtain;
        this.ability = ability;
        this.defaultSkin = defaultSkin;
        this.baseStats = baseStats;
        this.rarity = rarity;


    }





    //Getters and Setters


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultSkin() {
        return defaultSkin;
    }

    public String getObtain() {
        return obtain;
    }

    public String getAbility() {
        return ability;
    }

    public Double getBaseStats(CubitStat stat) {
        return baseStats.containsKey(stat) ? baseStats.get(stat) : null;
    }

    public Rarity getRarity() {
        return rarity;
    }






}
