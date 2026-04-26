package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ObtainTreat;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerUpgrades;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FishingListener implements Listener {

    private final Main plugin;

    public FishingListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

        if (event.getCaught() instanceof Item) {

            if(playerProfile.getUpgrades().get(PlayerUpgrades.FISHING_UPGRADE_FISHING_FRENZY)){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/30f) {
                    playerProfile.setActivateFishingFrenzy(true);
                }
            }

            if(playerProfile.getUpgrades().get(PlayerUpgrades.FISHING_UPGRADE_DOUBLE_HAUL)){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/10f) {
                    playerProfile.setActivateDoubleHaul(true);
                }
            }

            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                        .getBlockZ()).equals(Biome.JUNGLE)) {
                    if (chance <= 1/15f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_SUNFISH);
                        return;
                    }else {
                    }
                }
            }

            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                        .getBlockZ()).equals(Biome.JUNGLE)) {
                    if (chance <= 1/15f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_MOONFISH);
                        return;
                    }else {
                    }
                }
            }




            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();

                if (player.getLocation().getBlock().getBiome().name().contains("DARK_FOREST")) {
                    if (chance <= 1/6f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_SHROOMA_RED);
                        return;
                    }else {
                    }
                }
            }

            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();

                if (player.getLocation().getBlock().getBiome().name().contains("DARK_FOREST")) {
                    if (chance <= 1/8f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_SHROOMA_BROWN);
                        return;
                    }else {
                    }
                }
            }

            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                        .getBlockZ()).equals(Biome.JUNGLE) && playerProfile.getUpgrades().get(PlayerUpgrades.FISHING_UPGRADE_TITANIUM_LURE)) {
                    if (chance <= 1/35f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_CHUB_TITANIC);
                        return;
                    }else {
                    }
                }
            }

            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                        .getBlockZ()).equals(Biome.JUNGLE)) {
                    if (chance <= 1/6f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_CHUB);
                        return;
                    }else {
                    }
                }
            }


            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                    if (chance <= 1/6f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_CARP);
                        return;
                    }else {
                    }
            }


            if(playerProfile.getUpgrades().get(PlayerUpgrades.FISHING_UPGRADE_FISHING_FRENZY)){
                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 1/30f) {
                    int gemFinder = ThreadLocalRandom.current().nextInt(10, 30 + 1);
                    playerProfile.addMiniGameTokens(MiniGameToken.GEMS, gemFinder);
                    player.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Gem Finder! Reeled in a sack of " + gemFinder + " gems!");
                }
            }











            // End of custom fishing
            playerProfile.setActivateFishingFrenzy(false);
            playerProfile.setActivateDoubleHaul(false);
        }

    }


//    @EventHandler(priority = EventPriority.HIGH)
//    public void Fish(PlayerFishEvent e){
//        Player p = e.getPlayer();
//        if(e.getCaught() != null) {
//            e.setCancelled(true);
//            if (p.getInventory().firstEmpty() == -1) {
//                p.sendMessage(ChatColor.DARK_AQUA + "You caught a fish :D");
//            }
//        }
//
//    }

}
