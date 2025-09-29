package me.josh.cubits.lootbox;

import me.josh.cubits.items.ItemBase;
import me.josh.cubits.playerdata.MiniGameToken;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;

public class TokenLootboxEntry implements LootboxEntry{

    private MiniGameToken token;
    private int amount;

    public TokenLootboxEntry(MiniGameToken token, int amount){
        this.token = token;
        this.amount = amount;
    }

    @Override
    public void obtain(PlayerProfile playerProfile) {
        playerProfile.addMiniGameTokens(token, amount);
        System.out.println("You got " + amount + token.name());
    }


}
