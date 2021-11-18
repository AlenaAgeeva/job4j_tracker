package ru.job4j.tracker.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(type() + "передвигается по рельсам");
    }

    @Override
    public String type() {
        return this.getClass().getSimpleName() + " ";
    }
}
