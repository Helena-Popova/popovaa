package ru.job4j.tracker;

/**
* Класс реализации описания заявки
*@author Helena
*@sinse 1.0 20/03/18
*/
public class Item {
	
	private String id;
	private String name;
	private String desc;
	private long created;
	private String[] comments;
	
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
	
	public void setId(String aId) {
		this.id = aId;
	}
	
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setDescription(String aDesc) {
		this.desc = aDesc;
	}
	
	public void setComments(String[] aComments) {
		for (int count = 0; count < aComments.length; count++) {
		this.comments[count] = aComments[count];
		}

	}

	public void setCreated(long aCreated) {
		this.created = aCreated;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public String getDescription() {
		return this.desc;
	}
	
	public String[] getComments() {
		return this.comments;
	}

	public long getCreated() {
		return this.created;
	}

}