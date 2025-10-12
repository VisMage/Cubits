package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.menus.SlayerTask;
import me.josh.cubits.menus.SlayerUpgradeShop;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SlayerUpgradeMenuListener implements Listener {
    private final Main plugin;

    public SlayerUpgradeMenuListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Slayer Upgrades")) return;
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

        int tokens = playerProfile.getMiniGameTokens().get(MiniGameToken.SLAYER_TOKENS);

        // Check for individual item types, CustomModelData, or Item Name

        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;

        } else if (e.getCurrentItem().getType().equals(Material.WIND_CHARGE)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT) == 0 || tokens < 10) {
                // No task, or cannot afford the upgrade
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else if(playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_AMOUNT) < playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_TARGET_AMOUNT)){
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 10);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_POINTS_REWARD, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_TARGET_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_ORIGINAL_TARGET_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_STREAK, 0);
                SlayerTask.getRandomEntry(plugin, p);
            }else{
                // Task is already ready to claim, prevent skipping
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }
            SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);

        } else if (e.getCurrentItem().getType().equals(Material.COBWEB)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_SPIDER_SQUASHER) == 1 || tokens < 20) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 20);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_UPGRADE_SPIDER_SQUASHER, 1);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
            if (tokens < 5) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 5);
                playerProfile.addPlayerVariables(PlayerVariables.SLAYER_TARGET_AMOUNT, playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_ORIGINAL_TARGET_AMOUNT) / 2);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }


        } else if (e.getCurrentItem().getType().equals(Material.DRAGON_HEAD)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_DRAGON) == 1 || tokens < 30) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 30);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_UPGRADE_DRAGON, 1);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.WITHER_SKELETON_SKULL)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_WITHER) == 1 || tokens < 30) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 30);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_UPGRADE_WITHER, 1);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.SCULK_SENSOR)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_WARDEN) == 1 || tokens < 30) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 30);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_UPGRADE_WARDEN, 1);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_BOSSRUSH) == 1 || tokens < 50) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 50);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_UPGRADE_BOSSRUSH, 1);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.SLAYER_UPGRADE_POINTBOOST) == 1 || tokens < 50) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 50);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_UPGRADE_POINTBOOST, 1);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.IRON_BARS)) {
            if (tokens < 20 || playerProfile.getSlayerBlock() == null) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.setSlayerBlock(playerProfile.getSlayerMob());
                playerProfile.removeMiniGameTokens(MiniGameToken.SLAYER_TOKENS, 10);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_POINTS_REWARD, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_TARGET_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_ORIGINAL_TARGET_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.SLAYER_STREAK, 0);
                SlayerTask.getRandomEntry(plugin, p);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.IRON_INGOT)) {
            if (playerProfile.getSlayerBlock() == null) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.setSlayerBlock(null);
                SlayerUpgradeShop.OpenSlayerUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1); //Test Message
            p.closeInventory();
        }

    }



}
