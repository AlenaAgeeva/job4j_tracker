package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                itemsWithoutNull[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] keyNames = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                keyNames[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(keyNames, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        items[index] = item;
        items[index].setId(id);
        return items[index].equals(item);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}