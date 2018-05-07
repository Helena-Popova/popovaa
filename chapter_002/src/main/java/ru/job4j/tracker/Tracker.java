package ru.job4j.tracker;
import java.lang.reflect.Array;
import java.util.*;

/**
 *@author Helena
 *@version 1.0
 */
public class Tracker {

	/**
	 * Текущее число заявок
	 */
	private int count = 0;

	/**
	 * Массив для хранения заявок
	 */
	private ArrayList<Item> items = new ArrayList<>();
	private static final Random RM = new Random();

	/**
	 * Довабляет заявку в список.
	 * @param item
	 * @return Item
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
		count++;
		return item;
	}

	/**
	 * Генерирует случайное id для заявки
	 * @return String new id
	 */
	static String generateId() {
		return String.valueOf(System.currentTimeMillis() + RM.nextInt());
	}

	/**
	 * Метод заменяте отдно значение на другое.
	 * @since 24.03.18 // обавлена строка,чтобы id не изменялись.
	 * @param id
	 * @param item
	 */
	public void replace(String id, Item item) {
		for (Item task : items) {
			if (task.compareId(id)) {
				this.items.set(this.items.indexOf(task), item);
				break;
			}
		}
	}

	/**
	 * Метод удаляет найденное по id значение из списка.
	 * @param id
	 */
	public void delete(String id) {
		for (Item task : items) {
			if (task.compareId(id)) {
				this.items.remove(task);
				count--;
				break;
			}
		}
	}

	/**
	 * Возвращает все ненулевые элементы списка.
	 * @return список Item[]
	 */
	public ArrayList<Item> findAll() {
		ArrayList<Item> itemsCopy = new ArrayList<>();
		for (Item item : items) {
			if (item.getCreated() != 0 && !(item.getDescription().equals(""))) {
				itemsCopy.add(item);
			}
		}
		return itemsCopy;
	}

	/**
	 * Находит все эелементы в списке по ключю, вовращает массивом.
	 * @since 24.03.18 довалено условие,что если ничего не найденно,то возвращает нулевой элемент.
	 * @param key
	 * @return найденные занчения.
	 */
	public ArrayList<Item> findByName(String key) {
		ArrayList<Item> itemsCopy = new ArrayList<>();
		for (Item item : items) {
			if (item.getName().equals(key)) {
				itemsCopy.add(item);
			}
		}
		return itemsCopy;
	}

	/**
	 * Находит первое попавшееся значение по id
	 * @param id
	 * @return Item
	 */
	public Item findById(String id) {
		Item findItem = Item.EMPTY;
		for (Item offer : items) {
			if (offer != null && offer.getId().equals(id)) {
				findItem = offer;
				break;
			}
		}
		return findItem;
	}

	/**
	 * Возвращает все значения списка
	 * @return Item[]
	 */
	public ArrayList<Item> getAll() {
		return this.items;
	}

	/**
	 * Возвращает колличество элементов в списке
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