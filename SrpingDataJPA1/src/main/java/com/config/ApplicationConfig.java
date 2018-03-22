package com.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.constant.Constant;
import com.service.UserService;

@Configuration
@EnableJpaRepositories(basePackages = { "com.repository" }, entityManagerFactoryRef = Constant.EM_FACTORY_BEAN)
public class ApplicationConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/" + Constant.DB_NAME);
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	private Properties properties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean(name = Constant.EM_FACTORY_BEAN)
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(dataSource());
		emfBean.setJpaProperties(properties());
		emfBean.setPackagesToScan(new String[] { "com.entity" });
		emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emfBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor translationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
}
