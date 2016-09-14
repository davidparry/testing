package com.davidparry.luck;

import com.davidparry.service.LuckySauce;

import java.util.Random;

/**
 *
 * Created by david on 9/12/16.
 */
public class LuckyNumberPicker {

    private LuckySauce mLuckySauce;

    /**
     * Ok the Constructor has been changed
     * Still need more to test since Random is a concrete class arghhh
     *
     *
     *
     *
     * Needs to pick as many as numbers that the amount requests
     * criteria on the suggested number which is seeded by the LuckSauce
     * 1. greater than 30 and current nano time is divisible by 5 add 10 to suggestion
     * 2. greater than 30 and current nano time is divisible by 6 add 6 to suggestion
     * 3. less than 30 and current nano time is divisible by 8 add 5 to suggestion
     * 4. less than 30 and current nano time is divisible by 43 subtract 12 from suggestion use its absolute value if less than 0
     * 5. current nano time is divisible by 47 subtract 1 from suggestion use its absolute value if less than 0
     * 6. current nano time is divisible by 53 add 23 from suggestion
     *
     * if value is over 70 or less than 5 than ask LuckySauce again
     *
     * @param luckySauce - IoC injection of our LuckySauce
     *
     * Now we can inject the concrete implementation or a Mock of LuckySauce interface as long as we follow the contract
     */
    public LuckyNumberPicker(LuckySauce luckySauce) {
        mLuckySauce = luckySauce;

    }

    /**
     * Not the best wa a big method but we are starting
     * @param amount
     * @return
     */
    public int[] getNumbers(int amount) {
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            // this is still a problem
            Random random = new Random(mLuckySauce.getLuckySauce());
            int suggested = random.nextInt(70);

            if (suggested > 30 && System.nanoTime() % 5 == 0) {
                suggested = suggested + 10;
            } else if (suggested > 30 && System.nanoTime() % 6 == 0) {
                suggested = suggested + 6;
            } else if (suggested < 30 && System.nanoTime() % 8 == 0) {
                suggested = suggested + 5;
            } else if (suggested < 30 && System.nanoTime() % 43 == 0) {
                suggested = Math.abs(suggested - 12);
            } else if (System.nanoTime() % 47 == 0) {
                suggested = Math.abs(suggested - 1);
            } else if (System.nanoTime() % 53 == 0) {
                suggested = suggested + 23;
            }
            if (suggested < 71 && suggested > 5) {
                numbers[i] = suggested;
            } else {
                i--;
            }
        }
        return numbers;
    }
}
