package com.masterbuilder747.apexrandom;

public class Location {
    public String name;
    public double x; //0 < x < 1
    public double y; //0 < x < 1

    public int loot;
//    final public static int HIGH = 2;
//    final public static int MID = 1;
//    final public static int BASIC = 0;

    public Location(String name, int loot, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.loot = loot;
    }
    public Location(String name, int loot) {
        this.name = name;
        this.x = 0.5;
        this.y = 0.5;
        this.loot = loot;
    }
    public Location(String name) {
        this.name = name;
        this.x = 0.5;
        this.y = 0.5;
        this.loot = -1;
    }
    private Location() {

    }
}