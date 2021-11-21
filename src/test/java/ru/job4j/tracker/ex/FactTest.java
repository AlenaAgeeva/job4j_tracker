package ru.job4j.tracker.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberIsNegative() {
        new Fact().calc(-4);
    }
}