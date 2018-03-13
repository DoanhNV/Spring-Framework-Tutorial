package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Integer>{
	
	Customer findById(int id);

	<S extends Customer> S save(S customer);
	
}
