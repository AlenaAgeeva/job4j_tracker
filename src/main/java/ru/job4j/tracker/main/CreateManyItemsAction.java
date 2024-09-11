package ru.job4j.tracker.main;

import ru.job4j.tracker.main.model.Item;

import java.sql.SQLException;

public class CreateManyItemsAction implements UserAction {
    private final Output out;

    public CreateManyItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Add many new Items ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Create many new Items ===");
        String name = input.askStr("Enter names: ");
        for (int i = 0; i != 500000; i++) {
            Item item = new Item(name);
            tracker.add(item);
        }
        return true;
    }
}
