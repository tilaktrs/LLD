package com.bowling.service;

import com.bowling.constants.AppConstants;
import com.bowling.model.Player;

import java.util.ArrayList;
import java.util.Random;

public class BowlingGameService {
    ArrayList<Player> players;
    Player winnerPlayer;
    Random random;

    public BowlingGameService(ArrayList<Player> players){
        random = new Random();
        this.players = players;
    }

    public void startGame(){
        int maxScore =0;
        for(Player player : players){ // here players will play this game sequentially

            int standingPins = AppConstants.TOTAL_PINS;

            // storing in rollingScore array [] in first part
            for(int index=0;index<AppConstants.MAX_ROLLS;index++){
                int numPinDown = takeShot(standingPins);
                standingPins = standingPins - numPinDown;

                if(index%2==0){
                    player.getScoreBoard().roll(numPinDown , index);
                    if(standingPins ==0){ // strike
                        index++; // taki ye wala aur upar milke index+2 ho jaye
                        standingPins = refillThePins(); //need to refill the pins when we get STRIKE
                     }
                }
                else{ // odd index
                   player.getScoreBoard().roll(numPinDown , index);
                   standingPins = refillThePins(); // After every odd we need to refill the pins.
                }
            }

            //finding the score in second part
            int finalScore = player.getScoreBoard().score();
            if(finalScore > maxScore){
                maxScore = finalScore;
                winnerPlayer = player;
            }

        }
    }

    public String getWinner(){
        winnerPlayer.setWin(true);
        return winnerPlayer.toString();
    }

    private int refillThePins() {
        return AppConstants.TOTAL_PINS;
    }

    private int takeShot(int standingPins) {
        return random.nextInt(standingPins);
    }

}
