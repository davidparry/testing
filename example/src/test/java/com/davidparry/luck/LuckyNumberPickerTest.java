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
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(10);
        Assert.assertEquals("something is very wrong value size is wrong",10,numbers.length);
    }

    @Test
    public void getNumbersReturnTenTest() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(6);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(10);
        Assert.assertEquals("10 passed but the return amount is wrong",10,numbers.length);
    }

    /**
     * We still have many scenarios to capture every boundary case but now its just testing out those cases with the Mock
     * @throws Exception
     */
    @Test
    public void getNumbersReturnLessthan5Test() throws Exception {
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(5,6);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertEquals("The value should always be 6 something changed ",6,numbers[0]);
    }

}