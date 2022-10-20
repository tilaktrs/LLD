package com.parkingLot.entity;

import java.util.HashMap;

public enum DisplayType {
    FREE_COUNT("free_count"),
    FREE_SLOTS("free_slots"),
    OCCUPIED_SLOTS("occupied_slots");
    String display;

    DisplayType(String s){
        display = s;
    }

    public String toString(){
        return this.display;
    }

    public static final HashMap<String , DisplayType> map = new HashMap<>(values().length);

    static {
        for(DisplayType d : values()){
            map.put(d.display , d);
        }
    }

    public static DisplayType of(String name){
        return map.get(name);
    }

}
