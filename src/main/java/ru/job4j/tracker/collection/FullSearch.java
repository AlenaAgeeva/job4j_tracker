package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<TaskCollection> list) {
        HashSet<String> numbers = new HashSet<>();
        for (TaskCollection t : list) {
            numbers.add(t.getNumber());
        }
        return numbers;
    }
}
