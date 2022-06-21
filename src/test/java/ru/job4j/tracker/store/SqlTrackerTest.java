package ru.job4j.tracker.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
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
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item1");
        Item itemTwo = new Item("item2");
        tracker.add(itemOne);
        tracker.replace(itemOne.getId(), itemTwo);
        itemTwo.setId(itemOne.getId());
        assertThat(tracker.findById(itemOne.getId()), is(itemTwo));
    }

    @Test
    public void whenSaveItemAndDeleteThenNullValue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item1");
        Item itemTwo = new Item("item2");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.delete(itemOne.getId());
        assertThat(tracker.findById(itemOne.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItemsMustBeEqualsCount() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item1");
        Item itemTwo = new Item("item2");
        Item itemThree = new Item("item3");
        Item itemFour = new Item("item4");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        assertThat(tracker.findAll().size(), is(4));
    }

    @Test
    public void whenAddItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()), is(List.of(item)));
    }
}
