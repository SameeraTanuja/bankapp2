package com.capgemini.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.service.BankService;

@Controller
public class BankController {
	@Autowired
	private BankService bankService;
	private BankController(BankService bankService) {
		super();
		this.bankService=bankService;
	}
	/*public void setBankService(BankService bankService) {
		this.bankService=bankService;
		
	}*/
	
	public double getBalance(long accountId) {
		return bankService.getBalance(accountId);
	}
	
	public double withdraw(long accountId,double amount) throws LowBalanceException {
		return bankService.withdraw(accountId, amount);
		
		
	}
	public double deposit(long accountId,double amount) {
		return bankService.deposit(accountId, amount);
		
	}
	public boolean fundTransfer(long fromAccount, long toAccount,double amount) throws LowBalanceException{
		return bankService.fundTransfer(fromAccount, toAccount, amount);
		
	}
	
	public boolean addBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return bankService.addBankAccount(account);
	}

	
	public BankAccount findBankAccountById(long accountId) {
		// TODO Auto-generated method stub
		return bankService.findBankAccountById(accountId);
	}

	
	public List<BankAccount> findAllBankAccounts() {
		// TODO Auto-generated method stub
		return bankService.findAllBankAccounts();
	}

	
	public BankAccount updateBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return bankService.updateBankAccount(account);
	}

	
	public boolean deleteBankAccount(long accountId) {
		// TODO Auto-generated method stub
		return bankService.deleteBankAccount(accountId);
	}

	

}
