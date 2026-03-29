package com.nikhil.dto;

import java.time.LocalDateTime;

import com.nikhil.enums.AccountStatus;
import com.nikhil.enums.AccountType;

public class AccountRequestDTO {
	private Long customerId;
    private AccountType accountType;
    private Double initialDeposit;
    private AccountStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
 
    public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Double getInitialDeposit() {
		return initialDeposit;
	}
	public void setInitialDeposit(Double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
    
}
