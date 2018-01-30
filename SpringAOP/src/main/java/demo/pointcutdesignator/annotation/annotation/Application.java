package demo.pointcutdesignator.annotation.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.designator.annotation.SpringConfig;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person person = (Person) context.getBean("person3");
		person.say(new Pencil(),"");
	}
}

