package com.nikhil.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nikhil.dto.AccountRequestDTO;
import com.nikhil.dto.AccountResponseDTO;
import com.nikhil.dto.CustomerRequestDTO;
import com.nikhil.dto.CustomerResponseDTO;
import com.nikhil.entity.Customer;
import com.nikhil.service.AccountServiceImpl;
import com.nikhil.service.CustomerService;
import com.nikhil.service.CustomerServiceImpl;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
	
  /*  public CustomerController(CustomerService customerService,CustomerServiceImpl  CustomerServiceImpl) {
		super();
		this.customerService = (CustomerServiceImpl) customerService;
		this.ServiceImpl = accountServiceImpl;
	}*/
    @Autowired
    private CustomerServiceImpl customerService;
	
    @PostMapping("/create")
    ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}