package ru.job4j.tracker.oop;

public class Max {
    public static int max(int one, int two) {
        return one > two ? one : two;
    }

    public static int max(int one, int two, int three) {

        return max(max(one, two), three);
    }

    public static int max(int one, int two, int three, int four) {

        return max(max(one, two, three), four);
    }
}
