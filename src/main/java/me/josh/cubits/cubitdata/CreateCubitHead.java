package me.josh.cubits.cubitdata;

import me.josh.cubits.Main;
import me.josh.cubits.cubitentity.CreateHead;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class CreateCubitHead {

    private final Main plugin;

    public CreateCubitHead(Main plugin) {
        this.plugin = plugin;
    }

    public ItemStack NewCubitHead(Player player, Cubit cubit) {

        String gradeLetter_STAMINA;
        String gradeLetter_SWIM;
        String gradeLetter_FLY;
        String gradeLetter_POWER;
        String gradeLetter_RUN;
        String gradeLetter_MYSTIC;
        String gradeLetter_DARKMAGIC;

        //Get cubit data
        int staminaLevel = cubit.getCubitLevel(CubitStat.STAMINA);

        if(cubit.getGrades().get(CubitStat.STAMINA) == 0){
            gradeLetter_STAMINA = "E";
        } else if (cubit.getGrades().get(CubitStat.STAMINA) == 1) {
            gradeLetter_STAMINA = "D";
        } else if (cubit.getGrades().get(CubitStat.STAMINA) == 2) {
            gradeLetter_STAMINA = "C";
        } else if (cubit.getGrades().get(CubitStat.STAMINA) == 3) {
            gradeLetter_STAMINA = "B";
        } else if (cubit.getGrades().get(CubitStat.STAMINA) == 4) {
            gradeLetter_STAMINA = "A";
        } else{
            gradeLetter_STAMINA = "S";
        }

        //String petType = unlockedPets.get(i).getCubitBase().getName();
        //double level = unlockedPets.get(i).getExp();
        double level = cubit.getStats().get(CubitStat.STAMINA);
        int currentLevel = (int) Math.floor(level);
        //int progress = (int) Math.floor((level - currentLevel) * 10);

        int totalLevel = currentLevel;
        int exp = currentLevel;
        int startingExp = 100;
        double multiplierExp = 0.5;

        int next_exp_needed_to_level_up = 100;
        int previous_exp_needed_to_level_up = 0;

        int getlevel = 1;
        int currentExpCeiling = startingExp;
        int currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentLevel = (int) Math.floor((getlevel));

        int progress = 0;
        double progress3 = next_exp_needed_to_level_up / 10;
        double progress4 = progress3;
        double progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progress++;
        }

        StringBuilder progressBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.GOLD);
        for (int j = 0; j < progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progress; j++) {
            progressBar.append("█");
        }
        progressBar.append(ChatColor.DARK_GRAY).append("]");

        // NEW STATS HERE 1/2
        int powweLevel = cubit.getCubitLevel(CubitStat.POWER);

        if(cubit.getGrades().get(CubitStat.POWER) == 0){
            gradeLetter_POWER = "E";
        } else if (cubit.getGrades().get(CubitStat.POWER) == 1) {
            gradeLetter_POWER = "D";
        } else if (cubit.getGrades().get(CubitStat.POWER) == 2) {
            gradeLetter_POWER = "C";
        } else if (cubit.getGrades().get(CubitStat.POWER) == 3) {
            gradeLetter_POWER = "B";
        } else if (cubit.getGrades().get(CubitStat.POWER) == 4) {
            gradeLetter_POWER = "A";
        } else{
            gradeLetter_POWER = "S";
        }

        double pow = cubit.getStats().get(CubitStat.POWER);
        int currentPow = (int) Math.floor(pow);
        //int progressPow = (int) Math.floor((pow - currentPow) * 10);

        int totalPow = currentPow;
        exp = currentPow;
        startingExp = 100;
        multiplierExp = 0.5;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentPow = (int) Math.floor((getlevel));

        int progressPow = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progressPow++;
        }

        StringBuilder progressPowBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.RED);
        for (int j = 0; j < progressPow; j++) {
            progressPowBar.append("█");
        }
        progressPowBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progressPow; j++) {
            progressPowBar.append("█");
        }
        progressPowBar.append(ChatColor.DARK_GRAY).append("]");

        //=========================================================

        int swimLevel = cubit.getCubitLevel(CubitStat.SWIM);

        if(cubit.getGrades().get(CubitStat.SWIM) == 0){
            gradeLetter_SWIM = "E";
        } else if (cubit.getGrades().get(CubitStat.SWIM) == 1) {
            gradeLetter_SWIM = "D";
        } else if (cubit.getGrades().get(CubitStat.SWIM) == 2) {
            gradeLetter_SWIM = "C";
        } else if (cubit.getGrades().get(CubitStat.SWIM) == 3) {
            gradeLetter_SWIM = "B";
        } else if (cubit.getGrades().get(CubitStat.SWIM) == 4) {
            gradeLetter_SWIM = "A";
        } else{
            gradeLetter_SWIM = "S";
        }

        double swim = cubit.getStats().get(CubitStat.SWIM);
        int currentSwim = (int) Math.floor(swim);
        //int progressSwim = (int) Math.floor((swim - currentSwim) * 10);


        int totalSwim = currentSwim;
        exp = currentSwim;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentSwim = (int) Math.floor((getlevel));

        int progressSwim = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progressSwim++;
        }



        StringBuilder progressSwimBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_AQUA);
        for (int j = 0; j < progressSwim; j++) {
            progressSwimBar.append("█");
        }
        progressSwimBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progressSwim; j++) {
            progressSwimBar.append("█");
        }
        progressSwimBar.append(ChatColor.DARK_GRAY).append("]");

        //=========================================================

        int runLevel = cubit.getCubitLevel(CubitStat.RUN);

        if(cubit.getGrades().get(CubitStat.RUN) == 0){
            gradeLetter_RUN = "E";
        } else if (cubit.getGrades().get(CubitStat.RUN) == 1) {
            gradeLetter_RUN = "D";
        } else if (cubit.getGrades().get(CubitStat.RUN) == 2) {
            gradeLetter_RUN = "C";
        } else if (cubit.getGrades().get(CubitStat.RUN) == 3) {
            gradeLetter_RUN = "B";
        } else if (cubit.getGrades().get(CubitStat.RUN) == 4) {
            gradeLetter_RUN = "A";
        } else{
            gradeLetter_RUN = "S";
        }

        double run = cubit.getStats().get(CubitStat.RUN);
        int currentRun = (int) Math.floor(run);
        //int progressRun = (int) Math.floor((run - currentRun) * 10);


        int totalRun = currentRun;
        exp = currentRun;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentRun = (int) Math.floor((getlevel));

        int progressRun = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progressRun++;
        }


        StringBuilder progressRunBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.GREEN);
        for (int j = 0; j < progressRun; j++) {
            progressRunBar.append("█");
        }
        progressRunBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progressRun; j++) {
            progressRunBar.append("█");
        }
        progressRunBar.append(ChatColor.DARK_GRAY).append("]");

        //=========================================================

        int flyLevel = cubit.getCubitLevel(CubitStat.FLY);

        if(cubit.getGrades().get(CubitStat.FLY) == 0){
            gradeLetter_FLY = "E";
        } else if (cubit.getGrades().get(CubitStat.FLY) == 1) {
            gradeLetter_FLY = "D";
        } else if (cubit.getGrades().get(CubitStat.FLY) == 2) {
            gradeLetter_FLY = "C";
        } else if (cubit.getGrades().get(CubitStat.FLY) == 3) {
            gradeLetter_FLY = "B";
        } else if (cubit.getGrades().get(CubitStat.FLY) == 4) {
            gradeLetter_FLY = "A";
        } else{
            gradeLetter_FLY = "S";
        }

        double fly = cubit.getStats().get(CubitStat.FLY);
        int currentFly = (int) Math.floor(fly);
        //int progressFly = (int) Math.floor((fly - currentFly) * 10);


        int totalFly = currentFly;
        exp = currentFly;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentFly = (int) Math.floor((getlevel));

        int progressFly = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progressFly++;
        }


        StringBuilder progressFlyBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.LIGHT_PURPLE);
        for (int j = 0; j < progressFly; j++) {
            progressFlyBar.append("█");
        }
        progressFlyBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progressFly; j++) {
            progressFlyBar.append("█");
        }
        progressFlyBar.append(ChatColor.DARK_GRAY).append("]");

        //=========================================================

        int mysticLevel = cubit.getCubitLevel(CubitStat.MYSTIC);

        if(cubit.getGrades().get(CubitStat.MYSTIC) == 0){
            gradeLetter_MYSTIC = "E";
        } else if (cubit.getGrades().get(CubitStat.MYSTIC) == 1) {
            gradeLetter_MYSTIC = "D";
        } else if (cubit.getGrades().get(CubitStat.MYSTIC) == 2) {
            gradeLetter_MYSTIC = "C";
        } else if (cubit.getGrades().get(CubitStat.MYSTIC) == 3) {
            gradeLetter_MYSTIC = "B";
        } else if (cubit.getGrades().get(CubitStat.MYSTIC) == 4) {
            gradeLetter_MYSTIC = "A";
        } else{
            gradeLetter_MYSTIC = "S";
        }

        double mys = cubit.getStats().get(CubitStat.MYSTIC);
        int currentMys = (int) Math.floor(mys);
        //int progressMys = (int) Math.floor((mys - currentMys) * 10);


        int totalMys = currentMys;
        exp = currentMys;

        next_exp_needed_to_level_up = 100;
        previous_exp_needed_to_level_up = 0;

        getlevel = 1;
        currentExpCeiling = startingExp;
        currentExpCeilingPrevious = 0;

        while(exp >= currentExpCeiling) {
            currentExpCeilingPrevious = currentExpCeiling;
            previous_exp_needed_to_level_up = next_exp_needed_to_level_up;
            currentExpCeiling += startingExp + (startingExp * getlevel * multiplierExp);
            next_exp_needed_to_level_up = (int) (startingExp + (startingExp * getlevel * multiplierExp));
            getlevel++;
        }

        currentMys = (int) Math.floor((getlevel));

        int progressMys = 0;
        progress3 = next_exp_needed_to_level_up / 10;
        progress4 = progress3;
        progress5 = exp - currentExpCeilingPrevious;

        while(progress5 >= progress4) {
            progress4 += progress3;
            progressMys++;
        }


        StringBuilder progressMysBar = new StringBuilder(ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_PURPLE);
        for (int j = 0; j < progressMys; j++) {
            progressMysBar.append("█");
        }
        progressMysBar.append(ChatColor.GRAY);
        for (int j = 0; j < 10 - progressMys; j++) {
            progressMysBar.append("█");
        }
        progressMysBar.append(ChatColor.DARK_GRAY).append("]");


        ItemStack petItem = CreateHead.createHead(cubit.getCubitBase().getDefaultSkin());
        ItemMeta meta = petItem.getItemMeta();

        NamespacedKey key = new NamespacedKey(plugin, "uuid");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, cubit.getUuid().toString());

        String skin;
        if(cubit.getAltSkin() == null) {
            skin = cubit.getCubitBase().getDefaultSkin();
        }else{
            skin = cubit.getAltSkin();
        }

        if(cubit.getStarter() == 1 & cubit.getShiny() == 1){
            meta.setDisplayName(cubit.getName() + " ♠★");
        }else if (cubit.getShiny() == 1){
            meta.setDisplayName(cubit.getName() + " ★");
        }else if(cubit.getStarter() == 1){
            meta.setDisplayName(cubit.getName() + " ♠");
        }else{
            meta.setDisplayName(cubit.getName());
        }

        meta.setCustomModelData(293);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(cubit.getCubitBase().getDescription());

        lore.add(" ");
        lore.add(ChatColor.GOLD + "STAMINA:");
        lore.add(ChatColor.GOLD + String.valueOf(currentLevel) + " " + progressBar + " " + (gradeLetter_STAMINA) + ChatColor.GRAY + " (" + totalLevel + ")");

        //lore.add(" ");
        lore.add(ChatColor.RED + "POW:");
        lore.add(ChatColor.RED + String.valueOf(currentPow) + " " + progressPowBar + " " + (gradeLetter_POWER) + ChatColor.GRAY + " (" + totalPow + ")");
        lore.add(ChatColor.DARK_AQUA + "SWIM:");
        lore.add(ChatColor.DARK_AQUA + String.valueOf(currentSwim) + " " + progressSwimBar + " " + (gradeLetter_SWIM) + ChatColor.GRAY + " (" + totalSwim + ")");
        lore.add(ChatColor.GREEN + "RUN:");
        lore.add(ChatColor.GREEN + String.valueOf(currentRun) + " " + progressRunBar + " " + (gradeLetter_RUN) + ChatColor.GRAY + " (" + totalRun + ")");
        lore.add(ChatColor.LIGHT_PURPLE + "FLY:");
        lore.add(ChatColor.LIGHT_PURPLE + String.valueOf(currentFly) + " " + progressFlyBar + " " + (gradeLetter_FLY) + ChatColor.GRAY + " (" + totalFly + ")");
        lore.add(ChatColor.MAGIC + "VOID:");
        lore.add(ChatColor.DARK_PURPLE + String.valueOf(currentMys) + " " + progressMysBar + " " + (gradeLetter_MYSTIC) + ChatColor.GRAY + " (" + totalMys + ")");

        lore.add(ChatColor.GRAY + "Item: " + cubit.getHeldItem().getName());
        lore.add(ChatColor.GRAY + "Trait: " + String.valueOf(cubit.getTrait()));
        lore.add(ChatColor.GRAY + "Rebirth: " + String.valueOf(cubit.getRebirth()));
        lore.add(ChatColor.GRAY + "OG Owner: " + String.valueOf(cubit.getOriginalOwnerName()) + " #" + cubit.getSerialNumber());

        meta.setLore(lore);
        petItem.setItemMeta(meta);
        return petItem;

    }

}
