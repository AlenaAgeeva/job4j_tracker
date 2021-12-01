package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("123", "Petr Arsentev", "Der3432f"),
                new Account("142", "Petr Arsentev", "0000017")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        Assert.assertEquals(NotifyAccount.sent(accounts), expect);
    }

    @Test
    public void sentTwo() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Petr Ar", "eDer3432f"),
                new Account("123", "Petr Arsentev", "e3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("123", "Petr Arsentev", "Der3432f"),
                new Account("147", "Petr Arsentev", "0000017")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("147", "Petr Arsentev", "0000017")
                )
        );
        Assert.assertEquals(NotifyAccount.sent(accounts), expect);
    }
}