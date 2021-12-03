package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Assert.assertEquals(office.get(citizen.getPassport()), citizen);
        Assert.assertEquals(office.getSize(), 1);
    }

    @Test
    public void addDuplicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("2f44a", "Petr Ar");
        Citizen citizen2 = new Citizen("2f44a", "Artem A");
        Citizen citizen3 = new Citizen("2f44a", "Igor I");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        office.add(citizen2);
        office.add(citizen1);
        office.add(citizen3);
        Assert.assertFalse(office.add(citizen1));
        Assert.assertEquals(office.getSize(), 1);
    }
}