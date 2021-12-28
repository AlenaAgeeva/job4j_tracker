package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenMissed2Times() {
        List<String> input = List.of("k1/sk1/ssk1");
        List<String> expect = List.of("k1", "k1/sk1", "k1/sk1/ssk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenNonChangeFirstDepartment() {
        List<String> input = List.of("k2");
        List<String> expect = List.of("k2");
        List<String> result = Departments.fillGaps(input);
        Assert.assertEquals(result, expect);
    }
}