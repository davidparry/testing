package com.davidparry.luck;

import com.davidparry.service.LuckySauce;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
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
    public void getNumbersReturnTenTest() throws Exception {
        LuckySauce luckySauce = Mockito.mock(LuckySauce.class);
        // ok now we are cooking we can control what LuckySauce will returned when
        // getLuckSauce is called in the LuckNumber Picker
        Mockito.when(luckySauce.getLuckySauce()).thenReturn(15L);

        LuckyNumberPicker lnp = new LuckyNumberPicker(luckySauce);
        int[] numbers = lnp.getNumbers(10);
        Assert.assertNotNull("why is the array null should never be?",numbers);
        Assert.assertEquals("10 passed but the return amount is wrong",10,numbers.length);
    }

    @Test
    public void getNumbersReturnLessthan5Test() throws Exception {
        LuckySauce luckySauce = Mockito.mock(LuckySauce.class);
        // ok now we are cooking we can control what LuckySauce will returned when
        // getLuckSauce is called in the LuckNumber Picker
        Mockito.when(luckySauce.getLuckySauce()).thenReturn(15L);

        LuckyNumberPicker lnp = new LuckyNumberPicker(luckySauce);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertNotNull("why is the array null should never be?",numbers);
        //So do not give up hope we are close we did the LuckySauce injection and mocking but now
        // we need to take control of the ugly concrete class
        Assert.assertEquals("Darn still not there yet but soon ",30,numbers[0]);
    }

}