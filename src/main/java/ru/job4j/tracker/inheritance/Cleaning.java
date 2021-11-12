package ru.job4j.tracker.inheritance;

public class Cleaning {
    private boolean teethCleaning;

    public Cleaning(boolean teethCleaning) {
        this.teethCleaning = teethCleaning;
    }

    public void cleanTeethOrNot() {
        if (teethCleaning) {
            cleanTeeth();
        } else {
            notCleanTeeth();
        }
    }

    public void cleanTeeth() {
        System.out.println("Patient need cleaning");
    }

    public void notCleanTeeth() {
        System.out.println("Patient does not need cleaning");
    }
}
