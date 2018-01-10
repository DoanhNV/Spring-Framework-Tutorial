package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import demo.entity.Pencil;
import demo.entity.Student;

@Configuration
@Import(ConfigB.class)
public class SpringConfig {
	
	@Bean(name="student1",initMethod = "init", destroyMethod = "clean")
	@Scope(scopeName = "prototype")
	public Student createSutdent() {
		return new Student(createPencil());
	}
	
	@Bean
	public Pencil createPencil()  {
		return new Pencil();
	}
}
