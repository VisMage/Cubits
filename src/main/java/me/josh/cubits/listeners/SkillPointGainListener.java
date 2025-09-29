package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerStat;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;

import java.util.Random;


public class SkillPointGainListener implements Listener {

    private final Main plugin;
    public SkillPointGainListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (event.getCaught() instanceof Item) {
            playerProfile.addStats(PlayerStat.FISHING, 20);
        }

    }


    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        if (e.getEntity().getKiller() != null) {
            Entity killer = e.getEntity().getKiller();
            final Player player = e.getEntity().getKiller();
            PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

            //ENDER DRAGON PET DROP
            if (killer instanceof Player) {
                if (entity instanceof EnderDragon) {
                    playerProfile.addStats(PlayerStat.ADVENTURING, 500);
                }
            }

            if (killer instanceof Player) {
                if (entity instanceof Zombie || entity instanceof Skeleton || entity instanceof Spider || entity instanceof Creeper || entity instanceof CaveSpider || entity instanceof Husk || entity instanceof Stray || entity instanceof Bogged || entity instanceof ZombieVillager || entity instanceof Phantom || entity instanceof Enderman || entity instanceof Endermite || entity instanceof Silverfish || entity instanceof Slime || entity instanceof Blaze || entity instanceof WitherSkeleton || entity instanceof Piglin || entity instanceof PigZombie || entity instanceof Blaze || entity instanceof Breeze || entity instanceof Guardian || entity instanceof ElderGuardian || entity instanceof Wither || entity instanceof Shulker || entity instanceof Creaking) {
                    playerProfile.addStats(PlayerStat.ADVENTURING, 3);
                }
            }

            // End of Mobs Killed Event
        }
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Block block = (Block) e.getBlock();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (block.getType() == Material.STONE || block.getType() == Material.DEEPSLATE || block.getType() == Material.DIORITE || block.getType() == Material.GRANITE || block.getType() == Material.ANDESITE || block.getType() == Material.CALCITE || block.getType() == Material.TUFF || block.getType() == Material.COBBLESTONE || block.getType() == Material.MOSSY_COBBLESTONE || block.getType() == Material.BLACKSTONE || block.getType() == Material.NETHERRACK || block.getType() == Material.DIORITE || block.getType() == Material.SANDSTONE || block.getType() == Material.RED_SANDSTONE || block.getType() == Material.END_STONE || block.getType() == Material.GRAVEL) {
            playerProfile.addStats(PlayerStat.MINING, 1);
        }

        if (block.getType() == Material.DEAD_BUSH && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getPlayer().getInventory().getItemInMainHand().getType() != Material.SHEARS) {
            playerProfile.addStats(PlayerStat.FORAGING, 30);
        }

        if (block.getType() == Material.DIAMOND_ORE || block.getType() == Material.DEEPSLATE_DIAMOND_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 200);
        }

        if (block.getType() == Material.EMERALD_ORE || block.getType() == Material.DEEPSLATE_EMERALD_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType() == Material.COAL_ORE || block.getType() == Material.DEEPSLATE_COAL_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType() == Material.COPPER_ORE || block.getType() == Material.DEEPSLATE_COPPER_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType() == Material.IRON_ORE || block.getType() == Material.DEEPSLATE_IRON_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType() == Material.GOLD_ORE || block.getType() == Material.DEEPSLATE_GOLD_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType() == Material.LAPIS_ORE || block.getType() == Material.DEEPSLATE_LAPIS_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType() == Material.REDSTONE_ORE || block.getType() == Material.DEEPSLATE_REDSTONE_ORE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            playerProfile.addStats(PlayerStat.MINING, 300);
        }

        if (block.getType().toString().contains("ORE") && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            int miningLevelBoost = playerProfile.getPlayerLevel(PlayerStat.MINING);
            if(miningLevelBoost > 50) {
                miningLevelBoost = 50;
            }
            if (chance <= (10 + miningLevelBoost)/10000f) { // 1/1000 Base odds, LV.30 halves it to 1/250
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                //SoundUtil.PlaySoundAll(Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                int playerMiningLevel = playerProfile.getPlayerLevel(PlayerStat.MINING);
                playerProfile.addStats(PlayerStat.MINING, playerMiningLevel * 100);
                player.sendMessage("Your pickaxe lets out a roar, granting a " + (playerMiningLevel * 100) + " mining EXP boost!" );
            }
        }

        if (block.getType().toString().contains("LOG")) {
            playerProfile.addStats(PlayerStat.FORAGING, 10);
        }

        if (block.getType() == Material.OAK_LEAVES || block.getType() == Material.SPRUCE_LEAVES || block.getType() == Material.BIRCH_LEAVES || block.getType() == Material.ACACIA_LEAVES || block.getType() == Material.DARK_OAK_LEAVES || block.getType() == Material.MANGROVE_LEAVES || block.getType() == Material.CHERRY_LEAVES || block.getType() == Material.AZALEA_LEAVES || block.getType() == Material.FLOWERING_AZALEA_LEAVES && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && !(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.SHEARS)) {
            playerProfile.addStats(PlayerStat.FORAGING, 3);
        }


        if (block.getType() == Material.BEETROOTS && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            org.bukkit.block.data.Ageable age = (org.bukkit.block.data.Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                playerProfile.addStats(PlayerStat.FARMING, 8);
            }
        }


        if (block.getType() == Material.CARROTS && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            org.bukkit.block.data.Ageable age = (org.bukkit.block.data.Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                playerProfile.addStats(PlayerStat.FARMING, 6);
            }
        }


        if (block.getType() == Material.WHEAT && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            org.bukkit.block.data.Ageable age = (org.bukkit.block.data.Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                playerProfile.addStats(PlayerStat.FARMING, 6);
            }
        }


        if (block.getType() == Material.POTATOES && block.getState().getData() instanceof Crops) {

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.TAIGA)) {

                BlockData wheatData = block.getBlockData();
                org.bukkit.block.data.Ageable age = (org.bukkit.block.data.Ageable) wheatData;
                if(age.getAge() == age.getMaximumAge()){
                    playerProfile.addStats(PlayerStat.FARMING, 6);
                }
            }
        }


        if (block.getType() == Material.COCOA && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            org.bukkit.block.data.Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                playerProfile.addStats(PlayerStat.FARMING, 18);
            }
        }


        // End of Block Break Event
    }


    @EventHandler
    public void PlayerItemConsumeEvent(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (item.getType() == Material.COOKIE) {
            playerProfile.addStats(PlayerStat.COOKING, 4);
            //System.out.println(playerProfile.getStats().get(PlayerStat.COOKING));
        }

        // End of Item Consumed Events
    }


    @EventHandler
    public void onHarvest(PlayerHarvestBlockEvent e) {
        Player player = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (e.getHarvestedBlock().getType().equals(Material.SWEET_BERRY_BUSH)) {
            playerProfile.addStats(PlayerStat.FORAGING, 4);
        }

        if (e.getHarvestedBlock().getType().equals(Material.CAVE_VINES_PLANT)) {
            playerProfile.addStats(PlayerStat.FORAGING, 4);
        }


        //END of Harvest Block Events
    }


    @EventHandler
    public void onStrip(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("AXE")) {

        }


    }


    @EventHandler
    public void onBlockClick(FurnaceExtractEvent event){
        Player player = event.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        int amount = event.getItemAmount();

        if(event.getItemType() == Material.BAKED_POTATO){
            for(int i = 0; i <= amount; i++) {
                playerProfile.addStats(PlayerStat.COOKING, 6);
                }
            }

        if(event.getItemType() == Material.COOKED_BEEF || event.getItemType() == Material.COOKED_PORKCHOP || event.getItemType() == Material.COOKED_MUTTON){
            for(int i = 0; i <= amount; i++) {
                playerProfile.addStats(PlayerStat.COOKING, 12);
            }
        }

        if(event.getItemType() == Material.COOKED_CHICKEN){
            for(int i = 0; i <= amount; i++) {
                playerProfile.addStats(PlayerStat.COOKING, 6);
            }
        }

        if(event.getItemType() == Material.COOKED_RABBIT){
            for(int i = 0; i <= amount; i++) {
                playerProfile.addStats(PlayerStat.COOKING, 30);
            }
        }

        //END OF FURNACE EVENTS
    }






    //THE END

}
