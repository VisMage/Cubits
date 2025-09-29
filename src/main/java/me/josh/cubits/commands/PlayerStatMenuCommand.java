package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerStat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerStatMenuCommand implements SubCommand{
    private static final String NAME = "Statmenu";
    private static final String DESCRIPTION = "Opens the player's Stat menu.";
    private static final  String ERROR_COLOR = "&c";


    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String nameTemp = "debug";
        String lore1 = " ";
        String lore2 = " ";
        String lore3 = " ";
        String lore4 = " ";
        String lore5 = " ";
        String lore6 = " ";
        String lore7 = " ";
        String lore8 = " ";
        String lore9 = " ";
        String lore10 = " ";
        int loreInt1 = 0;
        int loreInt2 = 0;
        int loreInt3 = 0;
        int loreInt4 = 0;
        int loreInt5 = 0;
        int loreInt6 = 0;
        int loreInt7 = 0;
        int loreInt8 = 0;
        int loreInt9 = 0;
        int loreInt10 = 0;

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, 36, "Stat Menu");

        // Create Items to place in inventory
        ItemStack cubitsLead = new ItemStack(Material.CLOCK, 1);
        ItemMeta cubitsLead_meta = cubitsLead.getItemMeta();
        cubitsLead_meta.setDisplayName("Farming");
        cubitsLead_meta.setCustomModelData(10001);


        int farmingLevel = playerProfile.getPlayerLevel(PlayerStat.FARMING);

        double level = playerProfile.getStats().get(PlayerStat.FARMING);
        int currentLevel = (int) Math.floor(level);

        int totalLevel = currentLevel;
        int exp = currentLevel;
        int startingExp = 100;
        double multiplierExp = 0.5;

        int next_exp_needed_to_level_up = 100;
        int previous_exp_needed_to_level_up = 0;

        int getlevel = 1;
        int currentExpCeiling = startingExp;
        int currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        int progress = 0;
        double progress3 = next_exp_needed_to_level_up / 10;
        double progress4 = progress3;
        double progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        StringBuilder progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_GREEN);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        cubitsLead_meta.setLore(lore);
        cubitsLead.setItemMeta(cubitsLead_meta);





        ItemStack stats = new ItemStack(Material.CLOCK, 1);
        ItemMeta stats_meta = stats.getItemMeta();
        stats_meta.setDisplayName("Foraging");
        stats_meta.setCustomModelData(10002);
        stats.setItemMeta(stats_meta);

        int foragingLevel = playerProfile.getPlayerLevel(PlayerStat.FORAGING);

        level = playerProfile.getStats().get(PlayerStat.FORAGING);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.GREEN);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        stats_meta.setLore(lore);
        stats.setItemMeta(stats_meta);





        ItemStack bag = new ItemStack(Material.CLOCK, 1);
        ItemMeta bag_meta = bag.getItemMeta();
        bag_meta.setDisplayName("Adventuring");
        bag_meta.setCustomModelData(10003);
        bag.setItemMeta(bag_meta);

        int adventuringLevel = playerProfile.getPlayerLevel(PlayerStat.ADVENTURING);

        level = playerProfile.getStats().get(PlayerStat.ADVENTURING);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.RED);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.RED + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        bag_meta.setLore(lore);
        bag.setItemMeta(bag_meta);





        ItemStack collections = new ItemStack(Material.CLOCK, 1);
        ItemMeta collections_meta = collections.getItemMeta();
        collections_meta.setDisplayName("Mining");
        collections_meta.setCustomModelData(10004);
        collections.setItemMeta(collections_meta);

        int miningLevel = playerProfile.getPlayerLevel(PlayerStat.MINING);

        level = playerProfile.getStats().get(PlayerStat.MINING);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_BLUE);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.DARK_BLUE + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        collections_meta.setLore(lore);
        collections.setItemMeta(collections_meta);






        ItemStack quests = new ItemStack(Material.CLOCK, 1);
        ItemMeta quests_meta = quests.getItemMeta();
        quests_meta.setDisplayName("Fishing");
        quests_meta.setCustomModelData(10005);
        quests.setItemMeta(quests_meta);

        int fishingLevel = playerProfile.getPlayerLevel(PlayerStat.FISHING);

        level = playerProfile.getStats().get(PlayerStat.FISHING);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.BLUE);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        quests_meta.setLore(lore);
        quests.setItemMeta(quests_meta);





        ItemStack battlePass = new ItemStack(Material.CLOCK, 1);
        ItemMeta battlePass_meta = battlePass.getItemMeta();
        battlePass_meta.setDisplayName("Magic");
        battlePass_meta.setCustomModelData(10006);
        battlePass.setItemMeta(battlePass_meta);

        int magicLevel = playerProfile.getPlayerLevel(PlayerStat.MAGIC);

        level = playerProfile.getStats().get(PlayerStat.MAGIC);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_PURPLE);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        battlePass_meta.setLore(lore);
        battlePass.setItemMeta(battlePass_meta);






        ItemStack achievements = new ItemStack(Material.CLOCK, 1);
        ItemMeta achievements_meta = achievements.getItemMeta();
        achievements_meta.setDisplayName("Alchemy");
        achievements_meta.setCustomModelData(10007);
        achievements.setItemMeta(achievements_meta);

        int alchemyLevel = playerProfile.getPlayerLevel(PlayerStat.ALCHEMY);

        level = playerProfile.getStats().get(PlayerStat.ALCHEMY);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.LIGHT_PURPLE);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        achievements_meta.setLore(lore);
        achievements.setItemMeta(achievements_meta);





        ItemStack leaderboard = new ItemStack(Material.CLOCK, 1);
        ItemMeta leaderboard_meta = leaderboard.getItemMeta();
        leaderboard_meta.setDisplayName("Crafting");
        leaderboard_meta.setCustomModelData(10008);
        leaderboard.setItemMeta(leaderboard_meta);

        int craftingLevel = playerProfile.getPlayerLevel(PlayerStat.CRAFTING);

        level = playerProfile.getStats().get(PlayerStat.CRAFTING);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.YELLOW);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        leaderboard_meta.setLore(lore);
        leaderboard.setItemMeta(leaderboard_meta);




        ItemStack glossary = new ItemStack(Material.CLOCK, 1);
        ItemMeta glossary_meta = glossary.getItemMeta();
        glossary_meta.setDisplayName("Cooking");
        glossary_meta.setCustomModelData(10009);
        glossary.setItemMeta(glossary_meta);

        int cookingLevel = playerProfile.getPlayerLevel(PlayerStat.COOKING);

        level = playerProfile.getStats().get(PlayerStat.COOKING);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.GOLD);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        glossary_meta.setLore(lore);
        glossary.setItemMeta(glossary_meta);





        ItemStack options = new ItemStack(Material.CLOCK, 1);
        ItemMeta options_meta = options.getItemMeta();
        options_meta.setDisplayName("Slayer");
        options_meta.setCustomModelData(10010);
        options.setItemMeta(options_meta);

        int slayerLevel = playerProfile.getPlayerLevel(PlayerStat.SLAYER);

        level = playerProfile.getStats().get(PlayerStat.SLAYER);
        currentLevel = (int) Math.floor(level);

        totalLevel = currentLevel;
        exp = currentLevel;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        progress = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_RED);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        lore = new ArrayList<>();
        lore.add(ChatColor.DARK_RED + String.valueOf(currentLevel) + " " + progressBar + ChatColor.GRAY + " (" + totalLevel + ")");

        options_meta.setLore(lore);
        options.setItemMeta(options_meta);




        // Favor Icon is unused, replace if I want something at bottom-left
        ItemStack wallet = new ItemStack(Material.CLOCK, 1);
        ItemMeta wallet_meta = wallet.getItemMeta();
        wallet_meta.setDisplayName("Favor");
        wallet_meta.setCustomModelData(1010);
        wallet.setItemMeta(wallet_meta);





        ItemStack filling = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta filling_meta = filling.getItemMeta();
        filling_meta.setDisplayName(" ");
        filling.setItemMeta(filling_meta);

        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = back.getItemMeta();
        back_meta.setDisplayName("Back");
        back.setItemMeta(back_meta);

        ItemStack item5 = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta)item5.getItemMeta();
        skullMeta.setOwnerProfile(p.getPlayerProfile());
        nameTemp = p.getDisplayName();
        nameTemp = ChatColor.stripColor(nameTemp);
        skullMeta.setDisplayName(ChatColor.BLUE + nameTemp);
        loreInt1 = playerProfile.getMiniGameTokens().get(MiniGameToken.COINS);
        loreInt2 = playerProfile.getMiniGameTokens().get(MiniGameToken.GEMS);
        loreInt3 = playerProfile.getMiniGameTokens().get(MiniGameToken.SURVIVAL);
        loreInt4 = playerProfile.getMiniGameTokens().get(MiniGameToken.COMBAT);
        loreInt5 = playerProfile.getMiniGameTokens().get(MiniGameToken.FORAGING);
        loreInt6 = playerProfile.getMiniGameTokens().get(MiniGameToken.FISHING);
        loreInt7 = playerProfile.getMiniGameTokens().get(MiniGameToken.MYTHIC);
        loreInt8 = playerProfile.getMiniGameTokens().get(MiniGameToken.ESSENCE);
        skullMeta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Coins: " + ChatColor.WHITE + loreInt1, ChatColor.LIGHT_PURPLE + "Gems: " + ChatColor.WHITE + loreInt2, ChatColor.LIGHT_PURPLE + "Survival Tokens: " + ChatColor.WHITE +  loreInt3, ChatColor.LIGHT_PURPLE + "Combat Tokens: " + ChatColor.WHITE + loreInt4, ChatColor.LIGHT_PURPLE + "Foraging Tokens: " + ChatColor.WHITE + loreInt5, ChatColor.LIGHT_PURPLE + "Fishing Tokens: " + ChatColor.WHITE + loreInt6, ChatColor.LIGHT_PURPLE + "Mythic Tokens: " + ChatColor.WHITE + loreInt7, ChatColor.LIGHT_PURPLE + "Essence: " + ChatColor.WHITE + loreInt8));
        item5.setItemMeta(skullMeta);

        // ADD Currently Equipped Cubit too!

        ItemStack item10 = new ItemStack(Material.GRAY_DYE, 1);
        ItemMeta item10_meta = item10.getItemMeta();
        item10_meta.setDisplayName("---");
        item10.setItemMeta(item10_meta);



        // Loop to fill in remaining slots with Gray Stained Glass Panes
        for (int i = 0; i < 36; i++) {
            if(i < 9 || i > 27 || i % 9 == 0 || i % 9 == 8){
                gui.setItem(i, filling);
            }
        }

        // Set items into their proper slots
        gui.setItem(4, item5);
        gui.setItem(10, cubitsLead);
        gui.setItem(11, stats);
        gui.setItem(12, bag);
        gui.setItem(13, collections);
        gui.setItem(14, quests);
        gui.setItem(15, battlePass);
        gui.setItem(16, achievements);
        gui.setItem(21, leaderboard);
        gui.setItem(22, glossary);
        gui.setItem(23, options);
        //gui.setItem(27, wallet); // Currently FAVOR
        gui.setItem(31, back);
        //gui.setItem(35, item10); // Dummy --- Item

        //gui.addItem(item1, item2);
        // Open Inventory
        p.openInventory(gui);

    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

