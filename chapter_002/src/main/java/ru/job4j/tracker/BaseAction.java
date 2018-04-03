package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String info;

    protected BaseAction(String info, int key) {
        this.info = info;
        this.key = key;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format(" %s : %s", this.key, this.info);
    }
}