package me.josh.cubits.cubitentity;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.Cubit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CubitEntity {
    private Cubit cubit;
    private ArmorStand armorStand;
    private Wolf wolf;

    public CubitEntity(){
    }

    public void EquipCubit(Main plugin, Player p, Cubit cubit) {

        if(wolf != null){
            wolf.remove();
            wolf = null;
        }

        if(armorStand != null){
            armorStand.remove();
            armorStand = null;
        }

        this.cubit = cubit;

        //Create a wolf
        wolf = p.getWorld().spawn(p.getLocation(), Wolf.class);
        wolf.setOwner(p);
        wolf.setMaxHealth(1000);
        wolf.setHealth(1000);
        wolf.setInvisible(true);
        wolf.setInvulnerable(true);
        wolf.setSilent(true);
        wolf.setPersistent(false);
        wolf.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "cubitUUID"), PersistentDataType.STRING, cubit.getUuid().toString());

        //Create an armorstand
        armorStand = p.getWorld().spawn(p.getLocation().add(0, -0.5, 0), ArmorStand.class);
        armorStand.setGravity(false);
        armorStand.setVisible(false);
        armorStand.setInvulnerable(true);
        armorStand.setPersistent(false);
        armorStand.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(Main.class), "cubitUUID"), PersistentDataType.STRING, cubit.getUuid().toString());

        SetCubitHead();

    }


    public void SetCubitHead() {

        if(wolf == null || armorStand == null ||cubit == null ){
            return;
        }

        ItemStack currentPet = CreateHead.createHead(cubit.getCubitBase().getDefaultSkin());
        ItemMeta currentPetMeta = currentPet.getItemMeta();

        String skinCurrent;
        if(cubit.getAltSkin() == null){
            skinCurrent = cubit.getCubitBase().getDefaultSkin();
        }else{
            skinCurrent = cubit.getAltSkin();
        }

//        GameProfile gameProfileCurrent = new GameProfile(UUID.randomUUID(), null);
//        gameProfileCurrent.getProperties().put("textures", new Property("textures", skinCurrent));
//        try {
//            Method method = currentPetMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
//            method.setAccessible(true);
//            method.invoke(currentPetMeta, gameProfileCurrent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        currentPet.setItemMeta(currentPetMeta);
        armorStand.getEquipment().setHelmet(currentPet);

    }




    public void UnequipCubit() {

        if(wolf != null){
            wolf.remove();
            wolf = null;
        }

        if(armorStand != null){
            armorStand.remove();
            armorStand = null;
        }

        cubit = null;

    }

    public void DespawnCubit() {

        if(wolf != null){
            wolf.remove();
            wolf = null;
        }

        if(armorStand != null){
            armorStand.remove();
            armorStand = null;
        }

    }

    public boolean isActive(){
        return wolf != null && armorStand != null;
    }

    // Getters
    public Cubit getCubit() {
        return cubit;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }

    public Wolf getWolf() {
        return wolf;
    }
}
