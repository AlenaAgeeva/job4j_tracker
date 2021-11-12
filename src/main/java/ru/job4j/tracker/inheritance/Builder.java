package ru.job4j.tracker.inheritance;

public class Builder extends Engineer {
    private int experience;

    public Builder(String name, String surname, String edu, int birth, String work, int exp) {
        super(name, surname, edu, birth, work);
        this.experience = exp;
    }

    public int getExperience() {
        return experience;
    }

    public String workExperience() {
        return "My work experience is more than " + getExperience() + " years";
    }
}
