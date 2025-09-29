package me.josh.cubits.items;

public enum ItemType {
    STAT_BOOST_ITEM ("Treat"),
    COSMETIC_ITEM ("Cosmetic"),
    DUMMY_ITEM ("Item"),
    HELD_ITEM ("Trinket"),
    COOKING_ITEM ("Cooking"),
    POTION_ITEM ("Potion"),
    NONE ("");

    private String name;

    ItemType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
