package ru.job4j.tracker.main.action;

import ru.job4j.tracker.main.input.Input;
import ru.job4j.tracker.main.store.Store;

import java.sql.SQLException;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker) throws SQLException;
}
