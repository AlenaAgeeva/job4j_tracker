package ru.job4j.tracker.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
