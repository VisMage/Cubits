package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ObtainTreat;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;

public class FishingListener implements Listener {

    private final Main plugin;

    public FishingListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();

        if (event.getCaught() instanceof Item) {



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
                if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                        .getBlockZ()).equals(Biome.DARK_FOREST)) {
                    if (chance <= 1/15f) {
                        new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_SHROOMA_RED);
                        return;
                    }else {
                    }
                }
            }

            if(event.getCaught() instanceof Item){
                Random r = new Random();
                float chance = r.nextFloat();
                if (player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation()
                        .getBlockZ()).equals(Biome.DARK_FOREST)) {
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
                        .getBlockZ()).equals(Biome.JUNGLE)) {
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


            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/1f) {
                new ObtainTreat(plugin).GiveTreat(player, ItemBase.FISH_CARP);
            } else {
            }

            // End of custom fishing
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
