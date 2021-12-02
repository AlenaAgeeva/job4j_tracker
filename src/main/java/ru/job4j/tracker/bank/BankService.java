package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void removeUser(User user) {
        if (users.containsKey(user)) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            System.out.println("User was not found by passport");
            return;
        }
        for (Map.Entry<User, List<Account>> map : users.entrySet()) {
            if (map.getKey().equals(user)) {
                for (Account a : map.getValue()) {
                    if (a.equals(account)) {
                        return;
                    }
                }
                map.getValue().add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (user == null) {
            System.out.println("User was not found by passport");
            return account;
        }
        for (Map.Entry<User, List<Account>> map : users.entrySet()) {
            if (map.getKey().equals(user)) {
                for (Account a : map.getValue()) {
                    if (a.getRequisite().equals(requisite)) {
                        account = a;
                    }
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src == null || dest == null
                || src.getBalance() < amount) {
            return false;
        }
        src.setBalance(src.getBalance() - amount);
        dest.setBalance(dest.getBalance() + amount);
        return true;
    }
}
