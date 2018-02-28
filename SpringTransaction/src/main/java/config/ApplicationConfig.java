package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.StudentDAO;
import dao.StudentDAOImpl;

@Configuration
public class ApplicationConfig {

	@Bean
	public DriverManagerDataSource createDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/student_db?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager createTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(createDataSource());
		return transactionManager;
	}

	@Bean
	public StudentDAO createStudentDA() {
		return new StudentDAOImpl(createDataSource(),createTransactionManager());
	}
}
