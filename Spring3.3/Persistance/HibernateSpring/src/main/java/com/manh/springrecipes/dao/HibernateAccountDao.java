package com.manh.springrecipes.dao;


import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.manh.springrecipes.entiry.Account;


public class HibernateAccountDao implements AccountDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(Account vehicle)
	{
		sessionFactory.openSession().save(vehicle);
	}

	@Override
	public void update(final Account vehicle) 
	{
		
	}

	@Override
	public void delete(final Account vehicle) {
		
	}

	@Override
	public Double findByBalanceNo(String vehicleNo) {
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NO = ?"; 
		return 0.0;
		
	}

	@Override
	public void batchInsert(final List<Account> accounts) 
	{
		
	}

}
