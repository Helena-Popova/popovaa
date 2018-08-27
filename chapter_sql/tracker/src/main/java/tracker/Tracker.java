package tracker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Helena
 * @version 1.0
 */
public class Tracker {
    private SqlConnection sqlConnection = new SqlConnection();

    /**
     * Текущее число заявок
     */
    private int count = 0;

    /**
     * Довабляет заявку в список.
     *
     * @param item
     * @return Item
     */
    public Item add(Item item) {
        this.sqlConnection.addItem(item);
        count++;
        return item;
    }


    /**
     * Метод заменяте отдно значение на другое.
     *
     * @param id
     * @param item
     * @since 24.03.18 // обавлена строка,чтобы id не изменялись.
     */
    public void replace(int id, Item item) {
        this.sqlConnection.replace(id, item);
    }

    /**
     * Метод удаляет найденное по id значение из списка.
     *
     * @param id
     */
    public void delete(int id) {
        this.sqlConnection.delete(id);
    }

    /**
     * Возвращает все ненулевые элементы списка.
     *
     * @return список Item[]
     */
    public ArrayList<Item> findAll() {
        return this.sqlConnection.findAll();
    }

    /**
     * Находит все эелементы в списке по ключю, вовращает массивом.
     *
     * @param key
     * @return найденные занчения.
     * @since 24.03.18 довалено условие,что если ничего не найденно,то возвращает нулевой элемент.
     */
    public ArrayList<Item> findByName(String key) {
        return this.sqlConnection.findByName(key);
    }

    /**
     * Находит первое попавшееся значение по id
     *
     * @param id
     * @return Item
     */
    public Item findById(int id) {
        return this.sqlConnection.findById(id);
    }


    /**
     * Возвращает колличество элементов в списке
     *
     * @return int Count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Выход из программы
     */
    public void exit() {

        System.out.println("Вы вышли");
        System.exit(0);
    }

}