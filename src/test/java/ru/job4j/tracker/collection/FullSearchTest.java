package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<TaskCollection> tasks = Arrays.asList(
                new TaskCollection("1", "First desc"),
                new TaskCollection("2", "Second desc"),
                new TaskCollection("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        Assert.assertEquals(FullSearch.extractNumber(tasks), expected);
    }
}