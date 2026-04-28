package me.josh.cubits.items;

import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;

public class PotionItem extends ItemBase{
    private String ingredients;
    private ItemBase id1;
    private ItemBase id2;
    private ItemBase id3;
    private ItemBase id4;
    private ItemBase id5;
    private int amount1;
    private int amount2;
    private int amount3;
    private int amount4;
    private int amount5;
    private int durationMinutes;



    public PotionItem(){}

    protected PotionItem(String name, String identifier, String description, int customModeldata, int minutes, String glosseryObtain, int cost, String ingredients, ItemBase id1, ItemBase id2, ItemBase id3, ItemBase id4, ItemBase id5, int amount1, int amount2, int amount3, int amount4, int amount5) {
        super(name, identifier, description, customModeldata, glosseryObtain, cost);
        itemType = ItemType.POTION_ITEM;
        this.ingredients = ingredients;
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.id4 = id4;
        this.id5 = id5;
        this.amount1 = amount1;
        this.amount2 = amount2;
        this.amount3 = amount3;
        this.amount4 = amount4;
        this.amount5 = amount5;
        this.durationMinutes = minutes;
    }

    @Deprecated
    public int getUses() {
        return durationMinutes;
    }

    @Override
    public void OnConsume(Cubit cubit, PlayerProfile playerProfile) {
        // USED POTION EFFECT HERE? (Or in the potion menu)
    }

    public int getAmount5() {
        return amount5;
    }

    public int getAmount4() {
        return amount4;
    }

    public int getAmount3() {
        return amount3;
    }

    public int getAmount2() {
        return amount2;
    }

    public int getAmount1() {
        return amount1;
    }

    public ItemBase getId5() {
        return id5;
    }

    public ItemBase getId4() {
        return id4;
    }

    public ItemBase getId3() {
        return id3;
    }

    public ItemBase getId2() {
        return id2;
    }

    public ItemBase getId1() {
        return id1;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void OnUnequip(Cubit cubit, PlayerProfile playerProfile){}

}
