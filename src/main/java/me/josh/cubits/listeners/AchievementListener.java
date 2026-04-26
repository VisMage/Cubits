package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.items.ObtainTreat;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;

public class AchievementListener implements Listener {

    private final Main plugin;

    public AchievementListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        if (e.getEntity().getKiller() != null) {
            Entity killer = e.getEntity().getKiller();
            final Player player = e.getEntity().getKiller();
            PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());

            EntityType killedMob = entity.getType();

            if (killer instanceof Player){
                if(playerProfile.getAch3Mob() == killedMob) {
                    SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                    playerProfile.addPlayerVariables(PlayerVariables.ACHIEVEMENT_AMOUNT_3, 1);
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

        if (block.getType() == playerProfile.getAch4Block() || block.getType() == playerProfile.getAch4BlockAlt()) {
            //SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            playerProfile.addPlayerVariables(PlayerVariables.ACHIEVEMENT_AMOUNT_4, 1);
        }
    }








}
