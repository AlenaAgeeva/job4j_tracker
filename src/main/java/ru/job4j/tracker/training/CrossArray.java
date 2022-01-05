package ru.job4j.tracker.training;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents an algorithm that accepts two int type arrays
 * and outputs to the console duplicate values
 *
 * @author Alena Ageeva
 * @version 1.0
 */

public class CrossArray {
    /**
     * Method contains logic for getting repetitions of arrays values
     * It works only with int type arrays
     *
     * @param left  int array
     * @param right int array
     */
    public static void printCrossEl(int[] left, int[] right) {
        List<Integer> list = IntStream.of(left)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> list1 = IntStream.of(right)
                .boxed()
                .collect(Collectors.toList());
        list1.retainAll(list);
        list1.forEach(System.out::println);
    }
}
