package ru.job4j.tracker.inheritance;

public class Doctor extends Profession {
    private int workHours;

    public Doctor(String name, String surname, String education, int birthday, int workHours) {
        super(name, surname, education, birthday);
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public static void patientsToday() {
        System.out.println("Today I have " + (int) (Math.random() * 50) + " patients.");
    }
}
