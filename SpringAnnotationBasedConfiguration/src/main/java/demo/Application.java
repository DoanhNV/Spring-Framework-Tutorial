package demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		Person person1 = (Person)context.getBean("person1");
		System.out.println(person1);
		context.close();
	}
}
