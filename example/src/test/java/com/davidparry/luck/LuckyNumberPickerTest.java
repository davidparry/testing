package com.davidparry.luck;

import com.davidparry.service.RandomWrapper;
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
        // what our test is now even more straight forward
        // we no longer have LuckyNumber involved in this piece of work
        // Sarcasm ahead
        // hummmm but wait now that means my chances of breaking something in LuckyNumber during a change is? no fair
        // we should introduce nice new hard bugs when we change and have hard to understand code not easy "sarcasm"
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(6);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(10);
        Assert.assertNotNull("why is the array null should never be?",numbers);
        Assert.assertEquals("10 passed but the return amount is wrong",10,numbers.length);
    }

    /**
     * We still have many scenarios to capture every boundary case but now its just testing out those cases with the Mock
     * @throws Exception
     */
    @Test
    public void getNumbersReturnLessthan5Test() throws Exception {
        // what our test is now even more straight forward
        // we no longer have LuckyNumber involved in this piece of work
        // Sarcasm ahead
        // hummmm but wait now that means my chances of breaking something in LuckyNumber during a change is? no fair
        // we should introduce nice new hard bugs when we change and have hard to understand code not easy "sarcasm"
        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        // well we would be stuck in a loop if we always returned 5 correct
        Mockito.when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(5,6);
        LuckyNumberPicker lnp = new LuckyNumberPicker(randomWrapper);
        int[] numbers = lnp.getNumbers(1);
        Assert.assertNotNull("why is the array null should never be?",numbers);

        // wow how did we assert our rule in our method ?
        Assert.assertEquals("The value should always be 6 something changed ",6,numbers[0]);
    }

}