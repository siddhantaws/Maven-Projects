package com.manh.springrecipes.dao;

import java.util.List;

import com.manh.springrecipes.entiry.Account;

public interface AccountDao
{
	public void insert(Account vehicle); 
	public void update(Account vehicle); 
	public void delete(Account vehicle); 
	public Double findByBalanceNo(String vehicleNo); 
	public void batchInsert(List<Account> account); 
}
