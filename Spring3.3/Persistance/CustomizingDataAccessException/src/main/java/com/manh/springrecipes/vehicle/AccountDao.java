package com.manh.springrecipes.vehicle;

import java.util.List;

public interface AccountDao
{
	public void insert(Account vehicle); 
	public void update(Account vehicle); 
	public void delete(Account vehicle); 
	public Double findByBalanceNo(String vehicleNo); 
	public void batchInsert(List<Account> account); 
}
