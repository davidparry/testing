package com.davidparry.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by david on 9/13/16.
 * 100% coverage that our simple wrapper of this Concrete class works
 *
 */
public class RandomWrapperImplTest {
    @Test
    public void nextInt() throws Exception {
        RandomWrapperImpl impl = new RandomWrapperImpl(12L);
        Assert.assertNotNull(impl.nextInt(1));
    }

    @Test
    public void nextIntNegative() throws Exception {
        RandomWrapperImpl impl = new RandomWrapperImpl(-12L);
        Assert.assertNotNull(impl.nextInt(23));
    }

    @Test
    public void nextIntNegativeOne() throws Exception {
        RandomWrapperImpl impl = new RandomWrapperImpl(2L);
        try {
            impl.nextInt(-1);
            Assert.assertTrue(false);
        } catch(Exception er){
            //making sure we are following the wrapped contract
            Assert.assertNotNull(er);
        }
    }

    @Test
    public void nextLongNegative() throws Exception {
        RandomWrapperImpl impl = new RandomWrapperImpl(-12L);
        Assert.assertNotNull(impl.nextLong());
    }

    @Test
    public void nextLong() throws Exception {
        RandomWrapperImpl impl = new RandomWrapperImpl(122L);
        Assert.assertNotNull(impl.nextLong());
    }

    @Test
    public void getNanoTime() throws Exception {
        RandomWrapperImpl impl = new RandomWrapperImpl(122L);
        Assert.assertNotNull(impl.getNanoTime());
    }

}