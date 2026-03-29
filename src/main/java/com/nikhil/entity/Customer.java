package com.nikhil.entity;



import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "lname")
    private String lName;
    @Column(unique = true)
    private String email;

    private String phone;

    private String address;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;
    public Customer() {
    }

    
    public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

 
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

   
   
    


	

	public String getFName() {
		return fName;
	}


	public void setFName(String fName) {
		this.fName = fName;
	}


	public String getLName() {
		return lName;
	}


	public void setLName(String lName) {
		this.lName = lName;
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	


	public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate =createdDate;
       
    }
}