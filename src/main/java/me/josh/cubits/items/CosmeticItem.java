package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;

public class CosmeticItem extends ItemBase{
    private String alternateSkin;

    public CosmeticItem(String name, String identifier, String description, int customModeldata, String glosseryObtain, int cost, String alternateSkin) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.COSMETIC_ITEM;
        this.alternateSkin = alternateSkin;
    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        cubit.setAltSkin(alternateSkin);
        playerProfile.getActiveCubitEntity().SetCubitHead();
    }

    public void OnUnequip(Cubit cubit, PlayerProfile playerProfile){
        // ADD REMOVING COSMETIC HERE (Use Held Item's unequip method as reference)
    }


}
