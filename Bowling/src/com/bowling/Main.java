package com.bowling;

import com.bowling.model.Player;
import com.bowling.scoreboard.ScoreBoardImpl;
import com.bowling.service.BowlingGameService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Player p1= new Player(1 , "Player1" , new ScoreBoardImpl());
        Player p2 = new Player(2 ,"Player 2" , new ScoreBoardImpl());
        players.add(p1);
        players.add(p2);
        BowlingGameService bowlingGameService = new BowlingGameService(players);
        bowlingGameService.startGame();

        System.out.println(bowlingGameService.getWinner());



    }
}
