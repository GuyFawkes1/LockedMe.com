package org.lockedme.model;

public class UserFile {
	
	private int id;
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserFile [name=" + name + "]";
	}
	public UserFile(String name) {
		super();
		this.name = name;
	}
	public UserFile() {
		super();
		this.name = name;
	}
	
}
