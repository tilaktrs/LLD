package com.tictactoe.service;

import com.tictactoe.exceptions.BoardException;
import com.tictactoe.model.Board;
import com.tictactoe.model.Player;
import com.tictactoe.validations.GameValidator;

import java.util.ArrayList;

public class TicTacToeService {
    Board board;
    ArrayList<Player> players;
    GameValidator gameValidator;
    int gameCount=0; // for handling draw

    public TicTacToeService(Board board , ArrayList<Player> players , GameValidator gameValidator){
        this.board = board;
        this.players = players;
        this.gameValidator = gameValidator;
    }


    public void input(int x , int y , Player player){

        int X =x-1;
        int Y= y-1;
// NOTE ye validation ham main mein bhi kar sakte for better user expereinece
        if(!gameValidator.validateCoordinate(X,Y)){
            throw new BoardException("Inputs are Not Valid");
        }
        if(!gameValidator.validateIsBoardPositionEmpty(X,Y)){
            throw new BoardException("Board position already filled");
        }

        //set the input
        String symbol = player.getSymbol();
        board.setPosition(X ,Y , symbol);
         board.printBoard(board.getBoard()); // printing board after every move

        //check whether the player wins or not
        if(checkBoard(X,Y,symbol)){
       System.out.println("Player" + player.getPlayerName() +" Wins");
       System.exit(0);
        }
        gameCount++;
        if(checkBoardFill()){
            System.out.println("Game Draw");
            System.exit(0);
        }
    }

    private boolean checkBoardFill() {
        return gameCount == board.getBoard().length*board.getBoard().length;
    }

    //yha pe check kar rahe ahi ki kahi koi player jeet tohhh nahi gya
    private boolean checkBoard(int x, int y, String symbol) {
        boolean winRow=true ,winCol = true , winLeftDiag = true ,winRightDiag = true;

        //note if can't be if else because agar row se nahi ban rha hai tohh col se try karo aur agar col nahi left diagonal..so on
        for(int i=0;i<board.getBoard().length;i++){

            if(!board.getPosition(x,i).equals(symbol)){ // checking row
                winRow =false;
            }
            if(!board.getPosition(i,y).equals(symbol)){ // checking col
                winCol = false;
            }
            if(!board.getPosition(i,i).equals(symbol)){ //checking left diagnol
                winLeftDiag = false;
            }
            if(!board.getPosition(i,board.getBoard().length-i-1).equals(symbol)){ // checking right diagnol
                winRightDiag = false;
            }
        }

        return winRow || winCol || winLeftDiag || winRightDiag;
    }

}
