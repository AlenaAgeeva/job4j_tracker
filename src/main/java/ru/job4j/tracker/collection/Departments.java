package ru.job4j.tracker.collection;

import java.util.*;

/**
 * Class represents an elementary model of departments catalog
 * @author Alena Ageeva
 * @version 1.0
 */
public class Departments {
    /**
     * Method analyzes and fills up any sector gaps after splitting Strings
     * If we have an object "K1/SK1/SSK1" we will put in a LinkedHashSet "K1", "K1/SK1/", "K1/SK1/SSK1"
     * @param deps source of sectors for splitting
     * @return ArrayList with unique sectors and departments
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = "".equals(start) ? el : start + "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Method represents a sorter with a natural order
     * @param orgs List for sorting
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Method represents a sorter with descending order
     * @param orgs List for sorting
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
