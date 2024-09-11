package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.main.model.Item;
import ru.job4j.tracker.main.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenAddItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertEquals(tracker.findById(item.getId()), item);
    }

    @Test
    public void whenReplaceItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = tracker.add(new Item("item1"));
        Item itemTwo = new Item("item2");
        tracker.replace(itemOne.getId(), itemTwo);
        itemTwo.setId(itemOne.getId());
        assertEquals(tracker.findById(itemOne.getId()), itemTwo);
        assertEquals(tracker.findById(itemOne.getId()).getName(), "item2");
    }

    @Test
    public void whenSaveItemAndDeleteThenNullValue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = tracker.add(new Item("item1"));
        tracker.delete(itemOne.getId());
        assertEquals(tracker.findById(itemOne.getId()), null);
    }

    @Test
    public void whenFindAllItemsMustBeEqualsCount() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = List.of(tracker.add(new Item("item1")),
                tracker.add(new Item("item2")),
                tracker.add(new Item("item3")),
                tracker.add(new Item("item4")));
        assertEquals(tracker.findAll().size(), list.size());
    }

    @Test
    public void whenAddItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = tracker.add(new Item("item1"));
        Item itemTwo = tracker.add(new Item("item2"));
        Item itemThree = tracker.add(new Item("item3"));
        assertEquals(tracker.findByName(itemOne.getName()), List.of(itemOne));
    }

    @Test
    public void whenRemoveItemThenDb() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = tracker.add(new Item("item1"));
        Item itemTwo = tracker.add(new Item("item2"));
        Item itemThree = tracker.add(new Item("item3"));
        tracker.delete(itemOne.getId());
        assertEquals(tracker.findAll(), List.of(itemTwo, itemThree));
    }
}
