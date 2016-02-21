package com.manh.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	private String name = "Sang Shin";
	private int age = 77;
	private float height = 1.99f;
	private boolean isProgrammer = true;
	private IAddress address;
	
	public IAddress getAddress() {
		return address;
	}
	@Autowired
	@Qualifier(value="one")
	public void setAddress(IAddress address) {
		this.address = address;
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
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public boolean isProgrammer() {
		return isProgrammer;
	}
	public void setProgrammer(boolean isProgrammer) {
		this.isProgrammer = isProgrammer;
	}

}
