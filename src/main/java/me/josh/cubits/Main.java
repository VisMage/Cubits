package me.josh.cubits;

import me.josh.cubits.commands.CommandManager;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.cubitdata.GlobalCubitStatistics;
import me.josh.cubits.cubitentity.Animator;
import me.josh.cubits.cubitentity.CancelCubitGrieve;
import me.josh.cubits.cubitentity.WolfTeleportRadius;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.listeners.*;
import me.josh.cubits.listeners.bag.*;
import me.josh.cubits.listeners.index.*;
import me.josh.cubits.menus.shopkeepers.SetDailyShopStock;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private PlayerProfileManager playerProfileManager;
    private GlobalCubitStatistics globalCubitStatistic;
    static Main instance;

    @Override
    public void onEnable() {
        instance = this;

//        PlayerProfileSerializer playerProfileSerializer = new PlayerProfileSerializer(this);
//        playerProfileManager = playerProfileSerializer.deserialize();

        saveDefaultConfig();
        CubitDatabase.init();

        playerProfileManager = new PlayerProfileManager(this);
        globalCubitStatistic = new GlobalCubitStatistics();

        // Setting the command executor class for the "cb" command
        getCommand("cb").setExecutor(new CommandManager(this));

        // Listeners
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerStatMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new PetMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new CubitListener(this), this);
        getServer().getPluginManager().registerEvents(new FindCubitListener(this), this);
        getServer().getPluginManager().registerEvents(new FindTreatListener(this), this);
        getServer().getPluginManager().registerEvents(new SkillPointGainListener(this), this);
        getServer().getPluginManager().registerEvents(new StarterListener(this), this);
        getServer().getPluginManager().registerEvents(new CancelCubitGrieve(this), this);
        getServer().getPluginManager().registerEvents(new TeleportOnWorldSwitch(this), this);
        getServer().getPluginManager().registerEvents(new UnequipOnLeave(this), this);
        getServer().getPluginManager().registerEvents(new ShopkeeperListener(this), this);
        getServer().getPluginManager().registerEvents(new SellitemStoreListener(this), this);
        getServer().getPluginManager().registerEvents(new LootboxMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new ChunkUnloadListener(this), this);
        getServer().getPluginManager().registerEvents(new BagCatigoryListener(this), this);
        getServer().getPluginManager().registerEvents(new BagTreatListener(this), this);
        getServer().getPluginManager().registerEvents(new BagDummyListener(this), this);
        getServer().getPluginManager().registerEvents(new BagCosmeticListener(this), this);
        getServer().getPluginManager().registerEvents(new BagCookingListener(this), this);
        getServer().getPluginManager().registerEvents(new SummeryListener(this), this);
        getServer().getPluginManager().registerEvents(new RightClickCubitListener(this), this);
        getServer().getPluginManager().registerEvents(new IndexMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new IndexMenuTreatsListener(this), this);
        getServer().getPluginManager().registerEvents(new IndexMenuCosmeticListener(this), this);
        getServer().getPluginManager().registerEvents(new IndexMenuDummyListener(this), this);
        getServer().getPluginManager().registerEvents(new IndexMenuCubitListener(this), this);
        getServer().getPluginManager().registerEvents(new RebirthMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new TreasureChestListener(this), this);
        getServer().getPluginManager().registerEvents(new FindTokenListener(this), this);
        getServer().getPluginManager().registerEvents(new FindTreasureChestListener(this), this);
        getServer().getPluginManager().registerEvents(new FishingListener(this), this);
        getServer().getPluginManager().registerEvents(new QuestListener(this), this);
        getServer().getPluginManager().registerEvents(new QuestMenuListener(this), this);
        getServer().getPluginManager().registerEvents(new SlayerMenuListener(this), this);

        // The task to run every second
        new WolfTeleportRadius(this).runTaskTimer(this, 0L, 20L);

        // Run animations
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> new Animator(this).runGlobalAnimation(), 0L, 2L);

        // Shop Items
        new SetDailyShopStock();



        // Enable Message
        System.out.println("================================");
        System.out.println("Cubits has been Enabled");
        System.out.println("================================");
    }

    @Override
    public void onDisable() {
//        Serializer<PlayerProfileManager> playerProfileSerializer = playerProfileManager.serializer();
//        playerProfileSerializer.serialize(playerProfileManager);

        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerProfile playerProfile = playerProfileManager.getProfileOf(player.getUniqueId());
            if (playerProfile == null){
                continue;
            }
            if (!playerProfile.getActiveCubitEntity().isActive()){
                continue;
            }

            playerProfile.getActiveCubitEntity().UnequipCubit();
        }

        // Disable Message
        System.out.println("================================");
        System.out.println("Cubits has been Disabled");
        System.out.println("================================");
    }

    public PlayerProfileManager getPlayerProfileManager(){
        return playerProfileManager;
    }

    public GlobalCubitStatistics getGlobalCubitStatistics(){
        return globalCubitStatistic;
    }

    //Option for other classes to get the instance of the MainClass
    public static Main getInstance() {
        return instance;
    }

}
