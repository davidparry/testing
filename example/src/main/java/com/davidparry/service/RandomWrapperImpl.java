package com.davidparry.service;

import java.util.Random;

/**
 * The most this can be tested is that we get a value back from the rapped Random class
 * yipie we have insulated ourselves from the Random class throughout the rest of our application
 * Score a point for Interactive Code Design! (c) David Parry
 *
 * Created by david on 9/13/16.
 */
public class RandomWrapperImpl implements RandomWrapper {
    private long mLuckyValue;
    public RandomWrapperImpl(long luckyValue){
        mLuckyValue = luckyValue;
    }

    public int nextInt(int bounds) {
       return new Random(mLuckyValue).nextInt(bounds);
    }

    public long nextLong(){
        return new Random(mLuckyValue).nextLong();
    }
}
