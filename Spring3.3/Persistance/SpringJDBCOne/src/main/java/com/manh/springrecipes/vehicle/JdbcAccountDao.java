package com.manh.springrecipes.vehicle;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class JdbcAccountDao extends SimpleJdbcDaoSupport implements AccountDao {

	@Override
	public void insert(Account vehicle)
	{
		String sql = "INSERT INTO ACCOUNT (ACCOUNT_NO, BALANCE) VALUES (?, ?)"; 
		getSimpleJdbcTemplate().update(sql, vehicle.getAccountNo(),vehicle.getBalance());
	}

	@Override
	public void update(Account vehicle) 
	{
		String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNT_NO = ?";
		getSimpleJdbcTemplate().update(sql, vehicle.getBalance(),vehicle.getAccountNo());
	}

	@Override
	public void delete(Account vehicle) {
		String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_NO = ?";
		getSimpleJdbcTemplate().update(sql,vehicle.getAccountNo());
	}

	@Override
	public Double findByBalanceNo(String vehicleNo) {
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NO = ?"; 
		return getSimpleJdbcTemplate().queryForObject(sql, Double.class, vehicleNo);
		
	}

}
