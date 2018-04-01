package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;

    ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result =  this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                moe.printStackTrace();
                System.out.println("Please, select key from range");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return result;
    }
}