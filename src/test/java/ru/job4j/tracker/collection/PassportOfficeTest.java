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
    }
}