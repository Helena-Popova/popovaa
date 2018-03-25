package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int count = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[count++];
    }
}
