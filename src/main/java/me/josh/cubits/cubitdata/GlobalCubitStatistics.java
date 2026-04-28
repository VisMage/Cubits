package me.josh.cubits.cubitdata;

import me.josh.cubits.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GlobalCubitStatistics implements Serializable {
    private static final long serialVersionUID = 5;
    private transient Map<CubitBase, Integer> cubitsObtainedByCubitBase;
    private transient Map<CubitBase, UUID> firstPlayerByCubitBase;

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

    // Serialization Methods
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(cubitsObtainedByCubitBase.size());
        for(Map.Entry<CubitBase, Integer> entry : cubitsObtainedByCubitBase.entrySet()){
            oos.writeUTF(entry.getKey().getName());
            oos.writeInt(entry.getValue());
        }

        oos.writeInt(firstPlayerByCubitBase.size());
        for(Map.Entry<CubitBase, UUID> entry : firstPlayerByCubitBase.entrySet()){
            oos.writeUTF(entry.getKey().getName());
            oos.writeObject(entry.getValue());
        }

    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        cubitsObtainedByCubitBase = new HashMap<>();
        firstPlayerByCubitBase = new HashMap<>();

        int cubitsObtainedByCubitBaseSize = ois.readInt();
        for(int i = 0; i < cubitsObtainedByCubitBaseSize; i++){
            CubitBase cubitBase = CubitDatabase.getCubitBase(ois.readUTF());
            Integer amount = ois.readInt();
            cubitsObtainedByCubitBase.put(cubitBase, amount);
        }

        int firstPlayerByCubitBaseSize = ois.readInt();
        for(int i = 0; i < firstPlayerByCubitBaseSize; i++) {
            CubitBase cubitBase = CubitDatabase.getCubitBase(ois.readUTF());
            UUID uuid = (UUID) ois.readObject();
            firstPlayerByCubitBase.put(cubitBase, uuid);
        }

    }

    public Map<CubitBase, Integer> getCubitsObtainedByCubitBase() {
        return cubitsObtainedByCubitBase;
    }

    public Map<CubitBase, UUID> getFirstPlayerByCubitBase() {
        return firstPlayerByCubitBase;
    }



}
