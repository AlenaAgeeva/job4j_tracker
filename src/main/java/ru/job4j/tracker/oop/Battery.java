package ru.job4j.tracker.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery batteryOne = new Battery(140);
        Battery batteryTwo = new Battery(0);
        System.out.println("Battery one load is " + batteryOne.load);
        System.out.println("Battery two load is " + batteryTwo.load);
        batteryOne.exchange(batteryTwo);
        System.out.println("Battery one load is " + batteryOne.load);
        System.out.println("Battery two load is " + batteryTwo.load);
    }
}
