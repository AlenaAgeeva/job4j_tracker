package ru.job4j.tracker.oop;

public class VehicleType {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Plain();
        Vehicle vehicle2 = new Train();
        Vehicle vehicle3 = new Bus();
        Vehicle[] v = {vehicle1, vehicle2, vehicle3};
        for (Vehicle c : v) {
            c.move();
        }
    }
}
