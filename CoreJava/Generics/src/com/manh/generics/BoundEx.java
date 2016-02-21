package com.manh.generics;

public class BoundEx<T extends A> 
{
	private T objRef;
	
	public BoundEx(T obj)
	{
        this.objRef = obj;
    }
	
	public void doRunTest()
	{
        this.objRef.printClass();
    }
}

class A{
    public void printClass(){
        System.out.println("I am in super class A");
    }
}
 
class B extends A{
    public void printClass(){
        System.out.println("I am in sub class B");
    }
}
 
class C extends A{
    public void printClass(){
        System.out.println("I am in sub class C");
    }
}
class D extends B{
    public void printClass(){
        System.out.println("I am in super class A");
    }
}
 