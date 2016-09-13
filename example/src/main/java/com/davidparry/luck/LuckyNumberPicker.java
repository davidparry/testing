package com.davidparry.luck;

import com.davidparry.service.LuckySauce;

import java.util.Random;

/**
 * Created by david on 9/12/16.
 */
public class LuckyNumberPicker {

    private int[] mNumbers;

    /**
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
     * @param amount - total amount of numbers to pick
     */
    public LuckyNumberPicker(int amount) {
        mNumbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            LuckySauce secretSauce = new LuckySauce();
            Random random = new Random(secretSauce.getLuckySauce());
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
                mNumbers[i] = suggested;
            } else {
                i--;
            }
        }

    }

    public static void main(String[] args) {
        LuckyNumberPicker luckyNumberPicker = new LuckyNumberPicker(10);
        int[] numbers = luckyNumberPicker.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public int[] getNumbers() {
        return mNumbers;
    }
}
