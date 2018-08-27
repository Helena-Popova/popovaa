package tracker;


import tracker.exceptions.MenuOutException;
import tracker.interfaces.Input;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс реализующий ввод пользователем ответа с консоли
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
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