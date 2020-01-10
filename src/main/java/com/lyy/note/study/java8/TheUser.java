package com.lyy.note.study.java8;

/***
 * 
 */
public class TheUser {
	private String name;
	private int  age;
	public enum sex{MAN,WOMAN}

	public TheUser(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "TheUser [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
