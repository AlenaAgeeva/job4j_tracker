package ru.job4j.tracker.collection;

import java.util.Comparator;

/**
 * Sorter that implements interface Comparator nad hav only one method
 * @author Alena Ageeva
 * @version 1.0
 */

public class DepDescComp implements Comparator<String> {
    /**
     * Method compares two strings
     * Firstly we split two strings and put results in arrays
     * Then we compare if two fist elements are equals
     * If they are equals than use ascending order sort for them
     * Otherwise return a number that greater or less than 0
     * @param o1 first string
     * @param o2 second string
     * @return result of comparing two strings
     */
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int result = second[0].compareTo(first[0]);
        return result == 0 ? o1.compareTo(o2) : result;
    }
}
