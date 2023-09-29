package ru.job4j.tracker.main;

import java.io.*;
import java.sql.*;
import java.util.*;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("src/main/resources/db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement pr = cn.prepareStatement("insert into items (name,created) values(?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            pr.setString(1, item.getName());
            pr.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pr.execute();
            try (ResultSet generatedKeys = pr.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rlt = false;
        try (PreparedStatement pr = cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            pr.setString(1, item.getName());
            pr.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pr.setInt(3, id);
            rlt = pr.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rlt;
    }

    @Override
    public boolean delete(int id) {
        boolean rlt = false;
        try (PreparedStatement pr = cn.prepareStatement("delete from items where id = ?")) {
            pr.setInt(1, id);
            rlt = pr.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rlt;
    }

    @Override
    public boolean deleteAll() {
        boolean rlt = false;
        try (PreparedStatement pr = cn.prepareStatement("delete * from items")) {
            rlt = pr.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rlt;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pr = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = pr.executeQuery()) {
                while (resultSet.next()) {
                    items.add(getItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pr = cn.prepareStatement("select * from items where name = ?")) {
            pr.setString(1, key);
            try (ResultSet resultSet = pr.executeQuery()) {
                while (resultSet.next()) {
                    items.add(getItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement pr = cn.prepareStatement("select * from items where id = ?")) {
            pr.setInt(1, id);
            try (ResultSet resultSet = pr.executeQuery()) {
                if (resultSet.next()) {
                    item = getItem(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public Item getItem(ResultSet resultSet) {
        Item item = null;
        try {
            item = new Item(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getTimestamp("created").toLocalDateTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
