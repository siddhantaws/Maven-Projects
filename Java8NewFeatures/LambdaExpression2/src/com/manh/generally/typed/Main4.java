package com.manh.generally.typed;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main4 
{
	public static void main(String[] args) 
	{
		Predicate<String> p1=x-> x.length()>10;
		System.out.println(p1.test("Siddhanta"));
		
		BiPredicate<String, String> b1=(x,y)->x.length()+y.length()>20;
		System.out.println(b1.test("Siddhanat", "Pattnaik"));
	}
}
