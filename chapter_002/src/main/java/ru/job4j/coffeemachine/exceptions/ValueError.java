package ru.job4j.coffeemachine.exceptions;

public class ValueError extends RuntimeException {
    public ValueError(String ve) {
        super(ve);
    }
}
