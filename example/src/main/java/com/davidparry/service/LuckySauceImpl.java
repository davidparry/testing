package com.davidparry.service;

/**
 * First lets look what we can do on our end which is create an Interface to come up with our Contract
 * Yes you know what should happen but who else will and what about change what infect the other code?
 *
 * Now we have a contract to work against in our own code
 *
 * Created by david on 9/12/16.
 */
public class LuckySauceImpl implements LuckySauce {
    private RandomWrapper mRandomWrapper;


    public LuckySauceImpl(RandomWrapper randomWrapper) {
        mRandomWrapper = randomWrapper;
    }

    public long getLuckySauce() {
        return mRandomWrapper.nextLong();
    }
}
