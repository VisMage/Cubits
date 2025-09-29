package me.josh.cubits.commands;

import me.josh.cubits.Main;
import me.josh.cubits.cubitdata.CreateCubitHead;
import me.josh.cubits.cubitdata.Cubit;
import me.josh.cubits.playerdata.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SummeryCommand implements SubCommand{
    private static final String NAME = "Summery";
    private static final String DESCRIPTION = "Opens the Summery menu for your currently equipped Cubit.";
    private static final  String ERROR_COLOR = "&c";


    @Override
    public void executeCommand(Main plugin, Player p, String[] args) {

        //Get current cubit
        PlayerProfile playerProfile = plugin.getPlayerProfileManager().getProfileOf(p.getUniqueId());

        if(playerProfile.getActiveCubitEntity().getCubit() == null) {
            p.sendMessage(ChatColor.GREEN + "" + ChatColor.ITALIC + "No pet is equipped.");
            return;
        }

        ItemStack petItemHead;

        Cubit cubit = playerProfile.getActiveCubitEntity().getCubit();
        if(cubit == null){
            petItemHead = new ItemStack(Material.PAPER, 1);
            ItemMeta petItemHead_meta = petItemHead.getItemMeta();
            petItemHead_meta.setDisplayName("No Equipped Cubit");
            petItemHead.setItemMeta(petItemHead_meta);
        }else{
            petItemHead = new CreateCubitHead(plugin).NewCubitHead(p, cubit);
        }

        //Create custom items for inventory
        ItemStack filling = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillingMeta = filling.getItemMeta();
        fillingMeta.setDisplayName(" ");
        filling.setItemMeta(fillingMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pet Menu");
        back.setItemMeta(backMeta);

        ItemStack next = new ItemStack(Material.ARROW);
        ItemMeta nextMeta = next.getItemMeta();
        nextMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ribbons");
        next.setItemMeta(nextMeta);

        ItemStack unequip = new ItemStack(Material.LEAD);
        ItemMeta unequipMeta = unequip.getItemMeta();
        unequipMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Unequip Cubit");
        unequip.setItemMeta(unequipMeta);

        ItemStack pickup = new ItemStack(Material.GRAY_DYE);
        ItemMeta pickupMeta = pickup.getItemMeta();
        pickupMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pickup Current Cubit");
        pickup.setItemMeta(pickupMeta);

        ItemStack combatstyle = new ItemStack(Material.RED_DYE);
        ItemMeta combatstyleMeta = pickup.getItemMeta();
        combatstyleMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Combat Style: Offence");
        combatstyle.setItemMeta(combatstyleMeta);

        ItemStack rename = new ItemStack(Material.NAME_TAG);
        ItemMeta renamepMeta = pickup.getItemMeta();
        renamepMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Rename");
        rename.setItemMeta(renamepMeta);

        ItemStack info = new ItemStack(Material.PAPER);
        ItemMeta infoMeta = pickup.getItemMeta();
        infoMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Cubit Info");
        info.setItemMeta(infoMeta);

        ItemStack comingsoon1 = new ItemStack(Material.OAK_BUTTON);
        ItemMeta comingsoon1Meta = pickup.getItemMeta();
        comingsoon1Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Coming Soon");
        comingsoon1.setItemMeta(comingsoon1Meta);

        ItemStack password = new ItemStack(Material.OXEYE_DAISY);
        ItemMeta passwordMeta = pickup.getItemMeta();
        passwordMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Password");
        password.setItemMeta(passwordMeta);

        ItemStack ribbons = new ItemStack(Material.SPECTRAL_ARROW);
        ItemMeta ribbonsMeta = pickup.getItemMeta();
        ribbonsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ribbons");
        ribbons.setItemMeta(ribbonsMeta);





        //Create inventory
        Inventory menu = Bukkit.createInventory(null, 36, ChatColor.DARK_PURPLE + "Summery");
        for (int i = 0; i < 36; i++) {
            menu.setItem(i, filling);
        }

        menu.setItem(4, petItemHead);
        menu.setItem(8, ribbons);
        menu.setItem(0, back);
        menu.setItem(31, close);
        menu.setItem(27, unequip);
        menu.setItem(35, pickup);

        menu.setItem(11, info);
        menu.setItem(12, combatstyle);
        menu.setItem(13, rename);
        menu.setItem(14, password);
        menu.setItem(15, comingsoon1);

        menu.setItem(21, comingsoon1);
        menu.setItem(22, comingsoon1);
        menu.setItem(23, comingsoon1);

        p.openInventory(menu);

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
