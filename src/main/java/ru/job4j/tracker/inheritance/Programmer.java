package ru.job4j.tracker.inheritance;

public class Programmer extends Engineer {
    private Language language;

    public Programmer(String name, String surname, String education, int birthday, String workPlace, Language language) {
        super(name, surname, education, birthday, workPlace);
        this.language = language;
    }

    public String changeLanguage(int i) {
        if (i <= Language.values().length) {
            for (Language l : Language.values()) {
                if (l.ordinal() == i) {
                    language = l;
                }
            }
        }
        return "Now I am coding on " + language;
    }

}
