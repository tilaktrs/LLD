package com.snakeandladder.service;

import com.snakeandladder.model.Dice;
import com.snakeandladder.model.Entities;

import java.util.HashMap;

public class PlaySnakeAndLadder {
    private static HashMap<String , Integer> playerLatestPosition; //to store each player current position
    Entities entities;
    Dice dice;

    public PlaySnakeAndLadder(int n){
        playerLatestPosition = new HashMap<>();
        entities= Entities.getInstance();
        dice = new Dice(n);
    }

    public String playGame(){

        initializePlayerStartValue();
        int index=0; // starting index
        while(isPlayerWon(entities.getPlayers().get(index))!=true){
            StringBuilder sb = new StringBuilder(); // for output
            String playerName = entities.getPlayers().get(index);
            sb.append(playerName);
            int diceNumber = dice.getNumberOfDice();
            sb.append(" rolled a ").append(diceNumber);
            int endPosition = playerLatestPosition.get(playerName) + diceNumber;

            if(!isGreaterThan100(endPosition)){ // if not greater than 100
                sb.append(" and moved from ").append(playerLatestPosition.get(playerName));

                // find the correct endPosition after going through the ladder and snakes
                 if(entities.getSnakes().get(endPosition)!=null){
                     //update latest position
                     playerLatestPosition.put(playerName,entities.getSnakes().get(endPosition));
                 }
                 else if(entities.getLadders().get(endPosition)!=null){
                     //update latest position
                     playerLatestPosition.put(playerName,entities.getLadders().get(endPosition));
                 }
                 else{
                     //update latest position
                     playerLatestPosition.put(playerName,endPosition);
                 }
            }
            sb.append("to ").append(playerLatestPosition.get(playerName));
            System.out.println(sb);
            index++;
            if(index>= entities.getPlayers().size()){ // handle the rounds or iteration
                index=0;
            }
        }

      return entities.getPlayers().get(index);
    }

    public boolean isPlayerWon(String player){
        if(playerLatestPosition.get(player) == 100){
            return true;
        }
        return false;
    }

    public boolean isGreaterThan100(int endPosition){
        if(endPosition <=100){
            return false;
        }
        return true;
    }

    private void initializePlayerStartValue() {
        for(int i=0;i<entities.getPlayers().size();i++){
            playerLatestPosition.put(entities.getPlayers().get(i) , 0);
        }
    }

}
