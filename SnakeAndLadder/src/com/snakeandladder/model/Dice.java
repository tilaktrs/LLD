package com.snakeandladder.model;

import java.util.Random;

public class Dice {
    private int numberOfDice;
    Random random;

    public Dice(int numberOfDice){
        random = new Random();
        this.numberOfDice = numberOfDice;
    }

    public int getNumberOfDice() {
        return random.nextInt(6)+1; // note [0,6) 6 is not inclusive**
    }
}
