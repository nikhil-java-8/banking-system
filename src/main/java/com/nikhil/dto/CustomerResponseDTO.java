package com.nikhil.dto;

import java.time.LocalDateTime;


public class CustomerResponseDTO {
  private Long customerId;

public Long getCustomerId() {
	return customerId;
}

  public void setCustomerId(Long customerId) {
	this.customerId = customerId;
  }
 
private String fName;
    private String lName;
  
    private String email;

    private String phone;

    private String address;

    private LocalDateTime createdDate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}
