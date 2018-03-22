package com.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.config.ApplicationConfig;
import com.entity.User;
import com.service.CountryService;
import com.service.UserService;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		/*userService.testCreate2();
		User user = userService.testFindLazy(1);
		System.out.println(user.getCountry().getId());*/
		/*userService.testReadLimit();*/
		/*userService.testReadElement();*/
		/*userService.testReadForDTO();*/
		userService.testExample();
		
		
		// COUNTRY
		CountryService countryService = context.getBean(CountryService.class);
		/*countryService.testcreate();*/
		/*countryService.testRead();*/
		
		
		
		context.close();
	}
}
