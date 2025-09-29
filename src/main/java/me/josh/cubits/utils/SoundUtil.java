package me.josh.cubits.utils;

import me.josh.cubits.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtil {

    public static void PlaySoundAll(Sound sound, int volume, int pitch){
        for(Player player : Main.getInstance().getServer().getOnlinePlayers()){
            player.playSound(player, sound, volume, pitch);

        }
    }


}
