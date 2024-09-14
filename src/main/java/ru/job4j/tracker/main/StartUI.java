package ru.job4j.tracker.main;

import ru.job4j.tracker.main.action.*;
import ru.job4j.tracker.main.input.ConsoleInput;
import ru.job4j.tracker.main.input.Input;
import ru.job4j.tracker.main.input.ValidateInput;
import ru.job4j.tracker.main.output.ConsoleOutput;
import ru.job4j.tracker.main.output.Output;
import ru.job4j.tracker.main.store.Store;
import ru.job4j.tracker.main.tracker.SqlTracker;

import java.sql.SQLException;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        /*MemTracker tracker = new MemTracker();*/
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new Create(output),
                    new CreateManyItems(output),
                    new ReplaceItem(output),
                    new DeleteItem(output),
                    new DeleteManyItems(output),
                    new ShowAll(output),
                    new FindItemById(output),
                    new FindItemsByNames(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}