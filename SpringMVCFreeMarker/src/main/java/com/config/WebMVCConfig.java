package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan("com")
public class WebMVCConfig {

	@Bean
	public ViewResolver configViewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".ftl");
		viewResolver.setRequestContextAttribute("request");
		return viewResolver;
	}

	@Bean
	public FreeMarkerConfigurer markerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/WEB-INF/view/");
		return configurer;
	}
	
}
