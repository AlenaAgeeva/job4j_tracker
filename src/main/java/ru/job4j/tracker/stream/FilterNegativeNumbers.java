package ru.job4j.tracker.stream;

import java.util.*;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 70, 56, -3, -45, 37, -40);
        List<Integer> positive = numbers.stream().filter(x -> x > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
