package com.nikhil.service;

import java.util.List;

import com.nikhil.dto.TransactionResponseDTO;
import com.nikhil.dto.TransferRequest;
import com.nikhil.entity.Transaction;

public interface TransactionService {

	TransactionResponseDTO transferMoney(String fromAcc, String toAcc, Double amount);

    List<Transaction> getTransactions(Long accountId);

}
