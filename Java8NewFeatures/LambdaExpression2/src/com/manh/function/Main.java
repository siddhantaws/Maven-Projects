package com.manh.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.manh.predicates.Person;

public class Main 
{
	public static void main(String[] args) 
	{
		Person[] personArray = { new Person("Jong", 5), new Person("Jon", 12),
                new Person("Jon", 17), new Person("Mary", 13) };
		List<Person> l=Arrays.asList(personArray);
		Function<Person, Person> f1=person->{ person.setAge(30); return person ;};
		convert(l , f1);
		for(Person p:l)
		{
			System.out.println(p);
		}
	}
	
	public static <T,R> void convert(List<T> list,Function<T, R> f1)
	{
		for(T t:list)
		{
			f1.apply(t);
		}
	}
}
