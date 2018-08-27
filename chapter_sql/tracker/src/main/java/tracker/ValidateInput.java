package tracker;


import tracker.exceptions.MenuOutException;
import tracker.interfaces.Input;

import java.util.ArrayList;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    public int ask(String question, ArrayList<Integer> range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result =  this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from range.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return result;
    }
}