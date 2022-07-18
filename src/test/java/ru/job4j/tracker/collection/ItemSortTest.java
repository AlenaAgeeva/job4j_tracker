package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.main.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemSortTest {

    @Test
    public void sortDesc() {
        List<Item> list = new ArrayList<>() {
            {
                add(new Item("a"));
                add(new Item("j"));
                add(new Item("c"));
                add(new Item("z"));
            }
        };
        List<Item> expected = new ArrayList<>() {
            {
                add(new Item("z"));
                add(new Item("j"));
                add(new Item("c"));
                add(new Item("a"));
            }
        };
        Collections.sort(list, new ItemDescByName());
        Assert.assertEquals(expected, list);
    }

    @Test
    public void sortAsc() {
        List<Item> list = new ArrayList<>() {
            {
                add(new Item("a"));
                add(new Item("z"));
                add(new Item("c"));
                add(new Item("f"));
            }
        };
        List<Item> expected = new ArrayList<>() {
            {
                add(new Item("a"));
                add(new Item("c"));
                add(new Item("f"));
                add(new Item("z"));
            }
        };
        Collections.sort(list, new ItemAscByName());
        Assert.assertEquals(expected, list);
    }
}