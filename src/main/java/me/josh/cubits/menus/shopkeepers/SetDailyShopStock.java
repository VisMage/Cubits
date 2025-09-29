package me.josh.cubits.menus.shopkeepers;

import me.josh.cubits.items.ItemBase;

public class SetDailyShopStock {

    public static ItemBase general_store_Item1;
    public static ItemBase general_store_Item2;
    public static ItemBase general_store_Item3;
    public static ItemBase general_store_Item4;
    public static ItemBase general_store_Item5;
    public static ItemBase farmer_shop_Item1;
    public static ItemBase farmer_shop_Item2;
    public static ItemBase farmer_shop_Item3;
    public static ItemBase farmer_shop_Item4;
    public static ItemBase farmer_shop_Item5;
    public static ItemBase sell_Item1;
    public static ItemBase sell_Item2;
    public static ItemBase sell_Item3;
    public static ItemBase sell_Item4;
    public static ItemBase sell_Item5;
    public static ItemBase desert_store_Item1;
    public static ItemBase desert_store_Item2;
    public static ItemBase desert_store_Item3;
    public static ItemBase desert_store_Item4;
    public static ItemBase desert_store_Item5;
    public static ItemBase tundra_store_Item1;
    public static ItemBase tundra_store_Item2;
    public static ItemBase tundra_store_Item3;
    public static ItemBase tundra_store_Item4;
    public static ItemBase tundra_store_Item5;
    public static ItemBase curiosity_merchant_Item1;
    public static ItemBase curiosity_merchant_Item2;
    public static ItemBase curiosity_merchant_Item3;
    public static ItemBase wandering_trader_Item1;
    public static ItemBase wandering_trader_Item2;
    public static ItemBase wandering_trader_Item3;


    public SetDailyShopStock(){

        general_store_Item1 = ShopkeeperRandomStock.GENERAL_STORE.getRandomEntry();
        general_store_Item2 = ShopkeeperRandomStock.GENERAL_STORE.getRandomEntry();
        general_store_Item3 = ShopkeeperRandomStock.GENERAL_STORE.getRandomEntry();
        general_store_Item4 = ShopkeeperRandomStock.GENERAL_STORE_RARE.getRandomEntry();
        general_store_Item5 = ShopkeeperRandomStock.GENERAL_STORE_RARE.getRandomEntry();
        farmer_shop_Item1 = ShopkeeperRandomStock.FARMER_SHOP.getRandomEntry();
        farmer_shop_Item2 = ShopkeeperRandomStock.FARMER_SHOP.getRandomEntry();
        farmer_shop_Item3 = ShopkeeperRandomStock.FARMER_SHOP.getRandomEntry();
        farmer_shop_Item4 = ShopkeeperRandomStock.FARMER_SHOP.getRandomEntry();
        farmer_shop_Item5 = ShopkeeperRandomStock.FARMER_SHOP.getRandomEntry();
        sell_Item1 = ShopkeeperRandomStock.SELL_SHOP.getRandomEntry();
        sell_Item2 = ShopkeeperRandomStock.SELL_SHOP.getRandomEntry();
        sell_Item3 = ShopkeeperRandomStock.SELL_SHOP.getRandomEntry();
        sell_Item4 = ShopkeeperRandomStock.SELL_SHOP.getRandomEntry();
        sell_Item5 = ShopkeeperRandomStock.SELL_SHOP.getRandomEntry();
        desert_store_Item1 = ShopkeeperRandomStock.DESERT_TRADER.getRandomEntry();
        desert_store_Item2 = ShopkeeperRandomStock.DESERT_TRADER.getRandomEntry();
        desert_store_Item3 = ShopkeeperRandomStock.DESERT_TRADER.getRandomEntry();
        desert_store_Item4 = ShopkeeperRandomStock.DESERT_TRADER.getRandomEntry();
        desert_store_Item5 = ShopkeeperRandomStock.DESERT_TRADER.getRandomEntry();
        tundra_store_Item1 = ShopkeeperRandomStock.TUNDRA_TRADER.getRandomEntry();
        tundra_store_Item2 = ShopkeeperRandomStock.TUNDRA_TRADER.getRandomEntry();
        tundra_store_Item3 = ShopkeeperRandomStock.TUNDRA_TRADER.getRandomEntry();
        tundra_store_Item4 = ShopkeeperRandomStock.TUNDRA_TRADER.getRandomEntry();
        tundra_store_Item5 = ShopkeeperRandomStock.TUNDRA_TRADER.getRandomEntry();
        curiosity_merchant_Item1 = ShopkeeperRandomStock.CURIOSITY_MERCHANT.getRandomEntry();
        curiosity_merchant_Item2 = ShopkeeperRandomStock.CURIOSITY_MERCHANT.getRandomEntry();
        curiosity_merchant_Item3 = ShopkeeperRandomStock.CURIOSITY_MERCHANT.getRandomEntry();
        wandering_trader_Item1 = ShopkeeperRandomStock.WANDERING_TRADER.getRandomEntry();
        wandering_trader_Item2 = ShopkeeperRandomStock.WANDERING_TRADER.getRandomEntry();
        wandering_trader_Item3 = ShopkeeperRandomStock.WANDERING_TRADER.getRandomEntry();


    }

}
