package ru.job4j.tracker.main;

import java.util.List;

public interface Store {
    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    boolean deleteAll();

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);

}
