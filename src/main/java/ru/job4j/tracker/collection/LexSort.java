package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] st1 = left.split("\\.");
        String[] st2 = right.split("\\.");
        return Integer.compare(Integer.parseInt(st1[0]), Integer.parseInt(st2[0]));
    }
}
