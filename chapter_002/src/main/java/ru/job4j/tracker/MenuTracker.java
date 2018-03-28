package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    /**
     * Конструктор
     * @param input
     * @param tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Инициализирует все дейстия пользователя
     */
    public void fillAction() {
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = new MenuTracker.ShowItem();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = new MenuTracker.FindItemsByName();
    }

    /**
     * выбор действия по введеному ключу
     * @param key
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * вывод меню
     */
    public void show() {
        for (UserAction action : actions) {
            if(action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Добавить заявку
     */
    private static class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input,Tracker tracker) {
            String name = input.ask("Please, enter  the task name : ");
            String desc = input.ask("Please, enter  the description :  ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), " Add the new item.");
        }
    }

    /**
     * Показать все заявки
     */
    private static  class ShowItem implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input,Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println("id : " + item.getId() + " Name : " + item.getName() + " Description: "+ item.getDescription());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), " Show all items");
        }
    }

    private static class EditItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input,Tracker tracker) {
            String id = input.ask("Please, enter the task id which you want to replace : ");
            if (!tracker.findById(id).getName().equals("")) {
                String name = input.ask("Please, enter  the new task name : ");
                String desc = input.ask("Please, enter  the new description : ");
                Item item = new Item(name, desc);
                item.setId(id);
                tracker.replace(id, item);
            } else {
                System.out.println(" Sorry,such a item is not existed");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), " Edit item");
        }
    }

    /**
     * удалить заявку по id
     */
    private static class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input,Tracker tracker) {
            String id = input.ask("Please, enter  the id Item those you want delete : ");
            if (tracker.findById(id).getId() != null) {
                tracker.delete(id);
                System.out.println("Item deleted");
            } else {
                System.out.println("Such a item is not existed with this id");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), " Delete the item by id.");
        }
    }

    /**
     * Наяти заявку по id
     */
    private static class FindItemById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input,Tracker tracker) {
            String id = input.ask("Please, enter  the id Item those you want find : ");
            if (tracker.findById(id).getId() != null) {
                Item temp = tracker.findById(id);
                System.out.println("id : " + temp.getId() + " Name : " + temp.getName() + " Description: "+ temp.getDescription());
            } else {
                System.out.println(" items is not existed with this id");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), " Find item by id.");
        }
    }

    /**
     * Наяти заявки по имени
     */
    private static class FindItemsByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input,Tracker tracker) {
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

        public String info() {
            return String.format("%s. %s", this.key(), " Find item by name.");
        }
    }
}