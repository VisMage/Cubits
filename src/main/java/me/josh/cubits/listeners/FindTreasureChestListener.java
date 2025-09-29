package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.items.ItemBase;
import me.josh.cubits.menus.TreasureChest;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;

public class FindTreasureChestListener implements Listener {

    private final Main plugin;

    public FindTreasureChestListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        final Player player = event.getPlayer();

        if (event.getCaught() instanceof Item) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/30f) {
                new TreasureChest().OpenTreasureChest(plugin, player, ItemBase.DUMMY, 1, 0);
            } else {
            }
        }

        //END OF FISHING
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Block block = (Block) e.getBlock();

        if (block.getType() == Material.STONE || block.getType() == Material.DEEPSLATE && !e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/1000f) {
                new TreasureChest().OpenTreasureChest(plugin, player, ItemBase.DUMMY, 3, 0);
            } else {
            }
        }

        if (block.getType().toString().contains("LOG")) {
            Random r = new Random();
            float chance = r.nextFloat();
            if (chance <= 1/300f) {
                new TreasureChest().OpenTreasureChest(plugin, player, ItemBase.DUMMY, 2, 0);
            }
        }

        // End of block break event
    }


}
