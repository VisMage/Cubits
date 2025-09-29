package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;

public class FindTokenListener implements Listener {

    private final Main plugin;

    public FindTokenListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();

        if (event.getCaught() instanceof Item) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/75f) {
                player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "You gained a Fishing Token!");
                PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
                playerProfile.addMiniGameTokens(MiniGameToken.FISHING, 1);
                SoundUtil.PlaySoundAll(Sound.BLOCK_BEEHIVE_ENTER, 1, 1);
            } else {
            }
        }

        //END OF FISHING
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        if(player.isDead()) {
            player.getKiller();
            if(player.getKiller() != null) {

                if(player.getName().equals("Vis_Mage")){
                    player.sendMessage(ChatColor.RED +"You've killed" + player.getName() + "!");
                }

                //Minegame_World for sharpshooter and one in the quiver
                if(player.getWorld().getName().equalsIgnoreCase("SG_World")){
                    Random r = new Random();
                    float chance = r.nextFloat();
                    if (chance <= 1/10f) { // 1 in 10
                        player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "You gained a Combat Token!");
                        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
                        playerProfile.addMiniGameTokens(MiniGameToken.COMBAT, 1);
                        SoundUtil.PlaySoundAll(Sound.BLOCK_BEEHIVE_ENTER, 1, 1);
                    } else {
                    }
                }

                //p.sendMessage(ChatColor.RED +"You've killed" + p.getName() + "!");
            }
        }

    }


    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e){

        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();

        if(player.getWorld().getName().equalsIgnoreCase("Minegame_World")){

            if (e.getDamager().getType() != EntityType.ARROW) return;
            Arrow arrow = (Arrow) e.getDamager();

            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/25f) { // 1 in 25
                player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "You gained a Combat Token!");
                PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
                playerProfile.addMiniGameTokens(MiniGameToken.COMBAT, 1);
                SoundUtil.PlaySoundAll(Sound.BLOCK_BEEHIVE_ENTER, 1, 1);
            } else {
            }
        }

    }




}

