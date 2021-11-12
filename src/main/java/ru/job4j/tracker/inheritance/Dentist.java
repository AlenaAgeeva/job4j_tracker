package ru.job4j.tracker.inheritance;

public class Dentist extends Doctor {
    private Cleaning cleaning;

    public Dentist(String name, String surname, String edu, int birth, int work, Cleaning clean) {
        super(name, surname, edu, birth, work);
        this.cleaning = clean;
    }

    public void makeCleaning() {
        cleaning.cleanTeethOrNot();
    }
}
