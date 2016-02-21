package com.manh.stream.iteration;

import java.util.ArrayList;
import java.util.List;

public class StreamUpdate 
{
	public static void main(String[] args)
	{
		List<Person> list=new ArrayList<>();
		list.add(new Person(2, "Siddhanta"));
		list.add(new Person(3, "Roahan"));
		list.add(new Person(4, "Pattnaik"));
		list.add(new Person(5, "Shyam"));
		list.stream().filter(person-> person.getId()<5).forEach(person-> person.setId(5));
		for(Person person:list)
		{
			System.out.println(person);
		}
	}
}
