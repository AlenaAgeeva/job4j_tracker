package ru.job4j.tracker.bank;

import java.util.Objects;

/**
 * Класс представляет модель банковского счета пользователя
 *
 * @author Alena Ageeva
 * @version 1.0
 */
public class Account {
    /**
     * Класс содержит private поля: реквизит аккаунта, баланс счета
     */

    private String requisite;
    private double balance;

    /**
     * Конструктор класса
     * @param requisite реквизит аккаунта
     * @param balance   баланс счета
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения строки реквизита
     * @return реквизит пользователя
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для установки значения строке реквизит
     * @param requisite новое значение
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения числа баланса
     * @return баланс пользователя
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для установки значения баланса
     * @param balance новое значение
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
