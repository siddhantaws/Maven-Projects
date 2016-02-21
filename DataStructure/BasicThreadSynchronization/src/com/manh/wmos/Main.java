package com.manh.wmos;

public class Main
{
	public static void main(String[] args) 
	{
		final AccountBlock  account1=new AccountBlock();
		final AccountBlock  account2=new AccountBlock();
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				AccountBlock.devide();
			}
		},"Thread1");
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				AccountBlock.derivative();
			}
		},"Thread2");
		thread1.start();
		thread2.start();
	}
}
