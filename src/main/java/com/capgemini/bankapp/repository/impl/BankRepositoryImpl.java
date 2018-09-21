package com.capgemini.bankapp.repository.impl;
import com.capgemini.bankapp.repository.BankRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.entities.*;

@Repository

public class BankRepositoryImpl implements BankRepository  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		double balance=jdbcTemplate.queryForObject("SELECT accountbalance FROM bankaccounts WHERE accountId=?", new Object[]{accountId}, Double.class);
				
		return balance;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		int count=jdbcTemplate.update("UPDATE bankaccounts SET accountbalance=? WHERE accountId=?",new Object[] {accountId,newBalance});
		return count!=0;
	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		int count=jdbcTemplate.update("INSERT INTO bankaccounts VALUES(?,?,?)", new Object[] {account.getAccountId(),account.getAccountHolderName(),account.getAccountType(),account.getAccountBalance()});
		
		return count!=0;
	}
	
	@Override
	public BankAccount findBankAccountById(long accountId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM bankaccounts WHERE accountid=?", new Object[] {accountId},new BankAccountRowMapper());
		

	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query("SELECT * FROM bankaccounts", new Object[] { }, new BankAccountRowMapper());
	}

	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		int count=jdbcTemplate.update("UPDATE bankaccounts SET accountHoldername=?,accounttype=? WHERE accountId=?", new Object[] {account.getAccountHolderName(),account.getAccountType()});
		return count!=0? account:findBankAccountById(account.getAccountId());
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		// TODO Auto-generated method stub
		int count=jdbcTemplate.update("DELETE FROM bankaccounts WHERE accountId=?", new Object[] {accountId});
		return count!=0;
	}
	private class BankAccountRowMapper implements RowMapper<BankAccount>{
		
		@Override
		public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException{
			BankAccount account=new BankAccount();
			account.setAccountId(rs.getLong(1));
			account.setAccountHolderName(rs.getString(2));
			account.setAccountType(rs.getString(3));
			account.setAccountBalance(rs.getDouble(4));
			return account;
		}
	}
	
}
	

	


