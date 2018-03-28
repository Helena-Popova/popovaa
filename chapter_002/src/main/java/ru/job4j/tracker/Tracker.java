package ru.job4j.tracker;
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
	private Item[] items = new Item[100];
	private static final Random RM = new Random();

	/**
	 * Довабляет заявку в список.
	 * @param item
	 * @return Item
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		items[count++] = item;
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
		for (int i = 0; i < count; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = item;
				this.items[i].setId(id);
			}
		}
	}

	/**
	 * Метод удаляет найденное по id значение из списка.
	 * @param id
	 */
	public void delete(String id) {
		for (int i = 0; i < count; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = Item.EMPTY;
				System.arraycopy(this.items, i + 1, this.items, i, count - i - 1);
				this.items[count - 1] = Item.EMPTY;
				count--;
			}
		}
	}

	/**
	 * Возвращает все ненулевые элементы списка.
	 * @return список Item[]
	 */
	public Item[] findAll() {
		Item[] itemsCopy = Arrays.copyOf(this.items, count);
		int index = count;
		int cCopy = 0;
		for (int i = 0; i < index; i++) {
			if (itemsCopy[i].getCreated() != 0 && !(itemsCopy[i].getDescription().equals(""))) {
				System.arraycopy(itemsCopy, i, itemsCopy, cCopy++, 1);
			}
		}
		return Arrays.copyOf(itemsCopy, cCopy);
	}

	/**
	 * Находит все эелементы в списке по ключю, вовращает массивом.
	 * @since 24.03.18 довалено условие,что если ничего не найденно,то возвращает нулевой элемент.
	 * @param key
	 * @return найденные занчения.
	 */
	public Item[] findByName(String key) {
		Item[] itemsCopy = new Item[100];
		itemsCopy[0]  = Item.EMPTY;
		int cCopy = 0;
		for (int i = 0; i < count; i++) {
			if (this.items[i].getName().equals(key)) {
				System.arraycopy(this.items, i, itemsCopy, cCopy++, 1);
			}
		}
		return cCopy > 0 ? Arrays.copyOf(itemsCopy, cCopy) : Arrays.copyOf(itemsCopy, 1);
	}

	/**
	 * Находит первое попавшееся значение по id
	 * @param id
	 * @return Item
	 */
	protected Item findById(String id) {
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
	public Item[] getAll() {
		return Arrays.copyOf(this.items, count);
	}

	/**
	 * Возвращает колличество элементов в списке
	 * @return int Count
	 */
	public int getCount() {
		return this.count;
	}
}