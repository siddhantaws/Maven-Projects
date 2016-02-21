package com.manh.springrecipes.account;

import java.util.List;

public interface AccountDao
{
	public void insert(Account vehicle); 
	public void update(Account vehicle); 
	public Account findByAccountNo(String accountNo); 
	public List<Account> findByBalanceNo(String vehicleNo); 
	public List<Account> findByBalanceNoAqueryForList(String vehicleNo); 
	public void batchInsert(List<Account> account); 
}
