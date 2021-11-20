package ru.job4j.tracker.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(type() + "двигается по скоростным трассам");
    }

    @Override
    public String type() {
        return this.getClass().getSimpleName() + " ";
    }
}
