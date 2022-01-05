package ru.job4j.tracker.training;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckArrayTest {

    @Test
    public void whenSorted() {
        assertThat(
                CheckArray.isSorted(
                        new int[] {1, 2, 3}
                ),
                is(true)
        );
    }

    @Test
    public void whenNotSorted() {
        assertThat(
                CheckArray.isSorted(
                        new int[] {1, 3, 2}
                ),
                is(false)
        );
    }
}