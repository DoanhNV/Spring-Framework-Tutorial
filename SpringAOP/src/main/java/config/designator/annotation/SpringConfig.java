package config.designator.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demo.pointcutdesignator.annotation.args.Person;
import demo.pointcutdesignator.annotation.args.PersonAspect;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
	
	@Bean("person1")
	public Person createPerson1() {
		return new Person();
	}
	
	@Bean("aspect1")
	public PersonAspect createPersonAspect1() {
		return new PersonAspect();
	} 
}
