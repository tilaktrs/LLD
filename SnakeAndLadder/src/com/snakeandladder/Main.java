package com.snakeandladder;

import com.snakeandladder.model.Entities;
import com.snakeandladder.service.PlaySnakeAndLadder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Entities entities = Entities.getInstance();

        int noOfSnakes = sc.nextInt();
        while(noOfSnakes>0){
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
         entities.setSnakes(startPosition,endPosition);
          noOfSnakes--;
        }
        int noOfLadders = sc.nextInt();
        while(noOfLadders>0){
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            entities.setLadders(startPosition,endPosition);
            noOfLadders--;
        }
        int noOfPlayers = sc.nextInt();
        int i=0;
        while(noOfPlayers>0){
            String player = sc.next();
            entities.setPlayers(i++,player);
            noOfPlayers--;
        }
        PlaySnakeAndLadder playSnakeAndLadder = new PlaySnakeAndLadder(6);
        System.out.println();
        System.out.println(playSnakeAndLadder.playGame());
    }
}
