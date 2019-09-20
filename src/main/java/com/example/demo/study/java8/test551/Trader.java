package com.example.demo.study.java8.test551;

//交易类
public class Trader {
	private final String name;
	private final String city;
	
	public Trader(String n,String c) {
		this.name=n;
		this.city=c;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + ", getName()=" + getName() + ", getCity()=" + getCity()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
