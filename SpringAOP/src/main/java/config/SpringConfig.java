package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demo.Student;
import demo.StudentAspect;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
	
	@Bean("student1")
	public Student createStudent() {
		return new Student("Doanh Ngô Văn");
	}
	
	@Bean("student2")
	public Student createStudent2() {
		return new Student();
	}
	
	@Bean
	public StudentAspect createStudentAspect () {
		return new StudentAspect();
	}
}
