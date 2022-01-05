package ru.job4j.tracker.training;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * This class represents an algorithm that checking if an array is
 * sorted or not sorted
 *
 * @author Alena Ageeva
 * @version 1.0
 */
public class CheckArray {
    /**
     * Method contains an algorithm using Arrays and IntStream methods
     * It is working only with int[] arrays
     *
     * @param array that we must check
     * @return true or false
     */
    public static boolean isSorted(int[] array) {
        return Arrays.compare(array, IntStream.of(array).sorted().toArray()) == 0;
    }
}
