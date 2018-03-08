package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
public class WebMVCConfig extends WebMvcConfigurationSupport {
	
	@Bean
	public ViewResolver configViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Bean
	public MessageSource configMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(new String[]{"/WEB-INF/message","classpath:message"});
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean configValidatorFactory() {
		LocalValidatorFactoryBean   factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(configMessageSource());
		return factoryBean;
	}


	@Override
	protected Validator getValidator() {
		return configValidatorFactory();
	}
	
}
