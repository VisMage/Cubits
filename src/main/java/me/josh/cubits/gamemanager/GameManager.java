package me.josh.cubits.gamemanager;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.cubitdata.GlobalCubitStatistics;
import me.josh.cubits.cubitentity.Animator;
import me.josh.cubits.cubitentity.CancelCubitGrieve;
import me.josh.cubits.cubitentity.WolfTeleportRadius;
import me.josh.cubits.items.PotionDurationTask;
import me.josh.cubits.listeners.*;
import me.josh.cubits.listeners.bag.*;
import me.josh.cubits.listeners.index.*;
import me.josh.cubits.menus.shopkeepers.SetDailyShopStock;
import me.josh.cubits.playerdata.PlayerProfileManager;
import me.josh.cubits.shinycharm.ShinyCharmAnimator;
import me.josh.cubits.shinycharm.ShinyCharmListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.io.*;
import java.nio.file.Files;

public class GameManager {

    private Main plugin;
    private PlayerProfileManager playerProfileManager;
    private GlobalCubitStatistics globalCubitStatistic;
    private InitializePlayersListener cubitListener;
    private ShinyCharmAnimator shinyCharmAnimator;
    private boolean shouldSaveGameData;

    public GameManager(Main plugin){
        this.plugin = plugin;
        shouldSaveGameData = true;
    }

    public void init(){
        CubitDatabase.init();
        if(hasSaveFile()){
            loadSaveFile();
        }else{
            newSaveFile();
        }
        // Shop Items
        new SetDailyShopStock();

        // Shiny Charm Animator
        shinyCharmAnimator = new ShinyCharmAnimator(plugin);
        shinyCharmAnimator.shinyOnEnable();

        registerListeners();
        runScheduledTasks();
    }


    public void registerListeners(){
        // Listeners
        registerListener(cubitListener);
        registerListener(new MenuListener(plugin));
        registerListener(new PlayerStatMenuListener(plugin));
        registerListener(new PetMenuListener(plugin));
        registerListener(new FindCubitListener(plugin));
        registerListener(new FindTreatListener(plugin));
        registerListener(new SkillPointGainListener(plugin));
        registerListener(new StarterListener(plugin));
        registerListener(new CancelCubitGrieve(plugin));
        registerListener(new TeleportOnWorldSwitch(plugin));
        registerListener(new JoinLeaveListener(plugin));
        registerListener(new ShopkeeperListener(plugin));
        registerListener(new SellitemStoreListener(plugin));
        registerListener(new LootboxMenuListener(plugin));
        registerListener(new ChunkUnloadListener(plugin));
        registerListener(new BagCatigoryListener(plugin));
        registerListener(new BagTreatListener(plugin));
        registerListener(new BagDummyListener(plugin));
        registerListener(new BagTrinketListener(plugin));
        registerListener(new BagCosmeticListener(plugin));
        registerListener(new BagCookingListener(plugin));
        registerListener(new SummeryListener(plugin));
        registerListener(new RightClickCubitListener(plugin));
        registerListener(new IndexMenuListener(plugin));
        registerListener(new IndexMenuTreatsListener(plugin));
        registerListener(new IndexMenuCosmeticListener(plugin));
        registerListener(new IndexMenuDummyListener(plugin));
        registerListener(new IndexMenuCubitListener(plugin));
        registerListener(new RebirthMenuListener(plugin));
        registerListener(new TreasureChestListener(plugin));
        registerListener(new FindTokenListener(plugin));
        registerListener(new FindTreasureChestListener(plugin));
        registerListener(new FishingListener(plugin));
        registerListener(new QuestListener(plugin));
        registerListener(new QuestMenuListener(plugin));
        registerListener(new SlayerMenuListener(plugin));
        registerListener(new SlayerUpgradeMenuListener(plugin));
        registerListener(new FishermanMenuListener(plugin));
        registerListener(new FishingUpgradeMenuListener(plugin));
        registerListener(new BagPotionListener(plugin));
        registerListener(new PotionListener(plugin));
        registerListener(new RibbonMenuListener(plugin));
        registerListener(new AchievementMenuListener(plugin));
        registerListener(new AchievementListener(plugin));
        registerListener(new ShinyCharmListener(plugin));
        registerListener(new TreasureTrackerMenuListener(plugin));

    }

    public void registerListener(Listener listener){
        plugin.getServer().getPluginManager().registerEvents(listener,plugin);
    }

    public void newSaveFile(){
        plugin.getLogger().info("New Save File Created");
        plugin.getServer().getScheduler().cancelTasks(plugin);
        HandlerList.unregisterAll(plugin);
        playerProfileManager = new PlayerProfileManager(plugin);
        globalCubitStatistic = new GlobalCubitStatistics();
        cubitListener = new InitializePlayersListener(plugin);
    }

    public void runScheduledTasks(){
        // The task to run every second
        new WolfTeleportRadius(plugin).runTaskTimer(plugin, 0L, 20L);

        // Run animations
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> new Animator(plugin).runGlobalAnimation(), 0L, 2L);

        new PotionDurationTask(plugin).runTaskTimer(plugin, 20L, 20L);
    }

    private boolean hasSaveFile(){
        return Files.exists(getSaveFile().toPath());
    }

    private File getSaveFile(){
        return new File(plugin.getDataFolder() + "/save.dat");
    }

    public void saveGameData(){
        if (!shouldSaveGameData){
            return;
        }
        plugin.getLogger().info("Saving Game");
        SaveData saveData = new SaveData();
        saveData.playerProfileManager = playerProfileManager;
        saveData.globalCubitStatistic = globalCubitStatistic;
        try {
            FileOutputStream fileOutputSteam = new FileOutputStream(getSaveFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputSteam);
            objectOutputStream.writeObject(saveData);
            fileOutputSteam.close();
            objectOutputStream.close();
            plugin.getLogger().info("File Saved");
        }
        catch (Exception e) {
            e.printStackTrace();
            plugin.getLogger().severe("Saving game data failed ...");
        }
    }

    private void loadSaveFile(){
        plugin.getLogger().info("Loading Save Data");
        try {
            FileInputStream fileInputStream = new FileInputStream(getSaveFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SaveData saveData = (SaveData) objectInputStream.readObject();
            playerProfileManager = saveData.playerProfileManager;
            globalCubitStatistic = saveData.globalCubitStatistic;
            cubitListener = new InitializePlayersListener(plugin);
            shouldSaveGameData = true;
        }
        catch(Exception e) {
            plugin.getLogger().severe("Loading game data failed ...");
            shouldSaveGameData = false;
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }

    public PlayerProfileManager getPlayerProfileManager() {
        return playerProfileManager;
    }

    public GlobalCubitStatistics getGlobalCubitStatistic() {
        return globalCubitStatistic;
    }
}
