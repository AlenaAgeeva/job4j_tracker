package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }
}