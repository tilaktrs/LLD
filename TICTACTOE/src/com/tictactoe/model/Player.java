package com.tictactoe.model;

public class Player { // 4 fields
    private String playerName;
    private int id;
    private String symbol;
    private boolean isWin = false;

    public Player(String playerName , int id , String symbol){
        this.playerName = playerName;
        this.id = id;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
