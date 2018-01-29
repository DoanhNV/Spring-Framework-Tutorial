package demo.pointcutdesignator.args;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;

public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person3 person = (Person3) context.getBean("person4");
		person.showName(3L);
		person.display();
		person.printAge(3L);
		person.printPerson(3L, "Ngô Văn Doanh");
	}
}	
