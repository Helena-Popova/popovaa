package ru.job4j.tracker;

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

    public int ask(String question, int[] range) {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
