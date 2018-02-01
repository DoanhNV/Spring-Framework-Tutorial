package config.designator.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demo.pointcutdesignator.annotation.args.Person;
import demo.pointcutdesignator.annotation.args.PersonAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {

	// @args
	@Bean("person1")
	public Person createPerson1() {
		return new Person();
	}

	@Bean("aspect1")
	public PersonAspect createPersonAspect1() {
		return new PersonAspect();
	}

	// @target
	@Bean("person2")
	public demo.pointcutdesignator.annotation.target.Person createPerson2() {
		return new demo.pointcutdesignator.annotation.target.Person();
	}

	@Bean("aspect2")
	public demo.pointcutdesignator.annotation.target.PersonAspect createPersonAspect2() {
		return new demo.pointcutdesignator.annotation.target.PersonAspect();
	}

	// @annotation
	@Bean("person3")
	public demo.pointcutdesignator.annotation.execution.Person createPerson3() {
		return new demo.pointcutdesignator.annotation.execution.Person();
	}

	@Bean("aspect3")
	public demo.pointcutdesignator.annotation.execution.PersonAspect createPersonAspect3() {
		return new demo.pointcutdesignator.annotation.execution.PersonAspect();
	}
}
