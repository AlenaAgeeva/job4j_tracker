package ru.job4j.tracker.main.action;

import ru.job4j.tracker.main.input.Input;
import ru.job4j.tracker.main.output.Output;
import ru.job4j.tracker.main.store.Store;
import ru.job4j.tracker.main.model.Item;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
