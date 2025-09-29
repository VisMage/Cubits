package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CubitBase;
import me.josh.cubits.cubitentity.CreateHead;
import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;
import me.josh.cubits.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class StarterCommand implements SubCommand{
    private static final String NAME = "Starter";
    private static final String DESCRIPTION = "Opens the Starter Cubit menu.";
    private static final  String ERROR_COLOR = "&c";
    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        // Catch Errors
        if(args.length != 1){
            Utils.msg(p, String.format("%sIncorrect syntax. /cb Starter", ERROR_COLOR));
            return;
        }

        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());
        if(playerProfile.getPlayerVariables().get(PlayerVariables.IF_STARTER) == 1) {
            Utils.msg(p, String.format("%sYou have already chosen a starter Cubit!", ERROR_COLOR));
            return;
        }

        // Declare Variables
        String NAME_TEMP;
        CubitBase chosenStarterBase;
        NamespacedKey key = new NamespacedKey(plugin, "clickedHead");

        // Create Inventory
        Inventory gui = Bukkit.createInventory(p, 27, "Choose your Starter!");

        // Create Items to place in inventory
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta back_meta = back.getItemMeta();
        back_meta.setDisplayName("Back");
        back.setItemMeta(back_meta);

        ItemStack filling = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta filling_meta = filling.getItemMeta();
        filling_meta.setDisplayName(" ");
        filling.setItemMeta(filling_meta);

        ItemStack item5 = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta)item5.getItemMeta();
        skullMeta.setOwner("vvvvvvvvvvvv");
        NAME_TEMP = p.getDisplayName();
        NAME_TEMP = ChatColor.stripColor(NAME_TEMP);
        skullMeta.setDisplayName(ChatColor.BLUE + NAME_TEMP);
        skullMeta.setLore(Arrays.asList(ChatColor.GOLD + "Choose your Starter!"));
        item5.setItemMeta(skullMeta);

        ItemStack starter1 = CreateHead.createHead(CubitBase.SHEEP.getDefaultSkin());
        SkullMeta skullMeta1 = (SkullMeta)starter1.getItemMeta();
        chosenStarterBase = CubitBase.SHEEP;
        skullMeta1.setDisplayName(ChatColor.BLUE + chosenStarterBase.getName());
        skullMeta1.setLore(Arrays.asList(ChatColor.BLUE + chosenStarterBase.getName(), ChatColor.LIGHT_PURPLE + chosenStarterBase.getDescription()));
        skullMeta1.getPersistentDataContainer().set(key, PersistentDataType.STRING, chosenStarterBase.getName());
        starter1.setItemMeta(skullMeta1);

        ItemStack starter2 = CreateHead.createHead(CubitBase.CRABBY.getDefaultSkin());
        SkullMeta skullMeta2 = (SkullMeta)starter2.getItemMeta();
        chosenStarterBase = CubitBase.CRABBY;
        skullMeta2.setDisplayName(ChatColor.BLUE + chosenStarterBase.getName());
        skullMeta2.setLore(Arrays.asList(ChatColor.BLUE + chosenStarterBase.getName(), ChatColor.LIGHT_PURPLE + chosenStarterBase.getDescription()));
        skullMeta2.getPersistentDataContainer().set(key, PersistentDataType.STRING, chosenStarterBase.getName());
        starter2.setItemMeta(skullMeta2);

        ItemStack starter3 = CreateHead.createHead(CubitBase.PENGIN.getDefaultSkin());
        SkullMeta skullMeta3 = (SkullMeta)starter3.getItemMeta();
        chosenStarterBase = CubitBase.PENGIN;
        skullMeta3.setDisplayName(ChatColor.BLUE + chosenStarterBase.getName());
        skullMeta3.setLore(Arrays.asList(ChatColor.BLUE + chosenStarterBase.getName(), ChatColor.LIGHT_PURPLE + chosenStarterBase.getDescription()));
        skullMeta3.getPersistentDataContainer().set(key, PersistentDataType.STRING, chosenStarterBase.getName());
        starter3.setItemMeta(skullMeta3);

        ItemStack starter4 = CreateHead.createHead(CubitBase.AXIE.getDefaultSkin());
        SkullMeta skullMeta4 = (SkullMeta)starter4.getItemMeta();
        chosenStarterBase = CubitBase.AXIE;
        skullMeta4.setDisplayName(ChatColor.BLUE + chosenStarterBase.getName());
        skullMeta4.setLore(Arrays.asList(ChatColor.BLUE + chosenStarterBase.getName(), ChatColor.LIGHT_PURPLE + chosenStarterBase.getDescription()));
        skullMeta4.getPersistentDataContainer().set(key, PersistentDataType.STRING, chosenStarterBase.getName());
        starter4.setItemMeta(skullMeta4);

        ItemStack starter5 = CreateHead.createHead(CubitBase.CUBEE.getDefaultSkin());
        SkullMeta skullMeta5 = (SkullMeta)starter5.getItemMeta();
        chosenStarterBase = CubitBase.CUBEE;
        skullMeta5.setDisplayName(ChatColor.BLUE + chosenStarterBase.getName());
        skullMeta5.setLore(Arrays.asList(ChatColor.BLUE + chosenStarterBase.getName(), ChatColor.LIGHT_PURPLE + chosenStarterBase.getDescription()));
        skullMeta5.getPersistentDataContainer().set(key, PersistentDataType.STRING, chosenStarterBase.getName());
        starter5.setItemMeta(skullMeta5);

        // Loop to fill in remaining slots with Gray Stained Glass Panes
        for (int i = 0; i < 27; i++) {
            if(i < 9 || i > 18 || i % 9 == 0 || i % 9 == 8){
                gui.setItem(i, filling);
            }
        }

        // Set items into their proper slots
        gui.setItem(4, item5);
        gui.setItem(11, starter1);
        gui.setItem(12, starter2);
        gui.setItem(13, starter3);
        gui.setItem(14, starter4);
        gui.setItem(15, starter5);
        gui.setItem(22, back);
        p.openInventory(gui);

    }




    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
