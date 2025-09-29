package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CreateCubitHead;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class MenuCommand implements SubCommand{
    private static final String NAME = "Menu";
    private static final String DESCRIPTION = "Opens the player's Main Cubits Menu.";
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
        Inventory gui = Bukkit.createInventory(p, 36, "Player Menu");

        // Create Items to place in inventory
        ItemStack petItemHead;

        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();
        if(cubit == null){
            petItemHead = new ItemStack(Material.PAPER, 1);
            ItemMeta petItemHead_meta = petItemHead.getItemMeta();
            petItemHead_meta.setDisplayName("No Equipped Cubit");
            petItemHead.setItemMeta(petItemHead_meta);
        }else{
            petItemHead = new CreateCubitHead(plugin).NewCubitHead(p, cubit);
        }

        ItemStack stats = new ItemStack(Material.CLOCK, 1);
        ItemMeta stats_meta = stats.getItemMeta();
        stats_meta.setDisplayName("Stats");
        stats_meta.setCustomModelData(10002);
        stats.setItemMeta(stats_meta);

        ItemStack collections = new ItemStack(Material.CLOCK, 1);
        ItemMeta collections_meta = collections.getItemMeta();
        collections_meta.setDisplayName("Collections");
        collections_meta.setCustomModelData(10004);
        collections.setItemMeta(collections_meta);

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
        loreInt8 = playerProfile.getMiniGameTokens().get(MiniGameToken.SLAYER_TOKENS);
        loreInt9 = playerProfile.getMiniGameTokens().get(MiniGameToken.ESSENCE);
        skullMeta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "Coins: " + ChatColor.WHITE + loreInt1, ChatColor.LIGHT_PURPLE + "Gems: " + ChatColor.WHITE + loreInt2, ChatColor.LIGHT_PURPLE + "Survival Tokens: " + ChatColor.WHITE +  loreInt3, ChatColor.LIGHT_PURPLE + "Combat Tokens: " + ChatColor.WHITE + loreInt4, ChatColor.LIGHT_PURPLE + "Foraging Tokens: " + ChatColor.WHITE + loreInt5, ChatColor.LIGHT_PURPLE + "Fishing Tokens: " + ChatColor.WHITE + loreInt6, ChatColor.LIGHT_PURPLE + "Mythic Tokens: " + ChatColor.WHITE + loreInt7, ChatColor.LIGHT_PURPLE + "Slayer Tokens: " + ChatColor.WHITE + loreInt8 + "Essence: " + ChatColor.WHITE + loreInt9));
        item5.setItemMeta(skullMeta);

        // ADD Currently Equipped Cubit too!

        ItemStack cubitsLead = new ItemStack(Material.CLOCK, 1);
        ItemMeta cubitsLead_meta = cubitsLead.getItemMeta();
        cubitsLead_meta.setDisplayName("Cubits");
        cubitsLead_meta.setCustomModelData(10001);
        cubitsLead.setItemMeta(cubitsLead_meta);

        ItemStack quests = new ItemStack(Material.CLOCK, 1);
        ItemMeta quests_meta = quests.getItemMeta();
        quests_meta.setDisplayName("Quests");
        quests_meta.setCustomModelData(10005);
        quests.setItemMeta(quests_meta);

        ItemStack achievements = new ItemStack(Material.CLOCK, 1);
        ItemMeta achievements_meta = achievements.getItemMeta();
        achievements_meta.setDisplayName("Achievements");
        achievements_meta.setCustomModelData(10007);
        achievements.setItemMeta(achievements_meta);

        ItemStack bag = new ItemStack(Material.CLOCK, 1);
        ItemMeta bag_meta = bag.getItemMeta();
        bag_meta.setDisplayName("Bag");
        bag_meta.setCustomModelData(10003);
        bag.setItemMeta(bag_meta);

        ItemStack item10 = new ItemStack(Material.GRAY_DYE, 1);
        ItemMeta item10_meta = item10.getItemMeta();
        item10_meta.setDisplayName("---");
        item10.setItemMeta(item10_meta);

        ItemStack battlePass = new ItemStack(Material.CLOCK, 1);
        ItemMeta battlePass_meta = battlePass.getItemMeta();
        battlePass_meta.setDisplayName("???");
        battlePass_meta.setCustomModelData(10006);
        battlePass.setItemMeta(battlePass_meta);

        ItemStack leaderboard = new ItemStack(Material.CLOCK, 1);
        ItemMeta leaderboard_meta = leaderboard.getItemMeta();
        leaderboard_meta.setDisplayName("Leaderboards");
        leaderboard_meta.setCustomModelData(10008);
        leaderboard.setItemMeta(leaderboard_meta);

        ItemStack glossary = new ItemStack(Material.CLOCK, 1);
        ItemMeta glossary_meta = glossary.getItemMeta();
        glossary_meta.setDisplayName("Index");
        glossary_meta.setCustomModelData(10009);
        glossary.setItemMeta(glossary_meta);

        ItemStack options = new ItemStack(Material.CLOCK, 1);
        ItemMeta options_meta = options.getItemMeta();
        options_meta.setDisplayName("???");
        options_meta.setCustomModelData(10010);
        options.setItemMeta(options_meta);

        ItemStack wallet = new ItemStack(Material.CLOCK, 1);
        ItemMeta wallet_meta = wallet.getItemMeta();
        wallet_meta.setDisplayName("Wallet");
        wallet_meta.setCustomModelData(1010);
        wallet.setItemMeta(wallet_meta);

        // Loop to fill in remaining slots with Gray Stained Glass Panes
        for (int i = 0; i < 36; i++) {
            if(i < 9 || i > 27 || i % 9 == 0 || i % 9 == 8){
                gui.setItem(i, filling);
            }
        }

        // Set items into their proper slots
        gui.setItem(4, item5);
        gui.setItem(8, petItemHead);
        gui.setItem(11, cubitsLead);
        gui.setItem(12, stats);
        gui.setItem(13, bag);
        //gui.setItem(13, collections);
        gui.setItem(14, quests);
        //gui.setItem(15, battlePass);
        gui.setItem(15, achievements);
        gui.setItem(21, leaderboard);
        gui.setItem(22, glossary);
        gui.setItem(23, options);
        //gui.setItem(27, wallet);
        gui.setItem(31, back);
        //gui.setItem(35, item10); // Dummy --- Item

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
