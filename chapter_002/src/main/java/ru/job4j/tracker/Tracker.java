package ru.job4j.tracker;
import java.util.*;

public class Tracker extends Item {
	
	private int count = 0;
	private Item[] items = new Item[100];
	private static final Random RM = new Random();
	
	public Item add(Item item) {
		item.setId(this.generateId());
		items[count++] = item;
		return item;
	}
	
	static String generateId() {
		return String.valueOf(System.currentTimeMillis() + RM.nextInt());
	}
	
	
	public void replace(String id, Item item) {
		for (int i = 0; i < count; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = item;
			}
		}
	}
	
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
	
	public Item[] findByName(String key) {
		Item[] itemsCopy = new Item[100];
		int cCopy = 0;
		for (int i = 0; i < count; i++) {
			if (this.items[i].getName().equals(key)) {
				System.arraycopy(this.items, i, itemsCopy, cCopy++, 1);
			}
		}
		return Arrays.copyOf(itemsCopy, cCopy);
	}
	
	protected Item findById(String id) {
		Item findItem = Item.EMPTY; 
		for (Item offer : items) {
			if (offer != Item.EMPTY && offer.getId().equals(id)) {
				findItem = offer;
				break;
			}
		}
		
		return findItem;
	}
	
	public Item[] getAll() {
		return Arrays.copyOf(this.items, count);
	}

	public int getCount() {
		return this.count;
	}
}