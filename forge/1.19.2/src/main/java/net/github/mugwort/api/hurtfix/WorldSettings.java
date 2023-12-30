package net.github.mugwort.api.hurtfix;

import java.util.ArrayList;

public class WorldSettings{
    final String world;
    final Double magnification;
    final ArrayList<String> whiteList;
    public WorldSettings(String world, Double magnification, ArrayList<String> whiteList){
        this.world = world;
        this.magnification = magnification;
        this.whiteList = whiteList;
    }

    public String getWorld() {
        return world;
    }

    public Double getMagnification() {
        return magnification;
    }

    public ArrayList<String> getWhiteList() {
        return whiteList;
    }
}
