package me.josh.cubits.listeners;

import me.josh.cubits.Main;
import me.josh.cubits.commands.SummeryCommand;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.utils.SoundUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class RightClickCubitListener implements Listener {
    private final Main plugin;

    public RightClickCubitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCubitFeed(PlayerInteractAtEntityEvent e) {

        Player player = e.getPlayer();
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(player.getUniqueId());
        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();

        //Check if cubit is clicked
        if (!(e.getRightClicked() instanceof Wolf || e.getRightClicked() instanceof ArmorStand)) return;
        if (playerProfile.getActiveCubitEntity().getCubit() == null) return;
        if (e.getRightClicked() == playerProfile.getActiveCubitEntity().getWolf() || e.getRightClicked() == playerProfile.getActiveCubitEntity().getArmorStand()) {

            //Cancel wolf sit
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                Wolf wolf = (Wolf) e.getRightClicked();
                wolf.setSitting(false);
            }, 1);

            //Open Pet Summery if Sneaking
            if(e.getPlayer().isSneaking()) {
                new SummeryCommand().executeCommand(plugin, player, new String[]{"1"});
                SoundUtil.PlaySoundAll(Sound.UI_BUTTON_CLICK, 1, 1);
                return;
            }

            //Check if player is holding cookie
            if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COOKIE)) {
                e.getPlayer().sendMessage(ChatColor.WHITE + "[" + ChatColor.translateAlternateColorCodes('&', cubit.getName() + ChatColor.WHITE + "] Yummy!"));

                //Remove Cookie from Hand
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                    ItemStack item1 = e.getPlayer().getInventory().getItemInMainHand();
                    item1.setAmount(item1.getAmount() - 1);
                    e.getPlayer().getInventory().setItemInMainHand(item1);
                }, 1);
                return;
            }


        }
    }




}
