package com.davidparry.luck;

import com.davidparry.service.RandomWrapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Now we are doing 1 assertion per test
 * Created by david on 9/13/16.
 */
public class LuckyNumberPickerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * checking the size not if its null should always be an object if not
     * an exception will happen and we are fine.
     */
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

    /**
     * @throws Exception
     */
    @Test
    public void getNumbersReturnLessthan5Test() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(5,6);
        // look we are actually injecting the same wrapped object to test out the random behavior too
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(System.nanoTime());
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("The value should always be 6 something changed ",6,numbers[0]);
    }


    /**
     * Lets start to catch another scenario that needs to be tested
     * 1.  greater than 30 and current nano time is divisible by 5 add 10 to suggestion
     * @throws Exception
     */
    @Test
    public void getNumbersGreaterThan30NanoSeedDividedBy5() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(31);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(10L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("We should have 31 + 10 but instead its ?",41,numbers[0]);
    }

    /**
     * Lets start to catch another scenario that needs to be tested
     * 2. greater than 30 and current nano time is divisible by 6 add 6 to suggestion
     * @throws Exception
     */
    @Test
    public void getNumbersGreaterThan30NanoSeedDividedBy6() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(40);
        Mockito.when(randomWrapper.getNanoTime()).thenReturn(36L);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(23);
        Assert.assertEquals("We should have 40 + 6 in all 23 places checking the 6 position which failed",46,numbers[6]);
    }


}