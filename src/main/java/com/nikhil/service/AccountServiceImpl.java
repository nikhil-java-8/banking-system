package com.nikhil.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.dto.AccountRequestDTO;
import com.nikhil.dto.AccountResponseDTO;
import com.nikhil.entity.Account;
import com.nikhil.entity.Customer;
import com.nikhil.enums.AccountType;
import com.nikhil.repository.AccountRepository;
import com.nikhil.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	@Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;
    private String generateAccountNumber() {
	    long number = (long) (Math.random() * 1_000_000_0000L); // 10 digit
	    return String.format("%010d", number);
	}
   
    public AccountResponseDTO createAccount(AccountRequestDTO request) {   	
    	System.out.println("Customer ID: " + request.getCustomerId());
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if (request.getAccountType() == AccountType.SAVINGS && request.getInitialDeposit() < 1000) {
            throw new RuntimeException("Minimum balance for Savings is 1000");
        }

        if (request.getAccountType() == AccountType.CURRENT && request.getInitialDeposit() < 5000) {
            throw new RuntimeException("Minimum balance for Current is 5000");
        }
        // Create account
        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountType(request.getAccountType());
        account.setBalance(request.getInitialDeposit());
        account.setAccountNumber(generateAccountNumber());
        account.setStatus(request.getStatus());
        account.setUpdatedAt(request.getUpdatedAt());
        Account savedAccount = accountRepository.save(account);
      
        // Convert to DTO
        AccountResponseDTO response = new AccountResponseDTO();
        response.setAccountNumber(savedAccount.getAccountNumber());
        response.setAccountType((AccountType) savedAccount.getAccountType());
        response.setBalance(savedAccount.getBalance());
        response.setStatus(savedAccount.getStatus());
        return response;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
		super();
		this.accountRepository = accountRepository;
		this.customerRepository = customerRepository;
	}

	@Override
    public List<Account> getCustomerAccounts(Long customerId) {
        return accountRepository.findByCustomerCustomerId(customerId);
    }

	@Override
	public void deactivateAccount(Long accountId) {
		// TODO Auto-generated method stub
		
	}
	
	

    //@Override
   /* public void deactivateAccount(Long accountId) {
        Account acc = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        acc.setStatus("BLOCKED");
        accountRepository.save(acc);
    }*/
	
}