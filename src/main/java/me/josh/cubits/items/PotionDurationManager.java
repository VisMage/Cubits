package me.josh.cubits.items;

import me.josh.cubits.playerdata.PlayerProfile;
import me.josh.cubits.playerdata.PlayerVariables;

import java.util.*;

public class PotionDurationManager {
    private static final Set<PlayerVariables> POTION_VARIABLES = EnumSet.of(
            PlayerVariables.LUCKY_POTION,
            PlayerVariables.BOUNTIFUL_POTION,
            PlayerVariables.MIDUS_POTION,
            PlayerVariables.CHEF_POTION,
            PlayerVariables.EXPERIENCE_POTION,
            PlayerVariables.TREASURE_POTION,
            PlayerVariables.SHINY_POTION,
            PlayerVariables.SLAYER_POTION,
            PlayerVariables.CRUSADER_POTION,
            PlayerVariables.PROSPECTOR_POTION,
            PlayerVariables.CHAOS_POTION,
            PlayerVariables.ANGLER_POTION
    );

    private PotionDurationManager() {
    }

    public static PlayerVariables getVariableFor(PotionItem potion) {
        if (potion == null || potion.getIdentifier() == null) {
            return null;
        }

        switch (potion.getIdentifier()) {
            case "LUCKY_POTION":
                return PlayerVariables.LUCKY_POTION;
            case "BOUNTIFUL_POTION":
                return PlayerVariables.BOUNTIFUL_POTION;
            case "MIDUS_POTION":
                return PlayerVariables.MIDUS_POTION;
            case "CHEF_POTION":
                return PlayerVariables.CHEF_POTION;
            case "EXPERIENCE_POTION":
                return PlayerVariables.EXPERIENCE_POTION;
            case "TREASURE_POTION":
                return PlayerVariables.TREASURE_POTION;
            case "SHINY_POTION":
                return PlayerVariables.SHINY_POTION;
            case "SLAYER_POTION":
                return PlayerVariables.SLAYER_POTION;
            case "CRUSADER_POTION":
                return PlayerVariables.CRUSADER_POTION;
            case "PROSPECTOR_POTION":
                return PlayerVariables.PROSPECTOR_POTION;
            case "CHAOS_POTION":
                return PlayerVariables.CHAOS_POTION;
            case "ANGLER_POTION":
                return PlayerVariables.ANGLER_POTION;
            default:
                return null;
        }
    }

    public static boolean isPotionVariable(PlayerVariables variable) {
        return POTION_VARIABLES.contains(variable);
    }

    public static boolean isActive(PlayerProfile profile, PlayerVariables variable) {
        return getRemainingMinutes(profile, variable) > 0;
    }

    public static boolean hasAnyActivePotion(PlayerProfile profile) {
        for (PlayerVariables variable : POTION_VARIABLES) {
            if (getRemainingMinutes(profile, variable) > 0) {
                return true;
            }
        }

        return false;
    }

    public static int getRemainingMinutes(PlayerProfile profile, PlayerVariables variable) {
        if (profile == null || variable == null) {
            return 0;
        }

        return Math.max(0, profile.getPlayerVariable(variable));
    }

    public static void addPotionDuration(PlayerProfile profile, PotionItem potion) {
        PlayerVariables variable = getVariableFor(potion);

        if (profile == null || variable == null || potion == null) {
            return;
        }

        profile.addPlayerVariables(variable, potion.getDurationMinutes());
    }

    public static void tickDownOneMinute(PlayerProfile profile) {
        tickDownOneMinuteAndGetExpired(profile);
    }

    public static String formatMinutes(int totalMinutes) {
        totalMinutes = Math.max(0, totalMinutes);

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        if (hours <= 0) {
            return minutes + "m";
        }

        if (minutes <= 0) {
            return hours + "h";
        }

        return hours + "h " + minutes + "m";
    }


    public static List<PlayerVariables> tickDownOneMinuteAndGetExpired(PlayerProfile profile) {
        List<PlayerVariables> expiredPotions = new ArrayList<>();

        if (profile == null) {
            return expiredPotions;
        }

        for (PlayerVariables variable : POTION_VARIABLES) {
            int currentMinutes = getRemainingMinutes(profile, variable);

            if (currentMinutes <= 0) {
                continue;
            }

            int newMinutes = Math.max(0, currentMinutes - 1);
            profile.setPlayerVariable(variable, newMinutes);

            if (newMinutes == 0) {
                expiredPotions.add(variable);
            }
        }

        return expiredPotions;
    }


    public static String getPotionDisplayName(PlayerVariables variable) {
        if (variable == null) {
            return "Potion";
        }

        String rawName = variable.name().toLowerCase(Locale.ROOT);
        String[] words = rawName.split("_");

        StringBuilder displayName = new StringBuilder();

        for (String word : words) {
            if (word.isBlank()) {
                continue;
            }

            if (!displayName.isEmpty()) {
                displayName.append(" ");
            }

            displayName
                    .append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }

        return displayName.toString();
    }


}
