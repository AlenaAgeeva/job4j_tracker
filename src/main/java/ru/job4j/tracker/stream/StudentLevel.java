package ru.job4j.tracker.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(x -> x != null)
                .sorted((l, r) -> Integer.compare(r.getScore(), l.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
