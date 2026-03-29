package com.nikhil.entity;

import java.time.LocalDateTime;


import com.nikhil.enums.AccountStatus;
import com.nikhil.enums.AccountType;

import jakarta.persistence.*;

@Entity
@Table(name="account")
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
	@Column(name = "account_number", unique = true, nullable = false, length = 10)
	  private String  accountNumber;
  @Enumerated(EnumType.STRING)
  @Column(name = "account_type", nullable = false)
    private AccountType accountType;
  @Column(nullable = false)
    private Double balance;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Version   
    private Integer version;
    public LocalDateTime getCreatedDate() {
		return LocalDateTime.now();
	}
    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = AccountStatus.ACTIVE; // default
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Account() {}

   

    public Long getAccountId() {
		return accountId;
	}



	


	public String getAccountNumber() {
        return accountNumber;
    }

  

   
    public Customer getCustomer() {
        return customer;
    }

   



	public AccountStatus getStatus() {
		return status;
	}



	public void setStatus(AccountStatus status) {
		this.status = status;
	}



	


	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

  
   


	

	public void setBalance(Double balance) {
		this.balance = balance;
	}



	

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
  


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

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}