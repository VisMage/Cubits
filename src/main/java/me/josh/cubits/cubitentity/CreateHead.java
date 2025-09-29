package me.josh.cubits.cubitentity;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class CreateHead {

    public static ItemStack createHead(String toBeUrl){
        URL url = null;
        try {
            url = new URL(toBeUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        UUID uuid = UUID.randomUUID();
        org.bukkit.profile.PlayerProfile profile = Bukkit.createPlayerProfile(uuid);
        PlayerTextures ptexture = profile.getTextures();
        ptexture.setSkin(url);
        profile.setTextures(ptexture);
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setOwnerProfile(profile);
        head.setItemMeta(skullMeta);
        return head;
    }

}
