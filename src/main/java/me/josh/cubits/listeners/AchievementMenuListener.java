package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.commands.MenuCommand;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ObtainTreat;
import me.josh.cubits.menus.AchievementMenu;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AchievementMenuListener  implements Listener {
    private final Main plugin;

    public AchievementMenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Achievement Menu")) return;
        if (e.getCurrentItem() == null) return;

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        int customModelDataValue;

        //Fix error?
        if (e.getCurrentItem() == null) {
            return;
        }

        // Check if clicked item has CustomModelData. If it does, saves it to int. If not, int set to 0.
        if (e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasCustomModelData()) {
            customModelDataValue = e.getCurrentItem().getItemMeta().getCustomModelData();
        } else {
            customModelDataValue = 0;
        }

        // Check for individual item types, CustomModelData, or Item Name

        if (e.getCurrentItem().getType().equals(Material.STRUCTURE_VOID)) {
            //Add achievement claiming
            //If all are claimed, give next tier
            SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);

            if(playerProfile.isAch1() && playerProfile.isAch2() && playerProfile.isAch3() && playerProfile.isAch4() && playerProfile.isAch5()){
                playerProfile.setAch1(false);
                playerProfile.setAch2(false);
                playerProfile.setAch3(false);
                playerProfile.setAch4(false);
                playerProfile.setAch5(false);

                playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_AMOUNT_1, 0);
                playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_AMOUNT_2, 0);
                playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_AMOUNT_3, 0);
                playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_AMOUNT_4, 0);
                playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_AMOUNT_5, 0);
                playerProfile.addPlayerVariables(PlayerVariables.ACHIEVEMENT_TIER, 1);

                if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == 1){
                    SoundUtil.PlaySoundAll(Sound.ENTITY_VILLAGER_HURT, 1, 1);
                }

                if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == 2){
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.SAPPLEBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.SAPPLEBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.SAPPLEBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.SAPPLEBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.SAPPLEBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    playerProfile.addMiniGameTokens(MiniGameToken.COINS, 100);
                    playerProfile.setAchievementRewards("200 Coins, 5 Big Pretzels");

                    playerProfile.setAch1Stat(CubitStat.POWER);
                    playerProfile.setAch2ItemBase(ItemBase.SAPPLEBERRY);
                    playerProfile.setAch3Mob(EntityType.SKELETON);
                    playerProfile.setAch4Block(Material.COPPER_ORE);
                    playerProfile.setAch4BlockAlt(Material.DEEPSLATE_COPPER_ORE);
                    playerProfile.setAch5Fish(ItemBase.FISH_SUNFISH);

                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1, 1500);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2, 35);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3, 100);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4, 100);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5, 15);
                }

                if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == 3){
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.PRETZEL);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.PRETZEL);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.PRETZEL);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.PRETZEL);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.PRETZEL);
                    playerProfile.addMiniGameTokens(MiniGameToken.COINS, 200);
                    playerProfile.setAchievementRewards("300 Coins, 5 Wyndberries, 3 Mossy Keys");

                    playerProfile.setAch1Stat(CubitStat.RUN);
                    playerProfile.setAch2ItemBase(ItemBase.COBBLE_CRUNCHIES);
                    playerProfile.setAch3Mob(EntityType.WITCH);
                    playerProfile.setAch4Block(Material.CALCITE);
                    playerProfile.setAch4BlockAlt(Material.BEDROCK);
                    playerProfile.setAch5Fish(ItemBase.FISH_MOONFISH);

                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1, 2000);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2, 30);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3, 30);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4, 100);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5, 15);
                }

                if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == 4){
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.WYNDBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.WYNDBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.WYNDBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.WYNDBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.WYNDBERRY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.KEY_MOSSY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.KEY_MOSSY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.KEY_MOSSY);
                    playerProfile.addMiniGameTokens(MiniGameToken.COINS, 300);
                    playerProfile.setAchievementRewards("400 Coins, 10 Fishy Crackers, 3 Mossy Keys");

                    playerProfile.setAch1Stat(CubitStat.SWIM);
                    playerProfile.setAch2ItemBase(ItemBase.SNOWTATO);
                    playerProfile.setAch3Mob(EntityType.STRAY);
                    playerProfile.setAch4Block(Material.IRON_ORE);
                    playerProfile.setAch4BlockAlt(Material.DEEPSLATE_IRON_ORE);
                    playerProfile.setAch5Fish(ItemBase.FISH_CHUB);

                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1, 2250);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2, 40);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3, 50);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4, 100);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5, 15);
                }

                if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == 5){
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.FISHY_CRACKER);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.KEY_MOSSY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.KEY_MOSSY);
                    new ObtainTreat(plugin).GiveTreat(p, ItemBase.KEY_MOSSY);
                    playerProfile.addMiniGameTokens(MiniGameToken.COINS, 400);
                    playerProfile.setAchievementRewards("500 Coins, 10 Dustberries, 3 Dusty Keys");

                    playerProfile.setAch1Stat(CubitStat.FLY);
                    playerProfile.setAch2ItemBase(ItemBase.DUSTBERRY);
                    playerProfile.setAch3Mob(EntityType.HUSK);
                    playerProfile.setAch4Block(Material.IRON_ORE);
                    playerProfile.setAch4BlockAlt(Material.DEEPSLATE_IRON_ORE);
                    playerProfile.setAch5Fish(ItemBase.FISH_SUNFISH);

                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_1, 2500);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_2, 40);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_3, 75);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_4, 150);
                    playerProfile.setPlayerVariable(PlayerVariables.ACHIEVEMENT_TARGET_AMOUNT_5, 25);
                }

                if(playerProfile.getPlayerVariables().get(PlayerVariables.ACHIEVEMENT_TIER) == plugin.achievementRankMax){
                    //playerProfile.setAchievementLast(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.ITALIC + "Current max achievement rank reached!");
                    p.sendMessage(ChatColor.ITALIC + "More ranks coming soon!");
                }

                AchievementMenu.openAchievementMenu(plugin, p);

            }

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            new MenuCommand().executeCommand(plugin, p, new String[]{"0"});
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
        }


    }



}
