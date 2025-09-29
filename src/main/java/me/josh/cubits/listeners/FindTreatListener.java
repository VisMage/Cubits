package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ObtainTreat;
import org.bukkit.*;
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
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;

import java.util.Random;

public class FindTreatListener implements Listener {

    private final Main plugin;

    public FindTreatListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();

        if (event.getCaught() instanceof Item) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/15f) { // chance of 1/15
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISHY_CRACKER);
            } else {
            }
        }

        if (event.getCaught() instanceof Item) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/100f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.GOLDEN_FISHY_CRACKER);
            } else {
            }
        }


//        if (event.getCaught() instanceof Item) {
//            Random r = new Random();
//            float chance = r.nextFloat();
//            Item item = (Item) event.getCaught();
//
//            if (item.getItemStack().getType() == Material.ENCHANTED_BOOK || item.getItemStack().getType() == Material.NAME_TAG || item.getItemStack().getType() == Material.FISHING_ROD || item.getItemStack().getType() == Material.NAUTILUS_SHELL || item.getItemStack().getType() == Material.BOW || item.getItemStack().getType() == Material.SADDLE) {
//                if (chance <= 1/30f) {
//                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Item drop! Found a Driftwood Charm!");
//                    PlayerProfile playerProfile = plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId());
//                    playerProfile.addItem(ItemBase.FISHY_CRACKER, 1);
//                    SoundUtil.PlaySoundAll(Sound.BLOCK_BEEHIVE_ENTER, 1, 1);
//                } else {
//                }
//            }
//        }


        //END OF FISHING
    }


    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        if (e.getEntity().getKiller() != null) {
            Entity killer = e.getEntity().getKiller();
            final Player player = e.getEntity().getKiller();

            //ENDER DRAGON PET DROP
            if (killer instanceof Player) {
                if (entity instanceof EnderDragon) {
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/3f) { // 1 in 3
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.DRAGONFRUIT);
                    } else {
                    }

                }
            }


            if (killer instanceof Player) {
                if (entity instanceof Zombie) {
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/1000000f) { // chance of 1/1,000,000
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.DRAGONFRUIT);
                    } else {
                    }


                }
            }


            // End of Mobs Killed Event
        }
    }


    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        LivingEntity player = event.getBreeder();
        LivingEntity animal = event.getFather();
        Player player2 = (Player) player;
        if(player2 == null) {return;}

        Random rANY = new Random();
        float chanceANY = rANY.nextFloat();
        if (chanceANY <= 1/50f) {
            new ObtainTreat(plugin).GiveTreat(player2, ItemBase.SUKISUKI_FRUIT);
        } else {
        }

        if (animal instanceof Cow){
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/35f) {
                new ObtainTreat(plugin).GiveTreat(player2, ItemBase.CHOCOLATE_MILK);
            }else {
            }

        }


        // End of Mob Breed Event
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Block block = (Block) e.getBlock();

        if (block.getType() == Material.STONE || block.getType() == Material.DEEPSLATE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/1000f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.COBBLE_CRUNCHIES);
            } else {
            }
        }


        if (block.getType() == Material.DIRT || block.getType() == Material.COARSE_DIRT || block.getType() == Material.GRASS_BLOCK || block.getType() == Material.PODZOL || block.getType() == Material.MYCELIUM || block.getType() == Material.ROOTED_DIRT) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (player.getWorld().hasStorm()) {
                if (chance <= 1/250f) { // chance of 1/250
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.MULCHBERRY);
                } else {
                }
            }
        }


        if (block.getType() == Material.CHERRY_LEAVES && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getPlayer().getInventory().getItemInMainHand().getType() != Material.SHEARS) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/250f) { // chance of 1/250
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.DOUBLE_CHERRIES);
            } else {
            }
        }


        if (block.getType() == Material.DEAD_BUSH && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getPlayer().getInventory().getItemInMainHand().getType() != Material.SHEARS) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.DUSTBERRY);
            } else {
            }

        }


        if (block.getType() == Material.GRASS_BLOCK || block.getType() == Material.TALL_GRASS || block.getType() == Material.FERN || block.getType() == Material.LARGE_FERN && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getPlayer().getInventory().getItemInMainHand().getType() != Material.SHEARS) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.MEADOW)) {
                if (chance <= 1/75f) { // chance of 1/75
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.WYNDBERRY);
                } else {
                }
            }
        }



        //if (block.getType().toString().contains("ORE") && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
        if (block.getType().toString().contains("LOG")) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/100f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.BRAMBLE_FRUIT);
            } else {
            }

            Random r2 = new Random();
            float chance2 = r2.nextFloat();
            if (chance <= 1/1000f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.GOLDEN_BRAMBLE_FRUIT);
            } else {
            }

        }


        if (block.getType() == Material.OAK_LEAVES || block.getType() == Material.SPRUCE_LEAVES || block.getType() == Material.BIRCH_LEAVES || block.getType() == Material.ACACIA_LEAVES || block.getType() == Material.DARK_OAK_LEAVES || block.getType() == Material.MANGROVE_LEAVES || block.getType() == Material.CHERRY_LEAVES || block.getType() == Material.AZALEA_LEAVES || block.getType() == Material.FLOWERING_AZALEA_LEAVES && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && !(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.SHEARS)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/2000f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.BRAMBLE_FRUIT);
            } else {
            }
        }


        if (block.getType() == Material.BEETROOTS && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/64f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.HEARTY_TURNIP);
                } else {
                }

                Random r2 = new Random();
                float chance2 = r2.nextFloat();
                if (chance <= 1/360f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.GOLDEN_HEARTY_TURNIP);
                } else {
                }

            }
        }


        if (block.getType() == Material.CARROTS && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 199/200f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.CURACURACARROT);
                } else {
                }
            }
        }


        if (block.getType() == Material.WHEAT && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/200f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.WHEAT);
                } else {
                }
            }
        }


        if (block.getType() == Material.POTATOES && block.getState().getData() instanceof Crops) {

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.TAIGA)) {

            BlockData wheatData = block.getBlockData();
            Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/200f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.SNOWTATO);
                } else {
                }
            }
            }
        }


        if (block.getType() == Material.POTATOES || block.getType() == Material.COCOA && block.getState().getData() instanceof Crops) {

            BlockData wheatData = block.getBlockData();
            Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/300f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.STRAWBERRY);
                } else {
                }
            }
        }





        // End of Block Break Event
    }


    @EventHandler
    public void PlayerItemConsumeEvent(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();

//        if (item.getType() == Material.COOKIE) {
//
//            Random r = new Random();
//            float chance = r.nextFloat();
//            if (chance <= 0.0010f) { // chance of 1/1000
//                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found a Cookie Spirit!");
//                PlayerProfile playerProfile = plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId());
//                playerProfile.addItem(ItemBase.FISHY_CRACKER, 1);
//
//            } else {
//            }
//
//
//        }


        // End of Item Consumed Events
    }


    @EventHandler
    public void onHarvest(PlayerHarvestBlockEvent e) {
        Player player = e.getPlayer();

        if (e.getHarvestedBlock().getType().equals(Material.SWEET_BERRY_BUSH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/30f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.SAPPLEBERRY);
            } else {
            }

        }


        if (e.getHarvestedBlock().getType().equals(Material.CAVE_VINES_PLANT)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/30f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.STRAWBERRY);
            } else {
            }

        }


        //END of Harvest Block Events
    }


    @EventHandler
    public void onStrip(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("AXE")) {
            Block clickedBlock = event.getClickedBlock();
            Material woodtype = clickedBlock.getType();
            if (woodtype == Material.SPRUCE_LOG) {
                //player.sendMessage(ChatColor.GRAY + "Item drop! SPRUCE TEST");
            }
        }


    }






    @EventHandler
    public void onBlockClick(FurnaceExtractEvent event){
        Player player = event.getPlayer();
        int amount = event.getItemAmount();

        if(event.getItemType() == Material.BAKED_POTATO){
            for(int i = 0; i <= amount; i++) {

                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/50f) {
                    new ObtainTreat(plugin).GiveTreat(player, ItemBase.CINNAMONROLL);
                }
            }
        }

        // Because of the loop, Item is given in the loop
        //END OF FURNACE EVENTS
    }






    @EventHandler
    public void onPlayerBucketFill(PlayerBucketFillEvent e) {

        Player player = e.getPlayer();

//        if (e.getItemStack().getType() == Material.MILK_BUCKET) {
//            //e.setItemStack(new ItemStack(Material.BUCKET));
//            //e.getPlayer().updateInventory();
//            Random r = new Random();
//            float chance = r.nextFloat();
//            if (chance <= 0.0066f) { // chance of 1/150
//                player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Item drop! Found Chocolate Milk!");
//                PlayerProfile playerProfile = plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId());
//                playerProfile.addItem(ItemBase.FISHY_CRACKER, 1);
//
//            } else {
//            }
//
//        }


        //End of fill bucket event
    }




    //THE END
}
