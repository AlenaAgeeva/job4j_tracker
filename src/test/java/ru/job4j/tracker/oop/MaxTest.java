package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMaxBetweenTwo() {
        int one = 1;
        int two = 4;
        int expected = 4;
        int result = Max.max(one, two);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxBetweenThree() {
        int one = 1;
        int two = 4;
        int three = 9;
        int expected = 9;
        int result = Max.max(Max.max(one, two), three);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenMaxBetweenFour() {
        int one = 1;
        int two = 4;
        int three = 9;
        int four = 20;
        int expected = 20;
        int result = Max.max(Max.max(one, two), Max.max(three, four));
        Assert.assertEquals(expected, result);
    }
}