package ru.job4j.tracker.bank;

import java.util.*;

/**
 * Класс представляет собой элементарную модель банковской системы
 *
 * @author Alena Ageeva
 * @version 1.0
 */

public class BankService {
    /**
     * Класс содержит private final поле: HashMap карта из пользователей и аккаунтов
     * У каждого пользователя может быть несколько аккаунтов в системе
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового клиента в базу users
     * Добавление происходит если данного пользователя нет в системе
     *
     * @param user пользователь типа User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из базы users
     *
     * @param user пользователь которого удалят
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * Метод добавляет пользователю аккаунт
     * Если пользователь не найден или пользователь
     * уже имеет данный аккунт, то добавления не происходит
     *
     * @param passport используется для поиска пользователя из базы users
     * @param account  новый счет типа Account
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит возвращает пользователя по паспорту
     * Если пользователь не найден то возвращается null
     *
     * @param passport паспорт клиента
     * @return пользователя типа User
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит и возвращает счет клиента
     * Сначала находим пользователя по паспорту, если клиент есть в базе users
     * то сравнивает реквизиты счетов клиента с аргументом реквизита
     * Если аккаунт с данным реквизитом не найден, то возвращает null
     *
     * @param passport  паспорт клиента
     * @param requisite реквизит счета
     * @return аккаунт типа Account
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод производит перевод денег между аккаунтами
     * Перевод проходит успешно если оба аккаунта существуют в базе users
     * и сумма перевода меньше баланса счета отправителя
     *
     * @param srcPassport   паспорт отправителя
     * @param srcRequisite  реквизиты отправителя
     * @param destPassport  паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount        сумма перевода
     * @return true если перевод выполнен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (!src.isPresent() || !dest.isPresent()
                || src.get().getBalance() < amount) {
            return false;
        }
        src.get().setBalance(src.get().getBalance() - amount);
        dest.get().setBalance(dest.get().getBalance() + amount);
        return true;
    }
}
