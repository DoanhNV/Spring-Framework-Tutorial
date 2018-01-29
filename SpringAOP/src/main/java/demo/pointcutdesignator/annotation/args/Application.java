package demo.pointcutdesignator.annotation.args;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.designator.annotation.SpringConfig;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person person = (Person) context.getBean("person1");
		person.say(new Pencil());
	}
}

/*
 * This PCD limits matching to join points where the runtime type of the actual
 * arguments passed have annotations of the given type(s).
 * 
 * 
 * 
 */
