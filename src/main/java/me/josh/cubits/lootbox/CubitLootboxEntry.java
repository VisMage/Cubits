package me.josh.cubits.lootbox;

import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.playerdata.PlayerProfile;

public class CubitLootboxEntry implements LootboxEntry{

    private CubitBase cubitBase;

    public CubitLootboxEntry(CubitBase cubitBase){
        this.cubitBase = cubitBase;
    }

    @Override
    public void obtain(PlayerProfile playerProfile) {
        playerProfile.addCubit(cubitBase);
        System.out.println("You got a " + cubitBase.getName());
    }
}
