package com.manh.lambda.sort;

import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		
		Person[] personArray = {new Person("Sang", 11), 
				                    new Person("Jon", 12), 
				                    new Person("Mary", 13)};

		// Use lambda expression - provide the logic directly
		Arrays.sort(personArray,
		    (Person a, Person b) -> {
		        return a.getName().compareTo(b.getName());
		    }
		);
		
	  // Use lambda expression - existing static method of Person class
		Arrays.sort(personArray,
		    (a, b) -> Person.compareByName_StaticMethod(a, b)
		);
		
	  // Use method reference - existing static method of Person class
		Arrays.sort(personArray, Person::compareByName_StaticMethod);
		displayPeople(personArray);

	}
	
	public static void displayPeople(Person[] people){
		System.out.println("---- displayPeople");
		for (Person person: people){
			System.out.println(person.getName());
		}
	}
	
}

