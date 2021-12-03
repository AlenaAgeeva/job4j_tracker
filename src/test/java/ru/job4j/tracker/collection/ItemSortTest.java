package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemSortTest {

    @Test
    public void sortDesc() {
        List<Item> list = new ArrayList<>() {
            {
                Item item = new Item();
                Item item1 = new Item();
                Item item2 = new Item();
                Item item3 = new Item();
                item.setName("a");
                item1.setName("j");
                item2.setName("c");
                item3.setName("z");
                add(item);
                add(item1);
                add(item2);
                add(item3);
            }
        };
        List<Item> expected = new ArrayList<>() {
            {
                Item item = new Item();
                Item item1 = new Item();
                Item item2 = new Item();
                Item item3 = new Item();
                item.setName("z");
                item1.setName("j");
                item2.setName("c");
                item3.setName("a");
                add(item);
                add(item1);
                add(item2);
                add(item3);
            }
        };
        Collections.sort(list, new ItemDescByName());
        System.out.println(list);
        System.out.println(expected);
        Assert.assertEquals(expected, list);
    }

    @Test
    public void sortAsc() {
        List<Item> list = new ArrayList<>() {
            {
                Item item = new Item();
                Item item1 = new Item();
                Item item2 = new Item();
                Item item3 = new Item();
                item.setName("a");
                item1.setName("z");
                item2.setName("c");
                item3.setName("f");
                add(item);
                add(item1);
                add(item2);
                add(item3);
            }
        };
        List<Item> expected = new ArrayList<>() {
            {
                Item item = new Item();
                Item item1 = new Item();
                Item item2 = new Item();
                Item item3 = new Item();
                item.setName("a");
                item1.setName("c");
                item2.setName("f");
                item3.setName("z");
                add(item);
                add(item1);
                add(item2);
                add(item3);
            }
        };
        Collections.sort(list, new ItemAscByName());
        System.out.println(list);
        System.out.println(expected);
        Assert.assertEquals(expected, list);
    }
}