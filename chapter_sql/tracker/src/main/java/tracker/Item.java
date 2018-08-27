package tracker;

import java.util.ArrayList;
import java.util.Objects;

/**
* Класс реализации описания заявки
*@author Helena
*@sinse 1.0 20/03/18
*/
public class Item {
	
	private int id;
	private String name;
	private String desc;
	private long created;
	private ArrayList<String> comments;
	
	public static final Item EMPTY = new Item();
	
	public Item() {
		this.name = "";
		this.desc = "";
		this.created = 0;
	}

	public Item(String name, String desc) {
		this.name = name;
		this.desc = desc;
		this.created = 0;
	}

	public Item(String name, String desc, long created) {
		this.name = name;
		this.desc = desc;
		this.created = created;
	}

	public Item(int id, String name, String desc, long created) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.created = created;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setDescription(String aDesc) {
		this.desc = aDesc;
	}
	
	public void setComments(ArrayList<String> aComments) {
		this.comments.addAll(aComments);
	}

	public void setCreated(long aCreated) {
		this.created = aCreated;
	}

	public String getName() {
		return this.name;
	}
	
	
	public String getDescription() {
		return this.desc;
	}
	
	public ArrayList<String> getComments() {
		return this.comments;
	}

	public long getCreated() {
		return this.created;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
		}
        if (o == null || getClass() != o.getClass()) {
        	return false;
		}
        Item item = (Item) o;
        return created == item.created
				&& Objects.equals(name, item.name)
				&& Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, created);
    }
}