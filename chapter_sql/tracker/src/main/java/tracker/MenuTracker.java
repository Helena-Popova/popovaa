package tracker;



import tracker.interfaces.Input;
import tracker.interfaces.UserAction;

import java.util.ArrayList;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();
    private int position = 0;

    /**
     * Конструктор
     * @param input реализация интерфейса опроса
     * @param tracker хранилище заявок
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Инициализирует все дейстия пользователя
     */
    public void fillAction() {
        this.actions.add(new AddItem(" Add the new item.", 0));
        this.actions.add(new ShowItem(" Show all items", 1));
        this.actions.add(new EditItem(" Edit item", 2));
        this.actions.add(new DeleteItem(" Delete the item by id.", 3));
        this.actions.add(new FindItemById(" Find item by id.", 4));
        this.actions.add(new FindItemsByName(" Find item by name.", 5));
    }

    public ArrayList<Integer> getRange() {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            range.add(i);
            }
        return range;
    }

    /**
     * Добавляет действие
     * @param action какое-то действие
     */
    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    /**
     * выбор действия по введеному ключу
     * @param key ключ к действию
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * вывод меню
     */
    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Добавить заявку
     */
    class AddItem extends BaseAction {

        private AddItem(String info, int key) {
            super(info, key);

        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter  the task name : ");
            String desc = input.ask("Please, enter  the description :  ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Новая заявка с id: " + item.getId() + " создана");
        }
    }

    private static  class ShowItem extends BaseAction {
        private ShowItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int count = 1;
            ArrayList<Item> items = tracker.findAll();
            System.out.println("Все сущестующие заявки :");

            for (Item i : items) {
                System.out.println(count + " : Заявка с id: " + i.getId() + " именем : " + i.getName() + " и описанием: " + i.getDescription() + "\n");
                count++;
            }
            if (count == 1) {
                System.out.println(" Заявок пока нет ");
            }
        }
    }

    class EditItem extends BaseAction {

        private EditItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task id which you want to replace : ");
            if (!tracker.findById(Integer.parseInt(id)).equals(Item.EMPTY)) {
                String name = input.ask("Please, enter  the new task name : ");
                String desc = input.ask("Please, enter  the new description : ");
                Item item = new Item(name, desc);
                tracker.replace(Integer.parseInt(id), item);
                System.out.println("Item replaced");
            } else {
                System.out.println(" Sorry,such a item is not existed");
            }
        }
    }


    private static class DeleteItem extends BaseAction {

        private DeleteItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter  the id Item those you want delete : ");
            if (!tracker.findById(Integer.parseInt(id)).equals(Item.EMPTY)) {
                tracker.delete(Integer.parseInt(id));
                System.out.println("Item deleted");
            } else {
                System.out.println("Such a item is not existed with this id");
            }
        }
    }

    class FindItemById extends BaseAction {

        private FindItemById(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter  the id Item those you want find : ");
            if (!tracker.findById(Integer.parseInt(id)).equals(Item.EMPTY)) {
                Item temp = tracker.findById(Integer.parseInt(id));
                System.out.println("id : " + temp.getId() + " Name : " + temp.getName() + " Description: " + temp.getDescription());
            } else {
                System.out.println("Заявки нет, к сожалению");
            }
        }
    }


    private static class FindItemsByName extends BaseAction {

        private FindItemsByName(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter  the name Item those you want find : ");
            if (tracker.findByName(name).size() != 0) {
                System.out.println("I find! : ");
                for (Item task : tracker.findByName(name)) {
                    System.out.println("id : " + task.getId() + " Name : " + task.getName() + " Description: " + task.getDescription());
                }
            } else {
                System.out.println("I don't find");
            }
        }
    }
}