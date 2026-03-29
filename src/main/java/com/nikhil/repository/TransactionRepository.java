package com.nikhil.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Get all transactions of an account
    List<Transaction> findByFromAccountAccountId(Long accountId);

    List<Transaction> findByToAccountAccountId(Long accountId);
}