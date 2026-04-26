package me.josh.cubits.menus;

import me.josh.cubits.Main;
import me.josh.cubits.menus.shopkeepers.CubitGui;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class AchievementMenu extends CubitGui {

    public static void openAchievementMenu(Main plugin, Player p) {
        // Set Variables
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        String INVENTORY_NAME = "Achievement Menu";
        int INVENTORY_SIZE = 27;
        int loreInt1 = 0;
        int loreInt2 = 0;
        ItemStack BACK_ICON;
        ItemStack QUEST1;
        ItemStack QUEST2;
        ItemStack QUEST3;
        ItemStack QUEST4;
        ItemStack QUEST5;
        ItemStack CLAIM;
        ItemStack CLAIMBAD;
        ItemStack INFO;

        // Check Achievement Tier
        int tier = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER);

        if(tier == 0){
            playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TIER, 1);
            tier = 1;
        }

        if(playerProfile.isAchievementLast()){
            if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) > plugin.achievementRankMax){
                playerProfile.setAchievementLast(false);
                //GIVE NEW GOALS HERE
            }
        }


        // Check Achievement Values
        if (playerProfile.getActiveCubitEntity().getCubit().getStats().get(playerProfile.getAch1Stat()) >= playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1)) {
            playerProfile.setAch1(true);
        }

        if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_2) >= playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2)){
            playerProfile.setAch2(true);
        }

        if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_3) >= playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3)){
            playerProfile.setAch3(true);
        }

        if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_4) >= playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4)){
            playerProfile.setAch4(true);
        }

        if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_5) >= playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5)){
            playerProfile.setAch5(true);
        }


        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, INVENTORY_SIZE, INVENTORY_NAME);

        // Create Inventory Items
        BACK_ICON = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = BACK_ICON.getItemMeta();
        back_meta.setDisplayName("Back");
        BACK_ICON.setItemMeta(back_meta);


        if(playerProfile.isAch1()){
            QUEST1 = new ItemStack(Material.PAPER, 1);
        }else{
            QUEST1 = new ItemStack(Material.PAPER, 1);
        }
        ItemMeta treats_meta = QUEST1.getItemMeta();
        treats_meta.setDisplayName("Task 1");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_1);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1);
        treats_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Equip a Cubit with " + playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1) + " " + playerProfile.getAch1Stat(), ChatColor.WHITE + "Pet must be equipped when claiming.")); // ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2
        //treats_meta.setCustomModelData(10101);
        QUEST1.setItemMeta(treats_meta);


        QUEST2 = new ItemStack(Material.PAPER, 1);
        ItemMeta dummyItems_meta = QUEST2.getItemMeta();
        dummyItems_meta.setDisplayName("Task 2");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_2);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2);
        dummyItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Collect " + playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2) + " " + playerProfile.getAch2ItemBase().getName(), ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        //dummyItems_meta.setCustomModelData(10102);
        QUEST2.setItemMeta(dummyItems_meta);

        QUEST3 = new ItemStack(Material.PAPER, 1);
        ItemMeta trinkets_meta = QUEST3.getItemMeta();
        trinkets_meta.setDisplayName("Task 3");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_3);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3);
        trinkets_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Slay " + playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3) + " " + playerProfile.getAch3Mob().getName(), ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        //trinkets_meta.setCustomModelData(10103);
        QUEST3.setItemMeta(trinkets_meta);


        QUEST4 = new ItemStack(Material.PAPER, 1);
        ItemMeta skinItems_meta = QUEST4.getItemMeta();
        skinItems_meta.setDisplayName("Task 4");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_4);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4);
        skinItems_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Mine " + playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4) + " " + playerProfile.getAch4Block(), ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        //skinItems_meta.setCustomModelData(10104);
        QUEST4.setItemMeta(skinItems_meta);


        QUEST5 = new ItemStack(Material.PAPER, 1);
        ItemMeta potions_meta = QUEST5.getItemMeta();
        potions_meta.setDisplayName("Task 5");
        loreInt1 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_AMOUNT_5);
        loreInt2 = playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5);
        potions_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Catch " + playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5) + " " + playerProfile.getAch5Fish().getName(), ChatColor.WHITE + "" + ChatColor.WHITE + loreInt1 + "/" + loreInt2));
        //potions_meta.setCustomModelData(10105);
        QUEST5.setItemMeta(potions_meta);


        CLAIM = new ItemStack(Material.STRUCTURE_VOID, 1);
        ItemMeta claim_meta = CLAIM.getItemMeta();
        claim_meta.setDisplayName("Claim Rewards!");
        claim_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + playerProfile.getAchievementRewards()));
        //claim_meta.setCustomModelData(10105);
        CLAIM.setItemMeta(claim_meta);

        CLAIMBAD = new ItemStack(Material.BARRIER, 1);
        ItemMeta claimbad_meta = CLAIMBAD.getItemMeta();
        claimbad_meta.setDisplayName("Claim Rewards!");
        //claimbad_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + playerProfile.getAchievementRewards()));
        claimbad_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Coming soon!"));
        //claimbad_meta.setCustomModelData(10105);
        CLAIMBAD.setItemMeta(claimbad_meta);

        INFO = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
        ItemMeta info_meta = INFO.getItemMeta();
        info_meta.setDisplayName("Info");
        info_meta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Complete all 5 tasks to rank up and earn rewards!"));
        INFO.setItemMeta(info_meta);



        // Create Items to place in inventory
        addBorderTrim(gui);
        gui.setItem(4, getPlayerHeadWithTokenStats(plugin, p));
        gui.setItem(11, QUEST1);
        gui.setItem(12, QUEST2);
        gui.setItem(13, QUEST3);
        gui.setItem(14, QUEST4);
        gui.setItem(15, QUEST5);
        gui.setItem(22, BACK_ICON);
        gui.setItem(26, INFO);

        if(playerProfile.isAch1() && playerProfile.isAch2() && playerProfile.isAch3() && playerProfile.isAch4() && playerProfile.isAch5()){
            gui.setItem(22, CLAIM);
        }

        if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == plugin.achievementRankMax){
            gui.setItem(22, CLAIMBAD);
            //GIVE NEW GOALS HERE
        }


        p.openInventory(gui);
    }

}
