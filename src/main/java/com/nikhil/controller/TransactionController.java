package com.nikhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.dto.AccountRequestDTO;
import com.nikhil.dto.AccountResponseDTO;
import com.nikhil.dto.TransactionResponseDTO;
import com.nikhil.dto.TransferRequest;
import com.nikhil.entity.Transaction;
import com.nikhil.service.AccountServiceImpl;
import com.nikhil.service.TransactionService;
import com.nikhil.service.TransactionServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
@Autowired
	 TransactionService transactionService;
@Autowired
TransactionServiceImpl accountService;
    // Money Transfer API
    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponseDTO> transferMoney(@RequestBody TransferRequest request) {
    	TransactionResponseDTO response =
                accountService.transferMoney(
                        request.getFromAccountId(),
                        request.getToAccountId(),
                        request.getAmount()
                );

        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/deposit")
    public AccountResponseDTO deposit(@PathVariable Long id, @RequestParam double amount) {
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public AccountResponseDTO withdraw(@PathVariable Long id, @RequestParam double amount) {
        return accountService.withdraw(id, amount);
    }

    // Transaction History
    @GetMapping("/{accountId}")
    public List<Transaction> getTransactions(@PathVariable Long accountId) {
        return transactionService.getTransactions(accountId);
    }
}