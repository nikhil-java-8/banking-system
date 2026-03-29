package com.nikhil.controller;

import java.util.List;
import com.nikhil.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nikhil.dto.AccountRequestDTO;
import com.nikhil.dto.AccountResponseDTO;
import com. nikhil.entity.Account;
import com.nikhil.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountServiceImpl accountServiceImpl;

    public AccountController(AccountService accountService, AccountServiceImpl accountServiceImpl) {
		super();
		this.accountService = (AccountServiceImpl) accountService;
		this.accountServiceImpl = accountServiceImpl;
	}

	/*private final AccountService accountService;

    @PostMapping("/{customerId}")
    public Account createAccount(@PathVariable Long customerId,
                                 @RequestBody Account account) {
        return accountService.createAccount(customerId, account);
    }*/
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getCustomerAccounts(@PathVariable Long customerId) {
        return accountService.getCustomerAccounts(customerId);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO request) {
    	
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @PutMapping("/block/{accountId}")
    public String blockAccount(@PathVariable Long accountId) {
        accountService.deactivateAccount(accountId);
        return "Account blocked successfully";
    }
    @GetMapping("/all")
    public String getAllAccounts() {
        return "Only authenticated banker can see this";
    }
}