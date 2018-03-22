package com.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.config.ApplicationConfig;
import com.service.UserService;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserService userService = context.getBean(UserService.class);
		/*userService.testCreate();*/
		/*userService.testRead();*/
		/*userService.testSort();*/
		userService.testPageing();
		context.close();
	}
}
