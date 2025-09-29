package me.josh.cubits.cubitdata;

import me.josh.cubits.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GlobalCubitStatistics {
    private Map<CubitBase, Integer> cubitsObtainedByCubitBase;
    private Map<CubitBase, UUID> firstPlayerByCubitBase;

    public GlobalCubitStatistics(){
        cubitsObtainedByCubitBase = new HashMap<>();
        firstPlayerByCubitBase = new HashMap<>();
    }

    public void AddCubitStatistic(Player player, CubitBase cubitBase){
        if(cubitsObtainedByCubitBase.containsKey(cubitBase)){
            cubitsObtainedByCubitBase.put(cubitBase, cubitsObtainedByCubitBase.get(cubitBase) + 1);
            Main.getInstance().getLogger().info("Number of " + cubitBase.getName() + " obtained: " + cubitsObtainedByCubitBase.get(cubitBase));
        }else{
            cubitsObtainedByCubitBase.put(cubitBase, 1);
            firstPlayerByCubitBase.put(cubitBase, player.getUniqueId());
            Main.getInstance().getLogger().info("First " + cubitBase.getName() + " was obtained by " + Bukkit.getPlayer(firstPlayerByCubitBase.get(cubitBase)).getName());
        }

    }

    public Map<CubitBase, Integer> getCubitsObtainedByCubitBase() {
        return cubitsObtainedByCubitBase;
    }

    public Map<CubitBase, UUID> getFirstPlayerByCubitBase() {
        return firstPlayerByCubitBase;
    }



}
