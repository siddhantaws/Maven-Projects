package com.manh.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main 
{
	public static void main(String[] args) 
	{
		Person[] personArray = { new Person("Jong", 5), new Person("Jon", 12),
                new Person("Jon", 17), new Person("Mary", 13) };
		
        List<Person> people = findPerson(Arrays.asList(personArray), person -> person.getAge()>15 && person.getName().length()<4);
        System.out.println(people);
	}

	public static <E> List<E>  findPerson(List<E> list ,Predicate<E> predicate)  
	{
		List<E> l=new ArrayList<>();
		for(E o:list)
		{
			if(predicate.test(o))
				l.add(o);
		}
		return l;
	}
}
