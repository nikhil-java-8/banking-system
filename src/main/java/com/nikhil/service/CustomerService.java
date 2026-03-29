package com.nikhil.service;

import java.util.List;

import com.nikhil.dto.AccountRequestDTO;
import com.nikhil.dto.AccountResponseDTO;
import com.nikhil.dto.CustomerRequestDTO;
import com.nikhil.dto.CustomerResponseDTO;
import com.nikhil.entity.Account;
import com.nikhil.entity.Customer;

public interface CustomerService {

   // Customer createCustomer(Customer customer);
   CustomerResponseDTO createCustomer(CustomerRequestDTO customer);
    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

	//Customer createCustomer(Long customerId, Account account);
}