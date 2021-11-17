package ru.job4j.tracker.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println(this.getClass().getName() + " is riding.");
    }

    @Override
    public void passengers(int num) {
        System.out.println("This " + this.getClass().getName() + " has " + num + "passengers.");

    }

    @Override
    public double refuel(int amount) {
        return 15.5 * amount;
    }
}
