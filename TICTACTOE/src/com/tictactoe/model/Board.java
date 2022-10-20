package com.tictactoe.model;

import java.util.Arrays;

public class Board {
    String [][] board;

    public Board(int N){
        board = new String[N][N];
        for(int i=0;i<N;i++) {
            Arrays.fill(board[i], "-");
        }
    }

    public void printBoard(){
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void printBoard(String [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public String getPosition(int x , int y){
        return board[x][y];
    }
    public void setPosition(int x , int y , String symbol){
        board[x][y] = symbol;
    }
    public String[][] getBoard(){
        return board;
    }
}
