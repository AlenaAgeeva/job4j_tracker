package ru.job4j.tracker.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        BiPredicate<Integer, String> biPred = (i, s) -> {
            if (i % 2 == 0 || s.length() == 4) {
                System.out.println("key: " + i + " value: " + s);
                return true;
            }
            return false;
        };
        for (Integer i : map.keySet()) {
            biPred.test(i, map.get(i));
        }
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}