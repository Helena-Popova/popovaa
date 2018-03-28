package ru.job4j.tracker;
import ru.job4j.tracker.*;

/**
 * {@value #ADD} // Константа меню для добавления новой заявки.
 * {@value #SHOW} // Константа для вывода всех заявок.
 * {@value #EDIT} // Константа для редактирования заявки.
 * {@value #DELETE} // Константа для удаления заявки
 * {@value #FIND_ID} // Константа для для нахождения заявки по id.
 * {@value #FIND_NAME} // Константа для нахождения заявки по имени.
 * {@value #EDIT} // Константа для выхода из цикла.
 *@author Helena
 *@version 1.0
 */
public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор для класса
     *@param inpuT //ввод данных.
     * @param inpuT
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
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Please, enter the key : "));
            menu.select(key);
            } while (!"Y".equals(this.input.ask("Do you want to exit?( Y ) ")));

    }


    /**
     * Печатает меню
     */
    private void showMenu() {
        System.out.print("\n 0. Add new Item \n"
                + " 1. Show all items \n"
                + " 2. Edit item\n"
                + " 3. Delete item\n"
                + " 4. Find item by Id\n"
                + " 5. Find items by name\n"
                + " 6. Exit Program\n");
    }

    /**
     * Добавляет заявку
     */
    public void createItem() {
        String name = this.input.ask("Ввeдите название заявки: ");
        String description = this.input.ask("Ввeдите описание заявки: ");
        Long created = (long) (Math.random() * 10);
        Item item = new Item(name, description, created);
        this.tracker.add(item);
        System.out.println("Новая заявка с id: " + item.getId() + " создана");
    }

    /**
     * Добавляет заявку
     */
    public void showAllItems() {
        int count = 1;
        Item[] items = this.tracker.getAll();
        System.out.println("Все сущестующие заявки :");

        for (Item i : items) {
            System.out.println(count + " : Заявка с id: " + i.getId() + " именем : " + i.getName() + " и описанием: " + i.getDescription() + "\n");
            count++;
        }
        if (count == 1) {
            System.out.println(" Заявок пока нет ");
        }

    }

    /**
     * Изменяет заявку
     */
    public void editItem() {
        int count = 0;
        String name = this.input.ask("Ввeдите название заявки, которую хотите поменять : ");
        System.out.println("Существуют данные заявки:");
        for (Item i : this.tracker.findByName(name)) {
            if (i != Item.EMPTY) {
                count++;
                System.out.println(count  + " : заявка с id: " + i.getId() + " именем : " + i.getName() + " и описанием: " + i.getDescription() + "\n");
            } else {
                System.out.println("Заявок с таким именем нет");
            }
        }
        if (count > 1) {
            count = Integer.parseInt(this.input.ask("Выберите заявку для замены : "));
        }
        String nameEdit = this.input.ask("Ввeдите новое название : ");
        String descriptionEdit = this.input.ask("Ввeдите новое описание: ");
        Long created = (long) (Math.random() * 10);
        Item item = new Item(nameEdit, descriptionEdit, created);
        this.tracker.replace(this.tracker.findByName(name)[count - 1].getId(), item);
    }

    /**
     * Удаляет заявку
     */
    public void deleteItems() {
        int count = 0;
        Item[] items = this.tracker.getAll();
        System.out.println("Все сущестующие заявки :");
        for (Item i : items) {
            count++;
            System.out.println(count + " : заявка с id: " + i.getId() + " именем : " + i.getName() + " и описанием: " + i.getDescription() + "\n");
        }
        if (count > 0) {
            count = Integer.parseInt(this.input.ask("Выберите заявку для удаления : "));
            this.tracker.delete(items[count - 1].getId());
        }

    }

    /**
     * Ищет заявку по id
     */
    public void findItemById() {
        String id = this.input.ask("Введите id для поиска, пожалуйста: ");
        Item i = this.tracker.findById(id);
        if (i != Item.EMPTY) {
            System.out.println(" Найдена заявка с id: " + i.getId() + " именем : " + i.getName() + " и описанием: " + i.getDescription() + "\n");
        } else {
            System.out.println("Заявки нет, к сожалению");
        }
    }

    /**
     * Ищет заявку по имени
     */
    public void findItemByName() {
        String name = this.input.ask("Введите имя для поиска, пожалуйста: ");
        int count = 1;
        for (Item i : this.tracker.findByName(name)) {
            if (this.tracker.findByName(name)[0] != Item.EMPTY) {
                System.out.println("Найдено " + count + " : заявка с id: " + i.getId() + " именем : " + i.getName() + " и описанием: " + i.getDescription() + "\n");
                count++;
            } else {
                System.out.println("Заявок нет, к сожалению");
            }
        }

    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }

}