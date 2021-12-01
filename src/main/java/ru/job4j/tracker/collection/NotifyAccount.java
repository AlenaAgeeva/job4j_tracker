package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account a : accounts) {
            rsl.add(a);
        }
        return rsl;
    }
}
