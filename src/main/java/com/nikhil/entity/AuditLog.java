package com.nikhil.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;


@Entity
@Table(name = "audit_logs")
@Builder
public class AuditLog {

    public AuditLog(Long id, String username, String action, Long accountId, Double amount, String status,
			String description, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.username = username;
		this.action = action;
		this.accountId = accountId;
		this.amount = amount;
		this.status = status;
		this.description = description;
		this.timestamp = timestamp;
	}

	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String action; 
    // CREATE_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER

    private Long accountId;

    private Double amount;

    private String status; 
    // SUCCESS / FAILED

    private String description;

    private LocalDateTime timestamp;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
}