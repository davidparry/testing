package com.davidparry.luck;

import com.davidparry.service.RandomWrapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Completed all cases tested and edge cases
 * Created by david on 9/13/16.
 */
public class LuckyNumberPickerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNumbersCheckValidSize() throws Exception{
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(6);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(System.nanoTime());
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(10);
        Assert.assertEquals("something is very wrong value size is wrong",10,numbers.length);
    }

    @Test
    public void getNumbersReturnTenTest() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(6);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(System.nanoTime());
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(10);
        Assert.assertEquals("10 passed but the return amount is wrong",10,numbers.length);
    }


    @Test
    public void getNumbersGreaterThan30NanoSeedDividedBy5() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(31);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(10L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("We should have 31 + 10 but instead its ?",41,numbers[0]);
    }

    @Test
    public void getNumbersGreaterThan30NanoSeedDividedBy6() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(40);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(36L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(23);
        Assert.assertEquals("We should have 40 + 6 in all 23 places checking the 6 position which failed",46,numbers[6]);
    }

    @Test
    public void getNumbersLessThan30NanoSeedDividedBy8() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(29);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(8L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(100);
        Assert.assertEquals("should have 34 in all 100 places checking the 89 position which failed",34,numbers[89]);
    }

    @Test
    public void getNumbersLessThan30NanoSeedDividedBy43() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(25);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(43L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("subtraction piece is not working",13,numbers[0]);
    }

    @Test
    public void getNumbersNanoSeedDividedBy47() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        // can test the logic in 2 places to see the looping when less than 5
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(4,45);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(47L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("subtraction piece is not working with a looping section",44,numbers[0]);
    }

    @Test
    public void getNumbersNanoSeedGreaterThan71DividedByNoMatch() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        // now we are testing that greater than 71
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(73,45);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(1L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("subtraction piece is not working with a looping section",45,numbers[0]);
    }


    @Test
    public void getNumbersNanoSeedDividedBy53() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(23);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(53L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("subtraction piece is not working no loop",46,numbers[0]);
    }

    @Test
    public void getNumbers0AskedBack() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(0);
        Assert.assertEquals("should be no values",numbers.length,0);
    }

    @Test
    public void getNumbersNegativeAskedBack() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        try {
            int[] numbers = lnp.getNumbers(-1);
            Assert.assertTrue("should not reach here should throw an exception",false);
        } catch(NegativeArraySizeException nase) {
            Assert.assertTrue(true);
        }
    }

}