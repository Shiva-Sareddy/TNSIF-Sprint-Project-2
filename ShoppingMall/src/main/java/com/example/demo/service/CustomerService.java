package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	// insert the data
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
		
	// retrieving all the data
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	// retrieving the data by id
	public Optional<Customer> getCustomerById(Integer id){
		return customerRepository.findById(id);
	}
	
	// updating the data
	public Customer updateCustomer(Integer id, Customer customerDetails) {
		Customer customer = customerRepository.findById(id).get();
		customer.setName(customerDetails.getName());	
		customer.setPhone(customerDetails.getPhone());	
		customer.setEmail(customerDetails.getEmail());
		return customerRepository.save(customer);	
	}
	
	
	// deleting the data by id
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}
	
	// deleting all rows
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}
}
