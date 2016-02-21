package com.manh.lambda.sysout;

class Main {

	public static void main(String[] args) {

		Person jon = new Person("Jon", 12);

		// Use lambda expression - existing static method of String class
		displayJon(jon, name -> System.out.println(name));

		// Use method reference - existing static method of String class
		displayJon(jon, System.out::println);

	}

	public static void displayJon(Person jon, MyFunctionalInterface f) {
		f.mySingleAbstractMethod(jon.getName());
	}

}
