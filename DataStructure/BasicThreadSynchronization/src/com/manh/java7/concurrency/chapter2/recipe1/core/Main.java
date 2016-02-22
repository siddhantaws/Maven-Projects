package com.manh.java7.concurrency.chapter2.recipe1.core;

import com.manh.java7.concurrency.chapter2.recipe1.task.Account;
import com.manh.java7.concurrency.chapter2.recipe1.task.Bank;
import com.manh.java7.concurrency.chapter2.recipe1.task.Company;

/**
 * Main class of the example. It creates an account, a company and a bank
 * to work with the account. The final balance is equal to the initial.
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	
	public static void main(String[] args) {
		// Creates a new account ...
		Account	account=new Account();
		// an initialize its balance to 1000
		account.setBalance(1000);
		
		// Creates a new Company and a Thread to run its task
		Company	company=new Company(account);
		Thread companyThread=new Thread(company);
		// Creates a new Bank and a Thread to run its task
		Bank bank=new Bank(account);
		Thread bankThread=new Thread(bank);
		
		// Prints the initial balance
		System.out.printf("Account : Initial Balance: %f\n",account.getBalance());
		
		// Starts the Threads
		companyThread.start();
		bankThread.start();

		try {
			// Wait for the finalization of the Threads
			companyThread.join();
			bankThread.join();
			// Print the final balance
			System.out.printf("Account : Final Balance: %f\n",account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
