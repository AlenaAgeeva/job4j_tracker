package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.main.*;

import java.util.ArrayList;
import java.util.List;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(List.of("one", "1")));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assert.assertEquals(selected, 1);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(List.of("-1")));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assert.assertEquals(selected, -1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(List.of("5")));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        Assert.assertEquals(selected, 5);
    }

    @Test
    public void whenSeveralValidInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(new ArrayList<>(List.of("5", "2", "3")));
        ValidateInput input = new ValidateInput(out, in);
        int selected1 = input.askInt("Enter menu:");
        Assert.assertEquals(selected1, 5);
        int selected2 = input.askInt("Enter menu:");
        Assert.assertEquals(selected2, 2);
        int selected3 = input.askInt("Enter menu:");
        Assert.assertEquals(selected3, 3);
    }
}