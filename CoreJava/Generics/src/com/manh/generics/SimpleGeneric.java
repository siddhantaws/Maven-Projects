package com.manh.generics;

public class SimpleGeneric<T>
{
	//declaration of object type T
    private T obj;

	public SimpleGeneric(T obj) 
	{
		super();
		this.obj = obj;
	}

	public T getObj()
	{
		return obj;
	}

	public void setObj(T obj)
	{
		this.obj = obj;
	}
	//this method prints the holding parameter type
    public void printType(){
        System.out.println("Type: "+obj.getClass().getName());
    }

}
