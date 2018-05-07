package ru.job4j.tracker;

import ru.job4j.tracker.exceptions.MenuOutException;
import ru.job4j.tracker.interfaces.Input;

import java.util.ArrayList;

public class StubInput implements Input {
    private final String[] answers;
    private int count = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return this.answers[this.count++];
    }

    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i : range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }

    }
}
