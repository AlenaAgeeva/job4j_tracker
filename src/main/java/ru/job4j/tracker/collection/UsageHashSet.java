package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>(List.of("Lada", "BMW", "Volvo", "Toyota"));
        for (String a : autos) {
            System.out.println(a);
        }
    }
}
