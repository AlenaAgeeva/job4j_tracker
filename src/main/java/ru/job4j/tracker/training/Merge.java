package ru.job4j.tracker.training;

import java.util.stream.IntStream;

/**
 * This class represents a simple model of merging two sorted arrays into one
 *
 * @author Alena Ageeva
 * @version 1.0
 */
public class Merge {
    /**
     * Method of sorting and merging two arrays
     *
     * @param left  first array
     * @param right second array
     * @return new array with results
     */
    public static int[] merge(int[] left, int[] right) {
        return IntStream.concat(IntStream.of(left), IntStream.of(right))
                .sorted()
                .toArray();
    }
}
