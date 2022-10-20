    package com.bowling.model;

    import com.bowling.scoreboard.ScoreBoard;

    public class Player {
        private int id;
        private String playerName;
        private final ScoreBoard scoreBoard ;// each player is having it's own scoreboard
        private boolean isWin;

        public Player(int id , String playerName , ScoreBoard scoreBoard){
            this.id = id;
            this.playerName = playerName;
            this.scoreBoard = scoreBoard;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public ScoreBoard getScoreBoard() {
            return scoreBoard;
        }

        public boolean isWin() {
            return isWin;
        }

        public void setWin(boolean win) {
            isWin = win;
        }

        @Override
        public String toString(){
            return "Player - " + id + " , Score - " + scoreBoard.score();
        }
    }
