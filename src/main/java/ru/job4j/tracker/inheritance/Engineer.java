package ru.job4j.tracker.inheritance;

public class Engineer extends Profession {
    private String workPlace;

    public Engineer(String name, String surname, String education, int birthday, String workPlace) {
        super(name, surname, education, birthday);
        this.workPlace = workPlace;
    }

    public void myJob() {
        System.out.println("My job is " + getClass().getName());
    }

    public String getWorkPlace() {
        return workPlace;
    }
}
