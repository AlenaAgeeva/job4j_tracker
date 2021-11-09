package ru.job4j.tracker.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        this.load += another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery batteryOne = new Battery(60);
        Battery batteryTwo = new Battery(140);
        System.out.println("Battery one load is " + batteryOne.load);
        System.out.println("Battery two load is " + batteryTwo.load);
        batteryTwo.exchange(batteryOne);
        System.out.println("Battery one load is " + batteryOne.load);
        System.out.println("Battery two load is " + batteryTwo.load);
    }
}
