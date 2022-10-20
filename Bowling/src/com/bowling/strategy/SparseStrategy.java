package com.bowling.strategy;

public class SparseStrategy implements Strategy{

    public static final Integer SPARE_BONUS = 5;

    @Override
    public int bonus(){ // note this method should be public bcz inteface mein method agar public hai tohh ham yha visibility
        //reduce nahi kar sakte***
        return SPARE_BONUS;
    }
//    All interface methods are public by default (even if you don't specify it explicitly in the interface definition),
//    so all implementing methods must be public too, since you can't reduce the visibility of the interface method
}
