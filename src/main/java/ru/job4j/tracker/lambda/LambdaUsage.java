package ru.job4j.tracker.lambda;

import java.util.Arrays;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] str = {
                "AAAAA",
                "A",
                "AAA",
                "AA"
        };
        Arrays.sort(str, (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        });
        for (String s : str) {
            System.out.println(s);
        }
    }
}
