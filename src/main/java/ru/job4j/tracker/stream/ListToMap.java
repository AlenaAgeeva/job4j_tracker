package ru.job4j.tracker.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname, l -> l, (s, a) -> s));
    }
}
