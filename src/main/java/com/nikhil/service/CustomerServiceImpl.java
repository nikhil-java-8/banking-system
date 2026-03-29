package com.nikhil.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.dto.CustomerRequestDTO;
import com.nikhil.dto.CustomerResponseDTO;
import com.nikhil.entity.Account;
import com.nikhil.entity.Customer;
import com.nikhil.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public  class CustomerServiceImpl implements CustomerService {

private CustomerRepository customerRepository;
	public CustomerServiceImpl(CustomerRepository customerRepository) {
	super();
	this.customerRepository = customerRepository;
      }
	@Override
	public CustomerResponseDTO createCustomer(CustomerRequestDTO request) {
		  Customer customer=new Customer();
	        customer.setFName(request.getFName());
	        customer.setLName(request.getLName());
	        customer.setCreatedDate(request.getCreatedDate());
	        customer.setPhone(request.getPhone());
	        customer.setEmail(request.getEmail());
	        customer.setAddress(request.getAddress());
	        Customer saved = customerRepository.save(customer);
             //customer response
	        CustomerResponseDTO response=new CustomerResponseDTO();
	        response.setCustomerId(saved.getCustomerId());
	        response.setFName(saved.getFName());
	        response.setLName(saved.getLName());
	        response.setEmail(saved.getEmail());
	        response.setPhone(saved.getPhone());
	        response.setAddress(saved.getAddress());
	        response.setCreatedDate(saved.getCreatedDate());
 
	        return response;
	        
	}
/*@Override
    public Customer createCustomer(Customer customer) {
		customer.setCreatedDate(LocalDateTime.now());
		//customer.setfName(customer.getfName());
		//customer.setlName(customer.getlName());
        return customerRepository.save(customer);
    }*/
/*   customer.setPhone(dto.getPhone());
	    customer.setAddress(dto.getAddress());

	    customer.setCreatedDate(LocalDateTime.now());

	    // Save
	    Customer saved = customerRepository.save(customer);
System.out.println(saved.getCustomerId());
	    // Entity → DTO
	    CustomerResponseDTO response = new CustomerResponseDTO();
	    response.setCustomerId(saved.getCustomerId());
	    response.setfName(saved.getfName());
	    response.setlName(saved.getlName());
	    response.setEmail(saved.getEmail());
	    response.setPhone(saved.getPhone());
	    response.setAddress(saved.getAddress());
	    response.setCreatedDate(saved.getCreatedDate());

	    return response;
	}
  */  @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer updated) {
        Customer customer = getCustomerById(id);
        //customer.setfName(updated.getfName());
        //customer.setlName(updated.getlName());
        customer.setEmail(updated.getEmail());
       
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

	

	
}