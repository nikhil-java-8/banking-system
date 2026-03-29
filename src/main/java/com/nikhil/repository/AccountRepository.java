package com.nikhil.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByCustomerCustomerId(Long customerId);
}