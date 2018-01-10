package config;

import org.springframework.context.annotation.Bean;

import demo.entity.Student;

public class ConfigB {
	
	@Bean("student2")
	public Student createStudent() {
		return new Student();
	}
}
