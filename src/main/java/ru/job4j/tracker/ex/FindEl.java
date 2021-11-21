package ru.job4j.tracker.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("No such element in the array");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"1", "2", "3"}, "2"));
            System.out.println(indexOf(new String[]{"1", "2", "3"}, "7"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
