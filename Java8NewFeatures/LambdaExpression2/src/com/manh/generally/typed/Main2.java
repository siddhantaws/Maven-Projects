package com.manh.generally.typed;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main2 
{
	public static void main(String[] args) 
	{
		Consumer<String> c1=x->System.out.println(x);
		consume(c1, "Siddhanta");
		
		BiConsumer<String, Integer> bc2=(x,y)->System.out.println("Name is "+x +" age is "+y);
		consume(bc2 , "Siddhanta", 25);
	} 
	public static <T> void consume(Consumer<T> c1, T x)
	{
		c1.accept(x);
	}
	
	public static <T,U>void consume(BiConsumer<T, U> b1,T t,U u)
	{
		b1.accept(t, u);
	}
	
}
