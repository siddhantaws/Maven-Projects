package com.manh.springrecipes.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;


public class JdbcAccountDao implements AccountDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public void insert(final Account vehicle)
	{
		final String sql = "INSERT INTO ACCOUNT (ACCOUNT_NO, BALANCE) VALUES (?, ?)"; 
		new JdbcTemplate(dataSource).update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement preparedStatement=con.prepareStatement(sql);
				preparedStatement.setString(1, vehicle.getAccountNo());
				preparedStatement.setDouble(2, vehicle.getBalance());
				return preparedStatement;
			}
		});
	}

	@Override
	public void update(final Account vehicle) 
	{
		final String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNT_NO = ?";
		new JdbcTemplate(dataSource).update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement preparedStatement=con.prepareStatement(sql);
				preparedStatement.setDouble(1, vehicle.getBalance());
				preparedStatement.setString(2, vehicle.getAccountNo());
				return preparedStatement;
			}
		});
	}

	@Override
	public void delete(final Account vehicle) {
		final String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_NO = ?";
		new JdbcTemplate(dataSource).update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException 
			{
				ps.setString(1, vehicle.getAccountNo());
			}
		});
	}

	@Override
	public Double findByBalanceNo(String vehicleNo) {
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NO = ?"; 
		return 0.0;
		
	}

	@Override
	public void batchInsert(final List<Account> accounts) 
	{
		final String sql = "INSERT INTO ACCOUNT (ACCOUNT_NO, BALANCE) VALUES (?, ?)"; 
		new JdbcTemplate(dataSource).batchUpdate(sql, new BatchPreparedStatementSetter() 
		{
			@Override
			public void setValues(PreparedStatement preparedStatement, int i) throws SQLException 
			{
				Account account=accounts.get(i);
				preparedStatement.setString(1, account.getAccountNo());
				preparedStatement.setDouble(2, account.getBalance());
			}
			
			@Override
			public int getBatchSize() 
			{
				return accounts.size();
			}
		});
	}

}
