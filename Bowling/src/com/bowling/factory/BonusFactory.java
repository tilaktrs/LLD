package com.bowling.factory;

import com.bowling.model.Bonus;
import com.bowling.strategy.DefaultStrategy;
import com.bowling.strategy.SparseStrategy;
import com.bowling.strategy.Strategy;
import com.bowling.strategy.StrikeStrategy;

public class BonusFactory {
    //factory Design Pattern
    public static Strategy getStrategy(Bonus bonus){

        if(bonus.equals(Bonus.STRIKE)){
            return new StrikeStrategy();
        }
        else if(bonus.equals(Bonus.SPARE)){
            return new SparseStrategy();
        }
        else {
            return new DefaultStrategy();
        }
    }
}
