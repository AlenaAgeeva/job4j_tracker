package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int len = Math.min(o1.length(), o2.length());
        for (int i = 0; i < len; i++) {
            int comp = Character.compare(o1.charAt(i), o2.charAt(i));
            if (comp != 0) {
                return comp;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
