package com.manh.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyWildcardEx 
{
	public static void main(String[] args) 
	{
		CompAEmp  empA=new CompAEmp("Ram", 20000);
		CompBEmp empB= new CompBEmp("Krish", 30000);
		Emp w=new CompBEmp("Nagesh", 20000);
		Set setOfRawType = new HashSet<String>();
		setOfRawType = new HashSet<Integer>();
		Set<Object> setOfAnyType = new HashSet<Object>();
		setOfAnyType.add("abc"); //legal
		setOfAnyType.add(new Float(3.0f));
		Set<?> setOfUnknownType = new LinkedHashSet<String>();
		setOfUnknownType = new LinkedHashSet<Integer>();
		Set<String> setOfString = new HashSet<String>();
		setOfString = new LinkedHashSet<String>();
		
		//Set<Object> SetOfObject = new HashSet<String>();//compiler error - incompatible type
		Set<? extends Number> setOfAllSubTypeOfNumber = new HashSet<Integer>();
		setOfAllSubTypeOfNumber = new HashSet<Float>();
		Set<? super TreeMap> setOfAllSuperTypeOfTreeMap = new LinkedHashSet<TreeMap>();
		setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>();
		setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>();
		Class class1=List.class ;
		//class1=List<String>.class;//illegal
	}
	
}
