package com.manh.wmos;

public class Main
{
	public static void main(String[] args) 
	{
		AccountBlock account=new AccountBlock();
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				account.add();
			}
		},"Thread1");
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				account.multiply();
			}
		},"Thread2");
		thread1.start();
		thread2.start();
	}
}
