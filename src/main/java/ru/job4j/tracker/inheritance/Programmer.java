package ru.job4j.tracker.inheritance;

public class Programmer extends Engineer {
    private Language language;

    public Programmer(String n, String sName, String edu, int birth, String work, Language lang) {
        super(n, sName, edu, birth, work);
        this.language = lang;
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
