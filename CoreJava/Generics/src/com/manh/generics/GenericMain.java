package com.manh.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMain 
{
	public static void main(String[] args) 
	{
		List<Pet> l=new ArrayList<Pet>();
		l.add(new Pet("Pet"));
		l.add(new BigCat("BigCat"));
		l.add(new BigDog("BigDog"));
		
		List<BigCat> ll=new ArrayList<BigCat>();
		ll.add(new BigCat("BigCat"));
		//ll.add(new BigDog("BigDog"));
		
		List<? super BigCat> ll1=new ArrayList<Cat>();
		ll1.add(new BigCat("BigCat"));
		//ll1.add(new Pet("BigCat"));
		//ll1.add(new Cat("BigCat"));
		
		List<? extends Cat> ll2=new ArrayList<Cat>();
		//ll2.add(new BigCat("BigCat"));
		//ll1.add(new Cat("BigCat"));
		
		List<? super Integer> l1=new ArrayList<Integer>();
		l1.add(10);
		List<? extends Number> l2=new ArrayList<Integer>();
		l2=new ArrayList<Float>();
		
		List<? super Integer> l3=new ArrayList<Integer>();
		l3=new ArrayList<Integer>();
		//l3=new ArrayList<Float>();
		l3=new ArrayList<Number>();
	}
}
