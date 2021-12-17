package ru.job4j.tracker.lambda;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class CountDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = CountDiapason.diapason(1, 4, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenDemonstrativeFunctionThenDemonstrativeResults() {
        List<Double> result = CountDiapason.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        Assert.assertEquals(result, expected);
    }

}