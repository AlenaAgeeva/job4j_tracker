package ru.job4j.tracker.inheritance;

import java.util.Random;

public class Anestezi {
    private boolean anestetic;

    public Anestezi() {
        anestetic = new Random().nextBoolean();
    }

    public void heal() {
        System.out.println("Patient is healed");
    }

    public void anesteziGame(boolean b) {
        if (b) {
            heal();
        } else {
            death();
        }
    }

    public void death() {
        System.out.println("Patient was unable to handle pain shock and now he is dead");
    }

    public boolean isAnestetic() {
        return anestetic;
    }
}
