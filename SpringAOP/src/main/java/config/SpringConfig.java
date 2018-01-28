package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demo.Student;
import demo.StudentAspect;
import demo.pointcutdesignator.target.Animal2;
import demo.pointcutdesignator.within.AnimalAspect;
import demo.pointcutdesignator.within.Person;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
// nếu proxyTargetClass = true thì target(...) đến 1 object mà "class được implement từ 1 interface" 
// mới hoạt động
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
	
	// POINTCUT Designator
	
	// Within
	@Bean("person")
	public Person createPerson() {
		return new Person();
	}
	
	@Bean("animalAspect")
	public AnimalAspect createAnimalAspect () {
		return new AnimalAspect();
	}
	
	// this
	@Bean("person2")
	public demo.pointcutdesignator.this_.Person createPerson2() {
		return new demo.pointcutdesignator.this_.Person();
	}
	
	@Bean("animalAspect2")
	public demo.pointcutdesignator.this_.AnimalAspect createAnimalAspect2 () {
		return new demo.pointcutdesignator.this_.AnimalAspect();
	}
	
	// target
	@Bean("person3")
	public Animal2 createPerson3() {
		return new demo.pointcutdesignator.target.Person2();
	}
	
	@Bean("animalAspect3")
	public demo.pointcutdesignator.target.AnimalAspect2 createAnimalAspect3 () {
		return new demo.pointcutdesignator.target.AnimalAspect2();
	}
}
