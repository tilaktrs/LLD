package com.parkingLot.entity;

import java.util.HashMap;

public enum Command {
    CREATE_PARKING_LOT("create_parking_lot"),
    DISPLAY("display"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    EXIT("exit");

     String command;

     Command(String s){ // this constructor will get called whenever each constant or enum contants get loaded up
         command = s;
     }

     public String toString(){
         return this.command;
     }

     public static final HashMap<String , Command> map = new HashMap<>(values().length);

     static {
         for (Command c : values()) {
             map.put(c.command, c); // note input mein string daal rahe hai aur uss string se ham ek command map kar rahe hai
         }
     }

         public static Command of(String name){ // after constant only we can write method in enum
             return map.get(name); // this will return the command(enum) associated with the given command
         }
     }
