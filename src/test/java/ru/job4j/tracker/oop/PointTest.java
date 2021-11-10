package ru.job4j.tracker.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point point = new Point(0, 0);
        Point point1 = new Point(0, 2);
        double expected = 2.;
        double result = point.distance(point1);
        Assert.assertEquals(expected, result, 0.01);

    }

    @Test
    public void when02to60then2() {
        Point point = new Point(0, 2);
        Point point1 = new Point(0, 6);
        double expected = 4.;
        double result = point.distance(point1);
        Assert.assertEquals(expected, result, 0.01);

    }
}