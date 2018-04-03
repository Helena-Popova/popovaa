package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];
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
        this.actions[position++] = new AddItem(" Add the new item.", 0);
        this.actions[position++] = new ShowItem(" Show all items", 1);
        this.actions[position++] = new EditItem(" Edit item", 2);
        this.actions[position++] = new DeleteItem(" Delete the item by id.", 3);
        this.actions[position++] = new FindItemById(" Find item by id.", 4);
        this.actions[position++] = new FindItemsByName(" Find item by name.", 5);
    }

    public int[] getRange() {
        int[] range = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            range[i] = i;
            }
        return range;
    }

    /**
     * Добавляет действие
     * @param action какое-то действие
     */
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    /**
     * выбор действия по введеному ключу
     * @param key ключ к действию
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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
            super(info,key);

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
            super(info,key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int count = 1;
            Item[] items = tracker.getAll();
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
            super(info,key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task id which you want to replace : ");
            if (tracker.findById(id) != null) {
                String name = input.ask("Please, enter  the new task name : ");
                String desc = input.ask("Please, enter  the new description : ");
                Item item = new Item(name, desc);
                item.setId(id);
                tracker.replace(id, item);
                System.out.println("Item replaced");
            } else {
                System.out.println(" Sorry,such a item is not existed");
            }
        }
    }


    private static class DeleteItem extends BaseAction{

        private DeleteItem(String info, int key) {
            super(info,key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter  the id Item those you want delete : ");
            if (tracker.findById(id) != null) {
                tracker.delete(id);
                System.out.println("Item deleted");
            } else {
                System.out.println("Such a item is not existed with this id");
            }
        }
    }

    class FindItemById extends BaseAction {

        private FindItemById(String info, int key) {
            super(info,key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter  the id Item those you want find : ");
            if (tracker.findById(id) != null) {
                Item temp = tracker.findById(id);
                System.out.println("id : " + temp.getId() + " Name : " + temp.getName() + " Description: "+ temp.getDescription());
            } else {
                System.out.println("Заявки нет, к сожалению");
            }
        }
    }


    private static class FindItemsByName extends BaseAction{

        private FindItemsByName(String info, int key) {
            super(info,key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter  the name Item those you want find : ");
            if (tracker.findByName(name)[0].getId() != null) {
                System.out.println("I find! : ");
                for (Item task : tracker.findByName(name)) {
                    System.out.println("id : " + task.getId() + " Name : " + task.getName() + " Description: "+ task.getDescription());
                }
            } else {
                System.out.println("I don't find");
            }
        }
    }
}