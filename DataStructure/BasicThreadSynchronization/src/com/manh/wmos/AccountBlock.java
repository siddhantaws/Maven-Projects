package com.manh.wmos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccountBlock 
{
	public static int id=12;
	public static synchronized void substract()
	{
		System.out.println("public void substract()");
		try {
			System.out.println("BeforeSleep"+id);
			Thread.currentThread().sleep(2000);
			System.out.println("AfterSleep"+id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id++;
	}
	public  void add()
	{
		synchronized((Integer)id)
		{
			System.out.println("public void add()"+Thread.currentThread().getName());
			try {
				System.out.println("BeforeSleep"+id);
				Thread.currentThread().sleep(2000);
				System.out.println("AfterSleep"+id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public  void multiply()
	{
		synchronized((Integer)id)
		{
			System.out.println("public void multiply()"+Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public static  synchronized void derivative()
	{
		System.out.println("public void derivative()");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
