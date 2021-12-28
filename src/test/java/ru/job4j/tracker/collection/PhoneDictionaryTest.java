package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    public void whenReturnEmptyList() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Semen", "Semenov", "765872", "Moscow")
        );
        var persons = phones.find("Igor");
        assertEquals(persons.size(), 0);
    }
}