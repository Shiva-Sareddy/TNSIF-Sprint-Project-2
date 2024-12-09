package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// insert
	@PostMapping("/addcustomer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
		
	// retrieve
	@GetMapping("/getcustomer") // normal way to get all data
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getcustomer/{id}") // this is to get particular row with id
	public Optional<Customer> getCustomerById(@PathVariable Integer id){
		return customerService.getCustomerById(id);
	}
	
	// update
	@PutMapping("/updcustomer/{id}")
	public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) {
		return customerService.updateCustomer(id, customerDetails);
	}
	
	// delete
	@DeleteMapping("/delcustomer/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
	}
	
	// entire deleting all rows
	@DeleteMapping("/delcustomer")
	public void deleteAllCustomers() {
		customerService.deleteAllCustomers();
	}
	
	
}
