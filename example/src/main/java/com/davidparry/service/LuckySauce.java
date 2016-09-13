package com.davidparry.service;

import java.util.Random;

/**
 * Created by david on 9/12/16.
 */
public class LuckySauce {
    private long mSeed;

    public LuckySauce() {
        Random random = new Random(System.nanoTime());
        mSeed = random.nextLong();
    }

    public long getLuckySauce() {
        return mSeed;
    }
}
