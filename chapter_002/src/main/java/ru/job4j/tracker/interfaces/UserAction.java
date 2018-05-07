package ru.job4j.tracker.interfaces;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfaces.Input;

public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
