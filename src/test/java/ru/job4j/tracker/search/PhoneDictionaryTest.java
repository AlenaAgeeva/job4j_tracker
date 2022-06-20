package ru.job4j.tracker.search;

import org.junit.Test;
import ru.job4j.tracker.collection.Person;
import ru.job4j.tracker.collection.PhoneDictionary;

import static org.junit.Assert.assertEquals;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new ru.job4j.tracker.collection.PhoneDictionary();
        phones.add(
                new ru.job4j.tracker.collection.Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    public void whenReturnEmptyList() {
        var phones = new PhoneDictionary();
        phones.add(
                new ru.job4j.tracker.collection.Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Semen", "Semenov", "765872", "Moscow")
        );
        var persons = phones.find("Igor");
        assertEquals(persons.size(), 0);
    }
}