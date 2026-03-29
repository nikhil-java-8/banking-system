package com.nikhil.service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.dto.AccountResponseDTO;
import com.nikhil.dto.TransactionResponseDTO;
import com.nikhil.dto.TransferRequest;
import com.nikhil.entity.Account;
import com.nikhil.entity.Transaction;
import com.nikhil.exception.AccountNotFoundException;
import com.nikhil.exception.InsufficientBalanceException;
import com.nikhil.exception.InvalidAmountException;
import com.nikhil.repository.AccountRepository;
import com.nikhil.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
	 @Autowired
	    AccountRepository accountRepository;
	 @Autowired 
	 AuditService auditService;
   @Autowired
	 TransactionRepository transactionRepository ;

    
   @Override
    @Transactional   
    public TransactionResponseDTO transferMoney(String fromAccNum, String toAccNum, Double amount) {

        Account from = accountRepository.findByAccountNumber(fromAccNum)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        Account to = accountRepository.findByAccountNumber(toAccNum)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        // Balance check
        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
System.out.println("from"+fromAccNum);
System.out.println("to"+toAccNum);
System.out.println("bal"+amount);

        // Debit
        from.setBalance(from.getBalance() - amount);

        // Credit
        to.setBalance(to.getBalance() + amount);
System.out.println("before");
        accountRepository.save(from);
        System.out.println("afeter");
        System.out.println("from"+from);
        accountRepository.save(to);
System.out.println("to"+to);
        // Save transaction
        Transaction txn = new Transaction();
        txn.setFromAccount(from);
        txn.setToAccount(to);
        txn.setAmount(amount);
        txn.setStatus("SUCCESS");
        txn.setTransactionType("TRANSFER");
        txn.setDate(LocalDateTime.now());
        System.out.println(txn);
        transactionRepository.save(txn);
        transactionRepository.saveAndFlush(txn); 
      //  auditService.log(username, "DEPOSIT", accountId,
        //        amount, "SUCCESS", "Amount deposited");
        TransactionResponseDTO trd=new TransactionResponseDTO();
        trd.setFromAccountId(fromAccNum);
        trd.setToAccountId(toAccNum);
        trd.setAmount(amount);
    return trd;    
    }
    

    @Override
    public List<Transaction> getTransactions(Long accountId) {
        return transactionRepository.findByFromAccountAccountId(accountId);
    }
    
    private AccountResponseDTO mapToDTO(Account account) {

	    AccountResponseDTO dto = new AccountResponseDTO();

	    dto.setAccountNumber(account.getAccountNumber());
	    dto.setBalance(account.getBalance());
	    dto.setAccountType(account.getAccountType());

	    // agar customer bhi bhejna hai
	   // dto.setCustomerName(account.getCustomer().getFName());

	    return dto;
	}
    @Transactional
    public AccountResponseDTO deposit(Long accountId, double amount) {

        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);

        return mapToDTO(account);
    }

    @Transactional
    public AccountResponseDTO withdraw(Long accountId, double amount) {

        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        }

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);

        return mapToDTO(account);
    }

	

    
}