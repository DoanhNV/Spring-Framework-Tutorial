package com.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.dao.CustomerDAO;
import com.entity.Customer;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerDAO customerDAO = applicationContext.getBean(CustomerDAO.class);
		for (int i = 0; i < 10; i++) {
			Customer customer2 = new Customer("DoanhNV1", "Táo", 8000000);
			Customer saveCustomer3 = customerDAO.save(customer2);
		}
	
	}
}
