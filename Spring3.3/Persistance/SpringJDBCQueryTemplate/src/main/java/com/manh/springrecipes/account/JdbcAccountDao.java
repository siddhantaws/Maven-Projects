package com.manh.springrecipes.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.SQLErrorCodes;


public class JdbcAccountDao implements AccountDao {

	@Autowired
	JdbcTemplate  jdbcTemplate;

	@Override
	public void insert(Account vehicle) 
	{
		
	}

	@Override
	public void update(Account vehicle)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findByAccountNo(String accountNo) 
	{
		final String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NO = ?"; 
		final Account account=new Account();
		jdbcTemplate.query(sql,new  Object[]{accountNo}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				account.setAccountNo(rs.getString(1));
				account.setBalance(rs.getDouble(2));
			}
		});
		return account;
	}

	@Override
	public List<Account> findByBalanceNo(String vehicleNo) 
	{
		final String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NO = ?"; 
		return jdbcTemplate.query(sql, new Object[]{vehicleNo}, new AccountRowMapper());
	}

	@Override
	public void batchInsert(List<Account> account) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> findByBalanceNoAqueryForList(String vehicleNo) 
	{

		final String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NO = ?"; 
		List<Account> accounts=new ArrayList<Account>();
		for(Map<String, Object> map:jdbcTemplate.queryForList(sql))
		{
			accounts.add(new Account((String)map.get("ACCOUNT_NO"), (Double)map.get("BALANCE")));
		}
		return accounts;
	}
	
	

}
