package com.davidparry.luck;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by david on 9/13/16.
 */
public class LuckyNumberPickerTest {
    private LuckyNumberPicker luckerNumberPicker;

    @Before
    public void setUp() throws Exception {
        luckerNumberPicker = new LuckyNumberPicker(10);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNumbersReturnTenTest() throws Exception {
        LuckyNumberPicker lnp = new LuckyNumberPicker(10);
        int[] numbers = lnp.getNumbers();
        Assert.assertNotNull("why is the array null should never be?",numbers);
        Assert.assertEquals("10 passed but the return amount is wrong",10,numbers.length);
    }

    @Test
    public void getNumbersReturnLessthan5Test() throws Exception {
        int[] numbers = luckerNumberPicker.getNumbers();
        Assert.assertNotNull("why is the array null should never be?",numbers);
        // how do we test this need?
        // need to control the suggested number to be less 5 how no way here
        // assert the value returns as the suggested value but how in this case
        // bad thing here we could be lucky and it actually returns 30
        // time for Interactive Code Design! (c) David Parry
        Assert.assertEquals("how can we start to get test this case ",30,numbers[0]);
    }

}