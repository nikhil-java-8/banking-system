package com.nikhil.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query
    Customer findByEmail(String email);
}