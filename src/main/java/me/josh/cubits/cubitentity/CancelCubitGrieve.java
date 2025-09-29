package me.josh.cubits.cubitentity;

import me.josh.cubits.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.persistence.PersistentDataType;

public class CancelCubitGrieve implements Listener {

    private final Main plugin;

    public CancelCubitGrieve(Main plugin) {
        this.plugin = plugin;
    }


    //Cancel dog damage
    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        NamespacedKey key = new NamespacedKey(plugin, "cubitUUID");

        if (e.getEntity() instanceof Wolf || e.getEntity().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            e.setCancelled(true);
        }

    }

    //Cancel armorstand armor
    @EventHandler
    public void onArmorStand(PlayerArmorStandManipulateEvent e) {

        NamespacedKey key = new NamespacedKey(plugin, "cubitUUID");

        if (!e.getRightClicked().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        e.setCancelled(true);
    }

}
