package ru.firstproject.model;


public class User {

	private long id;

	private String name;

	private String password;

	public User(long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User(String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User() {}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return  "id = " + id + "\nname = " + name + "\npassword = " + password + "\n";
	}
}
