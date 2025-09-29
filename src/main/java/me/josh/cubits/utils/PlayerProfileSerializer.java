package me.josh.cubits.utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerProfileManager;
import me.josh.cubits.playerdata.PlayerVariables;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlayerProfileSerializer implements Serializer<PlayerProfileManager> {

    private final Main plugin;
    private FileConfiguration config;


    public PlayerProfileSerializer(Main plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
    }

    @Override
    public void serialize(PlayerProfileManager data) {
        Gson gson = new Gson();
        try{
            FileWriter fileWriter = new FileWriter(plugin.getDataFolder() + "/PlayerProfile.json");
            gson.toJson(data.getPlayerProfiles(), fileWriter);
            fileWriter.close();
        }
        catch (IOException e){
            plugin.getLogger().warning("Could not serialize PlayerProfileManager");
        }

    }

    @Override
    public PlayerProfileManager deserialize() {

        PlayerProfileManager playerProfileManager = new PlayerProfileManager(plugin);
        Gson gson = new Gson();
        try{
            FileReader fileReader = new FileReader(plugin.getDataFolder() + "/PlayerProfile.json");
            Type listType = new TypeToken<ArrayList<PlayerProfile>>(){}.getType();
            List<PlayerProfile> playerProfilesList = gson.fromJson(fileReader, listType);
            playerProfileManager.setPlayerProfile(playerProfilesList);
        }
        catch (IOException e){
            plugin.getLogger().warning("Could not deserialize PlayerProfileManager");
        }

        return playerProfileManager;
    }


//    @Override
//    public void serialize(List data) {
//        config.set("Players", null);
//        plugin.saveConfig();
//        if(data == null || data.isEmpty() || !(data.get(0) instanceof PlayerProfile))
//            return;
//
//        List<PlayerProfile> playerProfiles = (ArrayList<PlayerProfile>)data;
//        for(int i = 0; i < playerProfiles.size(); i++) {
//            String playerSection = "Players." + playerProfiles.get(i).getUuid();
//            //config.set(playerSection, null);
//            //System.out.println("Number of Cubits this player owns: " + playerProfiles.get(i).getCubits().size());
//            config.set(playerSection + ".Number_of_Cubits", playerProfiles.get(i).getCubits().size());
//
//
//            String playerStatsSection = playerSection + ".Player_Stats";
//            config.set(playerStatsSection + ".Farming", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_FARMING));
//            config.set(playerStatsSection + ".Foraging", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_FORAGING));
//            config.set(playerStatsSection + ".Adventuring", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_ADVENTURING));
//            config.set(playerStatsSection + ".Mining", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_MINING));
//            config.set(playerStatsSection + ".Fishing", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_FISHING));
//            config.set(playerStatsSection + ".Magic", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_MAGIC));
//            config.set(playerStatsSection + ".Alchemy", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_ALCHEMY));
//            config.set(playerStatsSection + ".Crafting", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_CRAFTING));
//            config.set(playerStatsSection + ".Cooking", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_COOKING));
//            config.set(playerStatsSection + ".Slayer", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.STAT_SLAYER));
//
//
//            String playerVariablesSection = playerSection + ".Player_Variables";
//            config.set(playerVariablesSection + ".Shiny_Charms", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.SHINY_CHARMS));
//            config.set(playerVariablesSection + ".Mushrooms_Found", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.MUSHROOMS_FOUND));
//            config.set(playerVariablesSection + ".Fish_Caught", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.FISH_CAUGHT));
//            config.set(playerVariablesSection + ".Active_Fishing_Quest_Species", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.ACTIVE_FISHING_QUEST_SPECIES));
//            config.set(playerVariablesSection + ".Active_Fishing_Quest_Amount", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.ACTIVE_FISHING_QUEST_AMOUNT));
//            config.set(playerVariablesSection + ".If_Starter", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.IF_STARTER));
//
//
//            String currencySection = playerSection + ".Currency";
//            config.set(currencySection + ".Survival_Tokens", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.SURVIVAL));
//            config.set(currencySection + ".Combat_Tokens", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.COMBAT));
//            config.set(currencySection + ".Foraging_Tokens", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.FORAGING));
//            config.set(currencySection + ".Fishing_Tokens", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.FISHING));
//            config.set(currencySection + ".Mystic_Tokens", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.MYTHIC));
//            config.set(currencySection + ".Essence", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.ESSENCE));
//            config.set(currencySection + ".Coins", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.COINS));
//            config.set(currencySection + ".Gems", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.GEMS));
//            config.set(currencySection + ".Red_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.RED_IRIS));
//            config.set(currencySection + ".Blue_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.BLUE_IRIS));
//            config.set(currencySection + ".Yellow_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.YELLOW_IRIS));
//            config.set(currencySection + ".Green_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.GREEN_IRIS));
//            config.set(currencySection + ".White_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.WHITE_IRIS));
//            config.set(currencySection + ".Black_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.BLACK_IRIS));
//            config.set(currencySection + ".Nova_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.NOVA_IRIS));
//            config.set(currencySection + ".Null_Iris", playerProfiles.get(i).getMiniGameTokens().get(MiniGameToken.NULL_IRIS));
//
//
//            String playerFavorSection = playerSection + ".Player_Favor";
//            config.set(playerFavorSection + ".Fisherman", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.FAVOR_FISHERMAN));
//            config.set(playerFavorSection + ".Mushroom_Man", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.FAVOR_MUSHROOMMAN));
//            config.set(playerFavorSection + ".General_Shop", playerProfiles.get(i).getPlayerVariables().get(PlayerVariables.FAVOR_GENERALSHOP));
//
//
//
//            for(int j = 0; j < playerProfiles.get(i).getCubits().size(); j++) {
//                String cubitSection = playerSection + ".Cubits." + playerProfiles.get(i).getCubits().get(j).getUuid();
//                config.set(cubitSection + ".Name", playerProfiles.get(i).getCubits().get(j).getName());
//                config.set(cubitSection + ".Description", playerProfiles.get(i).getCubits().get(j).getCubitBase().getDescription());
//                config.set(cubitSection + ".Base", playerProfiles.get(i).getCubits().get(j).getCubitBase().getName());
//                config.set(cubitSection + ".Rarity", playerProfiles.get(i).getCubits().get(j).getRarity());
//                config.set(cubitSection + ".AltSkin", playerProfiles.get(i).getCubits().get(j).getAltSkin());
//                config.set(cubitSection + ".Exp", playerProfiles.get(i).getCubits().get(j).getExp());
//                config.set(cubitSection + ".OriginalOwnerUUID", playerProfiles.get(i).getCubits().get(j).getOriginalOwnerUUID().toString());
//                config.set(cubitSection + ".OriginalOwnerName", playerProfiles.get(i).getCubits().get(j).getOriginalOwnerName());
//                config.set(cubitSection + ".Shiny", playerProfiles.get(i).getCubits().get(j).getShiny());
//                config.set(cubitSection + ".Starter", playerProfiles.get(i).getCubits().get(j).getStarter());
//                //config.set(cubitSection + ".HeldItem", playerProfiles.get(i).getCubits().get(j).getRebirth());
//
//                String gradesSection = cubitSection + ".Grades.";
//                config.set(gradesSection + ".Stamina", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.STAMINA));
//                config.set(gradesSection + ".Fly", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.FLY));
//                config.set(gradesSection + ".Swim", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.SWIM));
//                config.set(gradesSection + ".Run", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.RUN));
//                config.set(gradesSection + ".Power", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.POWER));
//                config.set(gradesSection + ".Mystic", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.MYSTIC));
//                config.set(gradesSection + ".Dark_Magic", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.DARK_MAGIC));
//                config.set(gradesSection + ".Luck", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.LUCK));
//
//                String statsSection = cubitSection + ".Stats.";
//                config.set(statsSection + ".Stamina", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.STAMINA));
//                config.set(statsSection + ".Fly", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.FLY));
//                config.set(statsSection + ".Swim", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.SWIM));
//                config.set(statsSection + ".Run", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.RUN));
//                config.set(statsSection + ".Power", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.POWER));
//                config.set(statsSection + ".Mystic", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.MYSTIC));
//                config.set(statsSection + ".Dark_Magic", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.DARK_MAGIC));
//                config.set(statsSection + ".Luck", playerProfiles.get(i).getCubits().get(j).getStats().get(CubitStat.LUCK));
//
//
//            }
//        }
//
//        plugin.saveConfig();
//    }
//
//    @Override
//    public List<PlayerProfile> deserialize() {
//        List<PlayerProfile> playerProfiles = new ArrayList<>();
//        return playerProfiles;
//    }










    //END
}
