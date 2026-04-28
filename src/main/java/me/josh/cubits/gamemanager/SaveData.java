package me.josh.cubits.gamemanager;

import me.josh.cubits.cubitdata.GlobalCubitStatistics;
import me.josh.cubits.playerdata.PlayerProfileManager;

import java.io.Serializable;

public class SaveData implements Serializable {
    private static final long serialVersionUID = 6;
    public PlayerProfileManager playerProfileManager;
    public GlobalCubitStatistics globalCubitStatistic;

    public SaveData(){

    }



}
