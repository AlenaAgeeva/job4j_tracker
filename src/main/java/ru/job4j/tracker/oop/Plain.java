package ru.job4j.tracker.oop;

public class Plain implements Vehicle {

    @Override
    public void move() {
        System.out.println(type() + "летает по воздуху");
    }

    @Override
    public String type() {
        return this.getClass().getSimpleName() + " ";
    }
}
