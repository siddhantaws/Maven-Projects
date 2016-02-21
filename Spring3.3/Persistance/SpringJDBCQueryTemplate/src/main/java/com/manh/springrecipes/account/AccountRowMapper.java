package com.manh.springrecipes.account;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> 
{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Account account=new Account();
		account.setAccountNo(rs.getString(1));
		account.setBalance(rs.getDouble(2));
		return account;
	}
	
}
