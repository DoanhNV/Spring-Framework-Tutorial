package demo.pointcutdesignator.this_;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;

public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person person = context.getBean(Person.class);
		person.showName();
		person.display();
	}
}	
