package ru.job4j.tracker.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Count.add(10, 2);
    }

    @Test
    public void when0to2then3() {
        int rsl = Count.add(0, 3);
        Assert.assertEquals(rsl, 3);
    }
}