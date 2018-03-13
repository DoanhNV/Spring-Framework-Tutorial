package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.repository.CustomerRepository;

@Service
public class CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer find(int id) {
		return customerRepository.findById(id);
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
}
