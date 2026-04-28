package me.josh.cubits;

import me.josh.cubits.commands.CommandManager;
import me.josh.cubits.cubitdata.CubitDatabase;
import me.josh.cubits.cubitdata.GlobalCubitStatistics;
import me.josh.cubits.cubitentity.Animator;
import me.josh.cubits.cubitentity.CancelCubitGrieve;
import me.josh.cubits.cubitentity.WolfTeleportRadius;
import me.josh.cubits.gamemanager.GameManager;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.listeners.*;
import me.josh.cubits.listeners.bag.*;
import me.josh.cubits.listeners.index.*;
import me.josh.cubits.menus.shopkeepers.SetDailyShopStock;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerProfileManager;
import me.josh.cubits.shinycharm.ShinyCharmAnimator;
import me.josh.cubits.treasuretracker.TreasureTrackingManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.file.Files;

public class Main extends JavaPlugin {
    static Main instance;
    private GameManager gameManager;
    public int achievementRankMax = 6;
    public int shinyCharmTotal = 50;
    private TreasureTrackingManager treasureTrackingManager;

    @Override
    public void onEnable() {
        instance = this;
        createDataFolder();
        gameManager = new GameManager(this);
        gameManager.init();

        // Setting the command executor class for the "cb" command
        getCommand("cb").setExecutor(new CommandManager(this));

        // Treasure Tracking
        this.treasureTrackingManager = new TreasureTrackingManager(this);
        this.treasureTrackingManager.enable();

        // Enable Message
        System.out.println("================================");
        System.out.println("Cubits has been Enabled");
        System.out.println("================================");
    }

    @Override
    public void onDisable() {

        if (gameManager != null && gameManager.getPlayerProfileManager() != null) {
            gameManager.getPlayerProfileManager().unequipCubitsOnDisable();
        }

        if (gameManager != null) {
            gameManager.saveGameData();
        }

        // Disable Message
        System.out.println("================================");
        System.out.println("Cubits has been Disabled");
        System.out.println("================================");
    }

    private void createDataFolder() {
        try {
            if(!getDataFolder().exists())
                Files.createDirectory(getDataFolder().toPath());
        }
        catch(IOException e) {
            getLogger().severe("Data Folder could not be created");
            e.printStackTrace();
        }
    }

    public PlayerProfileManager getPlayerProfileManager(){
        return gameManager.getPlayerProfileManager();
    }

    public GlobalCubitStatistics getGlobalCubitStatistics(){
        return gameManager.getGlobalCubitStatistic();
    }

    public TreasureTrackingManager getTreasureTrackingManager() {
        return treasureTrackingManager;
    }

    //Option for other classes to get the instance of the MainClass
    public static Main getInstance() {
        return instance;
    }

}
