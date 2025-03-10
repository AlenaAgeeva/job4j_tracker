package ru.job4j.tracker.main.action;

import ru.job4j.tracker.main.input.Input;
import ru.job4j.tracker.main.model.Item;
import ru.job4j.tracker.main.output.Output;
import ru.job4j.tracker.main.store.Store;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Add new Item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}