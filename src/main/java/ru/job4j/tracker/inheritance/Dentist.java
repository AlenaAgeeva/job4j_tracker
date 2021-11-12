package ru.job4j.tracker.inheritance;

public class Dentist extends Doctor {
    private Cleaning cleaning;

    public Dentist(String name, String surname, String education, int birthday, int workHours, Cleaning cleaning) {
        super(name, surname, education, birthday, workHours);
        this.cleaning = cleaning;
    }

    public void makeCleaning() {
        cleaning.cleanTeethOrNot();
    }
}
