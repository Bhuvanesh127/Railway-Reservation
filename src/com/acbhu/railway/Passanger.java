package com.acbhu.railway;

public class Passanger {
	
	private int ID;
	private String name;
	private int age;
	private String birthPreference;
	private static int count = 0;
	
	
	public Passanger(String name, int age, String birthPreference) {
		super();
		this.ID = ++count;
		this.name = name;
		this.age = age;
		this.birthPreference = birthPreference;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthPreference() {
		return birthPreference;
	}
	public void setBirthPreference(String birthPreference) {
		this.birthPreference = birthPreference;
	}
	
	

}
