package ru.job4j.tracker.interfaces;
import java.util.*;

public interface Input {
    String ask(String question);

    int ask(String quesion, ArrayList<Integer> range);
}