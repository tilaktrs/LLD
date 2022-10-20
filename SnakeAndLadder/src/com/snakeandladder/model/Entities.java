package com.snakeandladder.model;

import java.util.HashMap;

public class Entities {
    private static HashMap<Integer,Integer> snakes;
    private  static HashMap<Integer,Integer> ladders;
    private  static HashMap<Integer,String> players;
    public static Entities instance=null;

    public  Entities(){

        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new HashMap<>();
    }

    public  HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(int startPosition , int endPosition) {
        snakes.put(startPosition,endPosition);
    }

    public  HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(int startPosition , int endPosition) {
        ladders.put(startPosition,endPosition);
    }

    public HashMap<Integer, String> getPlayers() {
        return players;
    }

    public void setPlayers(int index , String playerName) {
        players.put(index,playerName);
    }

    public static Entities getInstance(){ //singleTon Pattern
        if(instance == null){
            instance = new Entities();
        }
        return instance;
    }
}
