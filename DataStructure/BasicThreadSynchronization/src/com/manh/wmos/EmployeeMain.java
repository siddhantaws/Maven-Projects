package com.manh.wmos;

import com.sapient.concurrent.locks.Semaphore;

public class EmployeeMain 
{
	public static void main(String[] args) 
	{
		Semaphore semaphore=new Semaphore(-1, true);
		final Employee employee=new Employee(semaphore);
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				employee.setEmployee();
			}
		});
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				employee.setEmployee();
			}
		});
		t2.start();
	}
}
