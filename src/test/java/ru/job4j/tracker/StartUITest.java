package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.main.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;

public class StartUITest {

    @Test
    public void whenCreateItem() throws SQLException {
        Input in = new StubInput(new ArrayList<>(List.of("0", "Item name", "1")));
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new CreateAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        Assert.assertEquals(tracker.findAll().get(0).getName(), "Item name");
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(item.getId()), replacedName, "1")));
        List<UserAction> actions = new ArrayList<>(List.of(new ReplaceItemAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        Assert.assertEquals(tracker.findById(item.getId()).getName(), replacedName);
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(item.getId()), "1")));
        List<UserAction> actions = new ArrayList<>(List.of(new DeleteItemAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(List.of("0")));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(List.of(new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        Assert.assertEquals(out.toString(),
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(one.getId()), replaceName, "1")));
        List<UserAction> actions = new ArrayList<>(List.of(new ReplaceItemAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(out.toString(),
                "Menu." + ln
                        + "0. === Edit item ===" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. === Edit item ===" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindAllItemsTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new ArrayList<>(List.of("0", "1")));
        List<UserAction> actions = new ArrayList<>(List.of(new ShowAllAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(out.toString(),
                "Menu." + ln
                        + "0. === Show all items ===" + ln
                        + "1. Exit" + ln
                        + "==== Show all items ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. === Show all items ===" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String findName = "test1";
        Input in = new StubInput(new ArrayList<>(List.of("0", findName, "1")));
        List<UserAction> actions = new ArrayList<>(List.of(new FindItemsByNamesAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(out.toString(),
                "Menu." + ln
                        + "0. === Find items by name ===" + ln
                        + "1. Exit" + ln
                        + "==== Find items by name ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. === Find items by name ===" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new ArrayList<>(List.of("0", String.valueOf(one.getId()), "1")));
        List<UserAction> actions = new ArrayList<>(List.of(new FindItembyIdAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(out.toString(),
                "Menu." + ln
                        + "0. === Find item by id ===" + ln
                        + "1. Exit" + ln
                        + "==== Find item by id ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. === Find item by id ===" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(List.of("-1", "0")));
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(List.of(new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        Assert.assertEquals(out.toString(),
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                        + "=== Exit Program ===" + ln

        );
    }
}