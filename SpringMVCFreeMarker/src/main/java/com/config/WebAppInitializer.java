package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(WebMVCConfig.class);
		Dynamic dispathcher = servletContext.addServlet("mvc", new DispatcherServlet(applicationContext));
		dispathcher.addMapping("/");
		servletContext.setInitParameter("auto_import", "/WEB-INF/lib/libraries.ftl as util");
		dispathcher.setLoadOnStartup(1);
	}

}
