package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitdata.CubitStat;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;

import java.util.Random;
import java.util.UUID;


public class FindCubitListener implements Listener {
    private final Main plugin;

    public FindCubitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();


        //if(player.getWorld().getName().equalsIgnoreCase("hub")){

        if(event.getCaught() instanceof Item){
            //player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "You examine your catch...");
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/750f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER);
            }else {
            }
        }


        if(event.getCaught() instanceof Item){
            //player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "You examine your catch...");
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_ANGRY);
            }else {
            }
        }



        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Location loc = new Location(player.getWorld(), 3800, 64, 1000);

            if(player.getLocation().distance(loc) < 200) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_RADIOACTIVE);
            }else {
            }
            }
        }



        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Location loc = new Location(player.getWorld(), 3835, 64, 1350);

            if(player.getLocation().distance(loc) < 70) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER_GRASS);
                }else {
                }
            }
        }




        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Location loc = new Location(player.getWorld(), 4600, 100, 2520);

            if(player.getLocation().distance(loc) < 150) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PENGIN);
                }else {
                }
            }
        }




        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.DESERT)) {

                long b = player.getWorld().getTime();
                if (b < 13000 ) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_SAND);
                }else {
                }
            }
            }
        }



        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.DEEP_DARK)) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.AXIE_SCULK);
                }else {
                }
            }
        }


        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.SWAMP) ||
                    player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO);
                }else {
                }
                Random r2 = new Random();
                float chance2 = r2.nextFloat();
                if (chance2 <= 1/1000f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_GOLDEN);
                }else {
                }
            }
        }


        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.LUSH_CAVES)) {

                if (chance <= 1/500f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOOP_GLOW);
                }else {
                }
            }
        }


        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.TAIGA) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.ICE_SPIKES) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.FROZEN_OCEAN) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.FROZEN_PEAKS) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.FROZEN_RIVER) || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.DEEP_FROZEN_OCEAN)) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER_FROZEN);
                }else {
                }
            }
        }



        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {

                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CRABBY);
                }else {
                }
            }
        }



        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Item item = (Item) event.getCaught();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.WARM_OCEAN)) {


                if (item.getItemStack().getType() == Material.TROPICAL_FISH) {
                    if (chance <= 1/350f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_KOI);
                    }else {
                    }
                }
            }
        }


        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Item item = (Item) event.getCaught();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                    .getBlockZ()).equals(Biome.WARM_OCEAN)) {


                if (item.getItemStack().getType() == Material.TROPICAL_FISH) {
                    if (chance <= 0.01f) { // chance of 1/100
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_CLOWN);
                    }else {
                    }
                }
            }
        }





        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Item item = (Item) event.getCaught();
            if (item.getItemStack().getType() == Material.SALMON) {
                if (chance <= 1/3000f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_IRIDIUM);
                }else {
                }

            }
        }



        PlayerProfile playerProfile2 = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        if (playerProfile2.getActiveCubitEntity() == null || playerProfile2.getActiveCubitEntity().getCubit() != null) {
            int swimStat = playerProfile2.getActiveCubitEntity().getCubit().getStats().get(CubitStat.SWIM);


            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                Item item = (Item) event.getCaught();

                if (item.getItemStack().getType() == Material.PUFFERFISH) {

                    if (swimStat >= 10000) {
                        if (chance <= 1/250f) {
                            plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER_QWILL);
                        }else {
                        }

                    }

                }
            }


            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                Item item = (Item) event.getCaught();

                if (item.getItemStack().getType() == Material.COD) {

                    //Check if player has a cubit equipped
                    if (swimStat >= 10000) {
                        if (chance <= 1/2000f) { //EMPTY
                            plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER);
                        }else {
                        }

                    }


                }
            }



            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                Item item = (Item) event.getCaught();

                if (item.getItemStack().getType() == Material.COD) {

                    if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                            .getBlockZ()).equals(Biome.WARM_OCEAN)) {

                        long b = player.getWorld().getTime();
                        if (b > 13000 ) {

                            if (playerProfile2.getActiveCubitEntity().getCubit().getCubitBase() == CubitBase.BLOOP_GLOW) {
                                if (chance <= 1/1000f) {
                                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.JELLY_GLOW);
                                }else {
                                }
                            }
                        }
                    }
                }
            }



            // END OF CHECKS that require a Cubit to be equipped
        }



        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Item item = (Item) event.getCaught();
            if (player.getWorld().hasStorm()) {
            if (item.getItemStack().getType() == Material.COD) {
                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FLOPPER_RAINSKIPPER);
                }else {
                }

            }
            }
        }




        if(event.getCaught() instanceof Item){
            Random r = new Random();
            float chance = r.nextFloat();
            Item item = (Item) event.getCaught();
            if (item.getItemStack().getType() == Material.PUFFERFISH) {
                if (chance <= 1/300f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER);
                }else {
                }
                Random r2 = new Random();
                float chance2 = r2.nextFloat();
                if (chance2 <= 1/1200f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER_MC);
                }else {
                }





            }
        }


        //} // World Name Check



    }
    //END OF FISHING





    @EventHandler
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        if (e.getEntity().getKiller() != null) {
            Entity killer = e.getEntity().getKiller();
            final Player player = e.getEntity().getKiller();

//            if (killer instanceof Player){
//                if (entity instanceof Skeleton){
//                    Random r = new Random();
//                    float chance = r.nextFloat();
//                    if (chance <= 0.0005f) { // 1 in 2000
//                        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found a Skull Sage!");
//                        givecubitname = "skullsage";
//                    }else {
//                    }
//
//                    Random r2 = new Random();
//                    float chance2 = r2.nextFloat();
//                    if (chance2 <= 0.00025f) { // 1 in 4000
//                        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found an Arcane Skull Sage!");
//                        givecubitname = "skullsagearcane";
//                    }else {
//                    }
//
//                }
//            }


            if (killer instanceof Player){
                if (entity instanceof Slime){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/2000f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.GOOBER);
                    }else {
                    }

                    Random r2 = new Random();
                    float chance2 = r2.nextFloat();
                    if (chance2 <= 1/4000f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.GOOBER_GARDEN);
                    }else {
                    }

                    Random r3 = new Random();
                    float chance3 = r3.nextFloat();
                    if (chance3 <= 1/4000f) { //EMPTY
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.GOOBER);
                    }else {
                    }

                }
            }


            if (killer instanceof Player){
                if (entity instanceof Creeper){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/2000f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CREEPER_BABY);
                    }else {
                    }

                }
            }


            if (killer instanceof Player){
                if (entity instanceof Guardian){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/1f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER_GUARDIAN);
                    }else {
                    }

                }
            }


            if (killer instanceof Player){
                if (entity instanceof ElderGuardian){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/100f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFER_ELDER);
                    }else {
                    }

                }
            }


            if (killer instanceof Player){
                if (entity instanceof Spider){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/2000f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_SPIDER);
                    }else {
                    }

                }
            }


            if (killer instanceof Player){
                if (entity instanceof Phantom){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/200f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_PHANTOM);
                    }else {
                    }

                }
            }



            if (killer instanceof Player){
                if (entity instanceof Bee){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    long b = player.getWorld().getTime();
                    if (b > 13000 ) {
                        if (chance <= 1/333f) {
                            plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_ZOMBEE);
                        }else {
                        }
                    }

                }
            }







            if (killer instanceof Player){
                if (entity instanceof Squid){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/1000f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOOP);
                    }else {
                    }


                }
            }


            if (killer instanceof Player){
                if (entity instanceof Warden){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/20f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.WARDEN);
                    }else {
                    }


                }
            }





            if (killer instanceof Player){
                if (entity instanceof Zombie || entity instanceof Skeleton || entity instanceof Spider || entity instanceof Creeper || entity instanceof Enderman || entity instanceof Witch || entity instanceof Phantom || entity instanceof Piglin || entity instanceof Hoglin){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/1000000f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PHOENIX);
                        //SoundUtil.PlaySoundAll(Sound.ENTITY_ENDER_DRAGON_DEATH, 1, 1);

                    }else {
                    }

                }
            }


            if (killer instanceof Player){
                if (entity instanceof Zombie || entity instanceof Skeleton || entity instanceof Spider || entity instanceof Creeper || entity instanceof Enderman || entity instanceof Witch || entity instanceof Phantom || entity instanceof Piglin || entity instanceof Hoglin){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.SWAMP) ||
                            player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {
                        if (chance <= 1/2000f) {
                            plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_CRIMSON);
                        }else {
                        }
                        Random r2 = new Random();
                        float chance2 = r2.nextFloat();
                        if (chance2 <= 1/10000f) {
                            plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_CRIMSON);
                        }else {
                        }

                    }

                }
            }



            //ENDER DRAGON PET DROP
            if (killer instanceof Player){
                if (entity instanceof EnderDragon){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/10f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_PLUM);
                    }else {
                    }
                    Random r2 = new Random();
                    float chance2 = r2.nextFloat();
                    if (chance2 <= 1/20f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_CYAN);
                    }else {}
                    Random r3 = new Random();
                    float chance3 = r3.nextFloat();
                    if (chance3 <= 1/30f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_PEACH);
                    }else {}
                    Random r4 = new Random();
                    float chance4 = r4.nextFloat();
                    if (chance4 <= 1/40f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_LEMON);
                    }else {}
                    Random r5 = new Random();
                    float chance5 = r5.nextFloat();
                    if (chance5 <= 1/60f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_CITRUS);
                    }else {}
                    Random r6 = new Random();
                    float chance6 = r6.nextFloat();
                    if (chance6 <= 1/80f) {
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_LIME);
                    }else {}
                    Random r7 = new Random();
                    float chance7 = r7.nextFloat();
                    if (chance7 <= 1/100f) { // 1 in 100
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.DRAKE_WHITE);
                    }else {}
                }
            }

            // End of Mobs Killed Event
        }
    }







    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        LivingEntity player1 = event.getBreeder();
        LivingEntity animal = event.getFather();
        UUID uuid = player1.getUniqueId();
        Player player = Bukkit.getPlayer(uuid);



        if (animal instanceof Sheep){
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/500f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.SHEEP);
            }else {
            }
            Random r2 = new Random();
            float chance2 = r2.nextFloat();
            if (chance2 <= 1/2000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.SHEEP_SILLY);
            }else {
            }

        }

        if (animal instanceof Frog){
            Random r = new Random();
            float chance = r.nextFloat();

            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.SWAMP) ||
                    player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {
                if (chance <= 1/300f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_TEMPERATE);
            }else {
            }
            Random r2 = new Random();
            float chance2 = r2.nextFloat();
            if (chance2 <= 1/1000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_GOLDEN);
            }else {
            }

            }
        }


        if (animal instanceof Axolotl){
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/100f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.AXIE);
            }else {
            }
            Random r2 = new Random();
            float chance2 = r2.nextFloat();
            if (chance2 <= 1/1000f) { //EMPTY
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.AXIE);
            }else {
            }

        }



        if (animal instanceof Bee){
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/1000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE);
            }else {
            }
            Random r2 = new Random();
            float chance2 = r2.nextFloat();
            if (chance2 <= 1/4000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_BUSINESS);
            }else {
            }

        }


        if (animal instanceof Bee){
            if(player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.CHERRY_GROVE)) {
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1 / 800f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_SAKURA);
                }
            }
        }


        if (animal instanceof Bee && ((Player) player).getInventory().getItemInMainHand().getType() == Material.PINK_PETALS || ((Player) player).getInventory().getItemInOffHand().getType() == Material.PINK_PETALS) {
            Random r = new Random();
            float chance = r.nextFloat();

            if(((Player) player).getDisplayName().contains("Hokobble")) {
                if (chance <= 1/300f) { // chance of 1/300 (Slightly boosted)
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_LGBEE);
                } }else {

                if(((Player) player).getDisplayName().contains("TheDrChub")) {
                    if (chance <= 1/1000000f) { // chance of 1/1,000,000
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_LGBEE);
                    } }else {

                    if (chance <= 1/500f) { // chance of 1/500
                        plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_LGBEE);
                    }


                }

            }

        }


        if (animal instanceof Bee && ((Player) player).getInventory().getItemInMainHand().getType() == Material.BLUE_ORCHID || ((Player) player).getInventory().getItemInOffHand().getType() == Material.BLUE_ORCHID) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/1000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.CUBEE_PRIDE);
            }
        }




        if (animal instanceof Turtle){
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/500f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.TURTLE);
            }else {
            }

        }

        // End of Mob Breed Event
    }





    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Block block = (Block) e.getBlock();

        if (block.getType() == Material.STONE || block.getType() == Material.DEEPSLATE || block.getType() == Material.DIORITE || block.getType() == Material.ANDESITE || block.getType() == Material.GRANITE) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/20000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROCK);
            }else {
            }

            Random r2 = new Random();
            float chance2 = r2.nextFloat();
            if (chance2 <= 1/100000f) { //EMPTY
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROCK);
            }else {
            }

        }




        if (block.getType().equals(Material.IRON_ORE) || block.getType().equals(Material.DEEPSLATE_IRON_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/2000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_IRON);
            }else {
            }
        }


        if (block.getType().equals(Material.COAL_ORE) || block.getType().equals(Material.DEEPSLATE_COAL_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/2000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_COAL);
            }else {
            }
        }


        if (block.getType().equals(Material.GOLD_ORE) || block.getType().equals(Material.DEEPSLATE_GOLD_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/1200f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_GOLD);
            }else {
            }
        }


        if (block.getType().equals(Material.COPPER_ORE) || block.getType().equals(Material.DEEPSLATE_COPPER_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/2000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_COPPER);
            }else {
            }
        }


        if (block.getType().equals(Material.REDSTONE_ORE) || block.getType().equals(Material.DEEPSLATE_REDSTONE_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/750f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_REDSTONE);
            }else {
            }
        }


        if (block.getType().equals(Material.LAPIS_ORE) || block.getType().equals(Material.DEEPSLATE_LAPIS_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/750f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_LAPIS);
            }else {
            }
        }


        if (block.getType().equals(Material.DIAMOND_ORE) || block.getType().equals(Material.DEEPSLATE_DIAMOND_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/600f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_DIAMOND);
            }else {
            }
        }


        if (block.getType().equals(Material.EMERALD_ORE) || block.getType().equals(Material.DEEPSLATE_EMERALD_ORE) && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/600f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_EMERALD);
            }else {
            }
        }



        if (block.getType().toString().contains("ORE") && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/5000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.BLOCKBUG_CRYSTAL);
            }else {
            }
        }





//        if (block.getType() == Material.MELON) {
//            Random r = new Random();
//            float chance = r.nextFloat();
//            if (chance <= 0.0002f) { // chance of 1/5000
//                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found a Watermelon Gleam!");
//                givecubitname = "gleamwatermelon";
//            }else {
//            }
//
//            Random r2 = new Random();
//            float chance2 = r.nextFloat();
//            if (chance2 <= 0.0001f) { // chance of 1/10000
//                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found a Melon Gleam!");
//                givecubitname = "gleammelon";
//            }else {
//            }
//
//        }



        if (block.getType() == Material.PUMPKIN) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/5000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.SHEEP_PUMPKIN);
            }else {
            }
        }


//        if (block.getType() == Material.CACTUS) {
//            Random r = new Random();
//            float chance = r.nextFloat();
//            if (chance <= 0.0002f) { // chance of 1/5000
//                plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId()).addCubit(CubitBase.ROOTLING_WARPED);
//            }else {
//            }
//        }


        if (block.getType() == Material.OAK_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_OAK);
            }else {
            }
        }


        if (block.getType() == Material.SPRUCE_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_SPRUCE);
            }else {
            }
        }


        if (block.getType() == Material.BIRCH_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_BIRCH);
            }else {
            }
        }


        if (block.getType() == Material.ACACIA_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_ACACIA);
            }else {
            }
        }


        if (block.getType() == Material.DARK_OAK_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_DARK_OAK);
            }else {
            }
        }


        if (block.getType() == Material.MANGROVE_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_MANGROVE);
            }else {
            }
        }


        if (block.getType() == Material.CHERRY_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_CHERRY);
            }else {
            }
        }

        if (block.getType() == Material.CRIMSON_STEM) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_CRIMSON);
            }else {
            }
        }

        if (block.getType() == Material.CRIMSON_STEM || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.CRIMSON_FOREST)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/3000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFSTOOL_CRIMSON);
            }else {
            }
        }


        if (block.getType() == Material.WARPED_STEM || player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.WARPED_FOREST)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/3000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.PUFFSTOOL_COBALT);
            }else {
            }
        }



        if (block.getType() == Material.WARPED_STEM) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/10000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.ROOTLING_WARPED);
            }else {
            }
        }

        if (block.getType() == Material.MANGROVE_LOG) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.SWAMP) ||
                    player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {
                if (chance <= 1/5000f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_TUNDRA);
                }else {
                }
                Random r2 = new Random();
                float chance2 = r2.nextFloat();
                if (chance2 <= 1/10000f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_GOLDEN);
                }else {
                }

            }
        }


        if (block.getType() == Material.POTATOES || block.getType() == Material.CARROTS || block.getType() == Material.WHEAT || block.getType() == Material.BEETROOTS || block.getType() == Material.PUMPKIN || block.getType() == Material.CACTUS || block.getType() == Material.MELON || block.getType() == Material.COCOA || block.getType() == Material.SWEET_BERRY_BUSH && block.getState().getData() instanceof Crops) {
            BlockData wheatData = block.getBlockData();
            org.bukkit.block.data.Ageable age = (Ageable) wheatData;
            if(age.getAge() == age.getMaximumAge()){

            Random r = new Random();
            float chance = r.nextFloat();
            if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.SWAMP) ||
                    player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()).equals(Biome.MANGROVE_SWAMP)) {
                if (chance <= 1/8000f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_WARPED);
                }else {
                }
                Random r2 = new Random();
                float chance2 = r2.nextFloat();
                if (chance2 <= 1/20000f) {
                    plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.FROGGO_GOLDEN);
                }else {
                }

            }
            }
        }


//        if (block.getType() == Material.CHERRY_LOG) {
//            Random r = new Random();
//            float chance = r.nextFloat();
//            Location loc = new Location(player.getWorld(), 3190, 80, 1625);
//            if(player.getLocation().distance(loc) < 90) {
//                if (chance <= 0.0033f) { // chance of 1/300
//                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pet Drop! " + ChatColor.GREEN + player.getName() + ChatColor.LIGHT_PURPLE + " has found a Cherry Golem!");
//                    PlayerProfile playerProfile = plugin.getPlayerProfileManager().getPlayerProfileByUUID(player.getUniqueId());
//                    playerProfile.addCubit(new Cubit(CubitBase.COOKIE, player));
//                    SoundUtil.PlaySoundAll(Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
//                }else {
//                }
//            }
//        }


        // End of Block Break Event
    }





    @EventHandler
    public void PlayerItemConsumeEvent(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();

        if (!player.getGameMode().equals(GameMode.SURVIVAL)) {
            return;
        }

        if (item.getType() == Material.COOKIE) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 999/1000f) {
                plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId()).addCubit(CubitBase.COOKIE);
            }else {
            }
        }

        // End of Item Consumed Events
    }


    // END
}
