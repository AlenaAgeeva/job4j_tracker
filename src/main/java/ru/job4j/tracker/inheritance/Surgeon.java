package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private final Anestezi anst;

    public Surgeon(String name, String surname, String education, int birthday, int workHours, Anestezi anst) {
        super(name, surname, education, birthday, workHours);
        this.anst = anst;
    }

    public void operation() {
        anst.anesteziGame(anst.isAnestetic());
    }
}
