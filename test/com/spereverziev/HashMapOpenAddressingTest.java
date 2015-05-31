package com.spereverziev;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by spereverziev on 30.05.15.
 */
public class HashMapOpenAddressingTest {

    @Test
    public void tesGetAndPutOperations() {
        SimpleMap hashMap = new HashMapOpenAddressing();
        Assert.assertEquals(0, hashMap.size());

        hashMap.put(1, 2L);
        hashMap.put(2, 2L);
        Assert.assertEquals(hashMap.size(),2);

        hashMap.put(3, 3l);
        Assert.assertEquals(hashMap.size(),3);

        Assert.assertThat(hashMap.get(1), is(2L));
        Assert.assertThat(hashMap.get(2), is(2L));
        Assert.assertThat(hashMap.get(3), is(3L));
    }

    @Test
    public void testPutWhenCollisionsAppears() {
        SimpleMap hashMap = new HashMapOpenAddressing();
        Assert.assertEquals(hashMap.size(),0);

        hashMap.put(8, 78);
        hashMap.put(15, 64);

        Assert.assertThat(hashMap.get(8), is(78L));
        Assert.assertThat(hashMap.get(15), is(64L));
        Assert.assertThat(hashMap.size(), is(2));
    }

    @Test
    public void testGetShouldReturnNullWhenObjectNotFound() {
        SimpleMap hashMap = new HashMapOpenAddressing();
        Assert.assertNull(hashMap.get(88));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testPutShouldThrowExceptionWhenTableIsFull() {
        SimpleMap hashMap = new HashMapOpenAddressing();
        hashMap.put(1,2);
        hashMap.put(2,2);
        hashMap.put(3,3);
        hashMap.put(4,4);
        hashMap.put(5,1);
        hashMap.put(6,1);
        hashMap.put(7,1);
        hashMap.put(8,1);
    }
}