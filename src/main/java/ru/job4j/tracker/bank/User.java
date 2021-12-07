package ru.job4j.tracker.bank;

import java.util.Objects;

/**
 * Класс представляет собой модель пользователя банковского сервиса
 * @author Alena Ageeva
 * @version 1.0
 */
public class User {
    /**
     * Класс содержит private поля: паспорт, имя
     */

    private String passport;
    private String username;

    /**
     * Конструктор класса
     * @param passport паспорт
     * @param username имя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения строки паспорта пользователя
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для установки значения строке паспорт
     * @param passport новое значение
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения строки имени пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для установки значения строке имя
     * @param username новое значение
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
