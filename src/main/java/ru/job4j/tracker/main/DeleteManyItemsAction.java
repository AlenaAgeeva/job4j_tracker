package ru.job4j.tracker.main;

public class DeleteManyItemsAction implements UserAction {
    private final Output out;

    public DeleteManyItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete all items ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete all Items ===");
        return tracker.deleteAll();
    }
}
