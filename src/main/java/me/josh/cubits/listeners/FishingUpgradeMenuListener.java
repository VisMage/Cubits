package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.menus.FishingTask;
import me.josh.cubits.menus.FishingUpgradeShop;
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

public class FishingUpgradeMenuListener implements Listener {
    private final Main plugin;

    public FishingUpgradeMenuListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().startsWith("Fishing Upgrades")) return;
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

        int tokens = playerProfile.getMiniGameTokens().get(MiniGameToken.FISHING_TOKENS);

        // Check for individual item types, CustomModelData, or Item Name

        if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
            return;

        } else if (e.getCurrentItem().getType().equals(Material.WIND_CHARGE)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT) == 0 || tokens < 10) {
                // No task, or cannot afford the upgrade
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else if(playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_AMOUNT) < playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT)){
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 10);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_REWARD, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_ORIGINAL_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_STREAK, 0);
                SlayerTask.getRandomEntry(plugin, p);
            }else{
                // Task is already ready to claim, prevent skipping
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }
            FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);

        } else if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_GEM_FINDER) == 1 || tokens < 20) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 20);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_GEM_FINDER, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
            if (tokens < 5) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 5);
                playerProfile.addPlayerVariables(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT, playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_QUEST_ORIGINAL_AMOUNT) / 2);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }


        } else if (e.getCurrentItem().getType().equals(Material.PRISMARINE_SHARD)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_DRESSED_SPINNER) == 1 || tokens < 30) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 30);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_DRESSED_SPINNER, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.CHEST)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_TREASURE_LURE) == 1 || tokens < 30) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 30);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_TREASURE_LURE, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.NETHERITE_SCRAP)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_TITANIUM_LURE) == 1 || tokens < 30) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 30);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_TITANIUM_LURE, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_PRESERVE_LURE) == 1 || tokens < 50) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 50);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_PRESERVE_LURE, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.SALMON_BUCKET)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_DOUBLE_HAUL) == 1 || tokens < 50) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 50);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_DOUBLE_HAUL, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.KELP)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_SCAVANGER) == 1 || tokens < 50) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 50);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_SCAVANGER, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.PUFFERFISH)) {
            if (playerProfile.getPlayerVariables().get(PlayerVariables.FISHING_UPGRADE_FISHING_FRENZY) == 1 || tokens < 50) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 50);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_UPGRADE_FISHING_FRENZY, 1);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.IRON_BARS)) {
            if (tokens < 20 || playerProfile.getQuestFishBlocked() == null) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.setQuestFishBlocked(playerProfile.getQuestFish());
                playerProfile.removeMiniGameTokens(MiniGameToken.FISHING_TOKENS, 10);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_REWARD, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_TARGET_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_QUEST_ORIGINAL_AMOUNT, 0);
                playerProfile.setPlayerVariable(PlayerVariables.FISHING_STREAK, 0);
                FishingTask.getRandomEntry(plugin, p);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.IRON_INGOT)) {
            if (playerProfile.getQuestFishBlocked() == null) {
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1, 1);
            }else{
                SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                playerProfile.setSlayerBlock(null);
                FishingUpgradeShop.OpenFishingUpgradeStore(plugin, p);
            }

        } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            SoundUtil.PlaySoundAll(Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            p.closeInventory();
        }

    }



}
