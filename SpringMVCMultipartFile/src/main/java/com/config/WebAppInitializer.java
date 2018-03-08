package com.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
	private static final String TEMP_SOURCE = "D:/app/";
	private static final int MAX_FILE_SIZE = 10485760;

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(WebMVCConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mvc", dispatcherServlet);
		dispatcher.addMapping("/");
		
		dispatcher.setLoadOnStartup(1);
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TEMP_SOURCE, MAX_FILE_SIZE, MAX_FILE_SIZE*2,
				0);
		dispatcher.setMultipartConfig(multipartConfigElement);
	}

}
