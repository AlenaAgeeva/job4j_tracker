package ru.job4j.tracker.pojo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        Assert.assertEquals(first, second);
    }
}