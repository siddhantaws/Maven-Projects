package com.manh.lambda.sort;

public class Person {
	private String name;
	private int age;

	public Person (String name, int age){
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

	// Existing static method - can be used in method reference
	public static int compareByName_StaticMethod(Person a, Person b) {
		return a.name.compareTo(b.name);
	}

}