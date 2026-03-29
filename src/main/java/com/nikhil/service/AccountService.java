package com.nikhil.service;
import java.util.List;

import com.nikhil.dto.AccountRequestDTO;
import com.nikhil.dto.AccountResponseDTO;
import com.nikhil.entity.Account;

public interface AccountService {

	 AccountResponseDTO createAccount(AccountRequestDTO request) ;

    Account getAccountByNumber(String accountNumber);

    List<Account> getCustomerAccounts(Long customerId);

    void deactivateAccount(Long accountId);
}