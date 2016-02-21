package com.manh.wmos;

import com.sapient.concurrent.locks.Semaphore;

public class Employee
{
	private Semaphore semaphore;

	public Employee(Semaphore semaphore) 
	{
		super();
		this.semaphore = semaphore;
	}
	
	public void setEmployee()
	{
		try {
			semaphore.acquire();
			System.out.println("Employee Chnages");
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
