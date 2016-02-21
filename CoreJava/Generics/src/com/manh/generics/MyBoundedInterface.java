package com.manh.generics;

public class MyBoundedInterface 
{
	public static void main(String[] args) 
	{
		BoundExmp<X> bey = new BoundExmp<X>(new Y());
        bey.doRunTest();
        BoundExmp<X> bez = new BoundExmp<X>(new Z());
        bez.doRunTest();
        //If you uncomment below code it will throw compiler error
        //becasue we restricted to only of type X  implementation classes.
        //BoundExmp<String> bes = new BoundExmp<String>(new String());
        //bea.doRunTest();

	}
}
