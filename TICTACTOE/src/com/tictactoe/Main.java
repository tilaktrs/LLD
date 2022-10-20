package com.tictactoe;

import com.tictactoe.model.Board;
import com.tictactoe.model.Player;
import com.tictactoe.service.TicTacToeService;
import com.tictactoe.validations.GameValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        Player player1= new Player("Player1" , 1 , "O");
        Player player2 = new Player("Player2" , 2 , "X");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        HashMap<Integer,Boolean> playerCheck = new HashMap<>();
        playerCheck.put(player1.getId() , true);
        playerCheck.put(player2.getId(),true);
        GameValidator gameValidator = new GameValidator(board , playerCheck); // initially ek map bna denge aur use store kar denge
        TicTacToeService ticTacToeService = new TicTacToeService(board ,players , gameValidator );

        while(true){
            System.out.println("choose Input : 1-> Play   2-> Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option){

                case 1:
                    System.out.println("Please Enter your ID");
                    Player player = players.get(sc.nextInt()-1);
                    if(!gameValidator.validatePlayer(player)){
                        System.out.println("Voilation of Game Rules");
                        break;
                    }
                    System.out.println("Enter your Move x and y");
                    ticTacToeService.input(sc.nextInt(), sc.nextInt() , player);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choose 1");
                    break;
            }
        }



    }
}
