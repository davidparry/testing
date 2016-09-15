package com.davidparry.luck;

import com.davidparry.service.RandomWrapper;

/**
 *
 * Created by david on 9/12/16.
 */
public class LuckyNumberPicker {

    private RandomWrapper mRandomWrapper;

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
     * if value is over 70 or less than 5 than ask our Random again
     *
     * @param randomWrapper - IoC injection of our RandomWrapper now we do not have a reference or exposure to Lucky
     *
     * Now after another Design round we see we created a RandomWrapper and can now limit our exposure to only the
     * wrapper in this class no reference to LuckySauce yippie another point to ICD (c) David Parry :-)
     *
     *
     * We still had the dependency on the System.nanoTime for simplicity and time we added it to the RandomWrapper
     *
     */
    public LuckyNumberPicker(RandomWrapper randomWrapper) {
        mRandomWrapper = randomWrapper;

    }

    /**
     * Not the best wa a big method but we are starting
     * @param amount
     * @return
     */
    public int[] getNumbers(int amount) {
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            int suggested = mRandomWrapper.nextInt(70);
            long randomSeed = mRandomWrapper.getNanoTime();

            if (suggested > 30 && randomSeed % 5 == 0) {
                suggested = suggested + 10;
            } else if (suggested > 30 && randomSeed % 6 == 0) {
                suggested = suggested + 6;
            } else if (suggested < 30 && randomSeed % 8 == 0) {
                suggested = suggested + 5;
            } else if (suggested < 30 && randomSeed % 43 == 0) {
                suggested = Math.abs(suggested - 12);
            } else if (randomSeed % 47 == 0) {
                suggested = Math.abs(suggested - 1);
            } else if (randomSeed % 53 == 0) {
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
