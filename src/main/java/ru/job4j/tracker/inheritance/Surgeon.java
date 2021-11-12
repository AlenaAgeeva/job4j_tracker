package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private final Anestezi anst;

    public Surgeon(String name, String surname, String edu, int birth, int work, Anestezi anst) {
        super(name, surname, edu, birth, work);
        this.anst = anst;
    }

    public void operation() {
        anst.anesteziGame(anst.isAnestetic());
    }
}
