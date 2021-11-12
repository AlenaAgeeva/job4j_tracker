package ru.job4j.tracker.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student s = new Student();
        s.setDate(new Date());
        s.setFullName("A.A.P");
        s.setGroup(7);
        System.out.printf("date: %s", s.getDate());
        System.out.printf("\nname: %s", s.getFullName());
        System.out.printf("\ngroup: %d", s.getGroup());
    }
}
