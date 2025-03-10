package ru.job4j.tracker.main.action;

import ru.job4j.tracker.main.input.Input;
import ru.job4j.tracker.main.output.Output;
import ru.job4j.tracker.main.store.Store;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
