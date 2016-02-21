package com.manh.wmos;

public class Account 
{
	public synchronized void substract()
	{
		System.out.println("public void substract()");
	}
	public  synchronized void add()
	{
		System.out.println("public void add()"+Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static synchronized void multiply()
	{
		System.out.println("public void multiply()"+Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static synchronized void devide()
	{
		System.out.println("public void devide()");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
