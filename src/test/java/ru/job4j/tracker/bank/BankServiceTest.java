package ru.job4j.tracker.bank;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankServiceTest {
    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Assert.assertEquals(bank.findByPassport("3434"), user);
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertEquals(bank.findByRequisite("3434", "5546").getBalance(), 150D, 0.001);
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        Assert.assertEquals(bank.findByRequisite(user.getPassport(), "113").getBalance(), 200D, 0.001);
    }

    @Test
    public void add2Accounts() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 150D));
        bank.addAccount(user.getPassport(), new Account("1122", 300D));
        Assert.assertEquals(bank.findByRequisite("3434", "1122").getBalance(), 300D, 0.001);
    }

    @Test
    public void removeUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.removeUser(user);
        Assert.assertNull(bank.findByPassport("3434"));
    }
}