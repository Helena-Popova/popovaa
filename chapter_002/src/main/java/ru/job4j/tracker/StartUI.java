package ru.job4j.tracker;
import ru.job4j.tracker.*;

/**
 *{@value #EXIT} // Константа для выхода из цикла.
 *@author Helena
 *@version 1.0
 */
public class StartUI {

    private static final int EXIT = 6;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор без параметров
     */
    public StartUI() {
        this.tracker = new Tracker();
        this.input = new ValidateInput();
    }

    /**
     * Конструктор для класса
     *@param inpuT //ввод данных.
     */
    public StartUI(Input inpuT) {
        this.input = inpuT;
        this.tracker = new Tracker();
    }
    /**
     * Конструктор для класса
     *@param inpuT //ввод данных.
     *@param tracker //хранилище заявок.
     */
    public StartUI(Input inpuT, Tracker tracker) {
        this.input = inpuT;
        this.tracker = tracker;
    }

    /**
     * Главный цикл программы
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillAction();
        UserAction exitAction = new BaseAction(" Exit ", EXIT) {
            @Override
            public void execute(Input input, Tracker tracker) {
                tracker.exit();
            }
        };
        menu.addAction(exitAction);
        do {
            menu.show();
            try {
                menu.select(input.ask("Please, enter the key : ",menu.getRange()));
            } catch (MenuOutException moe) {
                moe.printStackTrace();
            }
            } while (!"y".equals(this.input.ask("Do you want to exit?( Y ) ")));

    }

    /**
     * Запускт программы.
     * @param args входящие параметры консоли
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }

}