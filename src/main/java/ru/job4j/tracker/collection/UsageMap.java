package ru.job4j.tracker.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qwerty@gmail.com", "FIO");
        map.put("qwerty1@gmail.com", "1FIO");
        map.put("qwerty2@gmail.com", "2FIO");
        map.put("qwerty3@gmail.com", "3FIO");
        map.put("qwerty4@gmail.com", "4FIO");
        map.put("qwerty4@gmail.com", "4FIO");
        map.put("qwerty4@gmail.com", "4FIO");
        map.put("qwerty4@gmail.com", "4FIO");
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }
}
