package com.nikhil.dto;

import com.nikhil.entity.Customer;
import com.nikhil.enums.AccountStatus;
import com.nikhil.enums.AccountType;

public class AccountResponseDTO {
	private String accountNumber;
    private AccountType accountType;
    private Double balance;
    private AccountStatus status;
    private Customer customer;
    public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String string) {
		this.accountNumber = string;
	}
	
	public Double getBalance() {
		return balance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	}
	
