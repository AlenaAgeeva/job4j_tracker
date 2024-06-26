package ru.job4j.tracker.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertEquals(result.getDesc(), "urgent");
    }

    @Test
    public void whenLowerPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent middle", 2));
        queue.put(new Task("low middle", 4));
        var result = queue.getTasks().getLast();
        assertEquals(result.getDesc(), "low");
    }
}