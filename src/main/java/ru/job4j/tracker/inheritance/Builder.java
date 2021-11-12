package ru.job4j.tracker.inheritance;

public class Builder extends Engineer {
    private int experience;

    public Builder(String name, String surname, String education, int birthday, String workPlace, int experience) {
        super(name, surname, education, birthday, workPlace);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public String workExperience() {
        return "My work experience is more than " + getExperience() + " years";
    }
}
