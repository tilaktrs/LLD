package com.tictactoe.validations;

import com.tictactoe.model.Board;
import com.tictactoe.model.Player;

import java.util.HashMap;

public class GameValidator {
Board board;
HashMap<Integer, Boolean> playerCheck;

public GameValidator(Board board , HashMap<Integer,Boolean> playerCheck){
    this.board = board;
    this.playerCheck = playerCheck;
}

public boolean validateCoordinate(int x , int y){
    if(x<board.getBoard().length && y<board.getBoard().length && x>=0 && y>=0){
        return true;
    }
    return false;
}

public boolean validateIsBoardPositionEmpty(int x , int y){
    return board.getPosition(x,y).equals("-");
}

public boolean validatePlayer(Player player){
    int id = player.getId();
    if(playerCheck.get(id) == false){ // matlab wo user chal chuka ahi
        return false;
    }
    else{
        playerCheck.put(id , false);
        if(id == 2){
            playerCheck.put(1, true);
            playerCheck.put(2,true);
        }
        return true;
    }
}

}
