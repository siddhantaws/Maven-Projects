package com.manh.exception;

public class Lab2 {
	public static void main(String[] args) 
	{
		//new Lab2().A1(10);
		System.out.println(10/(float)0);
		System.out.println((float)10/0);
		System.out.println(10/0.0);
		System.out.println(10.0/0);
		System.out.println((int)10/0);
	}
	public void A1(Object obj)
	{
		System.out.println("obj");
	}
	public void A1(String a)
	{
		System.out.println("String");
	}
	public void A1(int a)
	{
		System.out.println("int");
	}
	public void A1(Integer a)
	{
		System.out.println("Integer");
	}
}
