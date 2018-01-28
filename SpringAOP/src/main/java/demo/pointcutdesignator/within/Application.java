package demo.pointcutdesignator.within;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;

public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person person = (Person) context.getBean("person");
		person.say();
	}
}
