package com.manh.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest 
{
	public static void main(String[] args) 
	{
		Person p1=new Person(1, "Siddhanta");
		Person p2=new Person(2, "Pattnaik");
		List<Person> l1=new ArrayList<>();
		l1.add(p1);
		l1.add(p2);
		 Collections.sort(l1, (Person p3, Person p4) -> p1.getName().compareTo(p2.getName()));
		 Collections.sort(l1, ( p3,  p4) ->  {return p1.getName().compareTo(p2.getName()); } );
		 Collections.sort(l1, ( p3,  p4) ->  { System.out.println(1); return p1.getName().compareTo(p2.getName()); } );
	}
}
