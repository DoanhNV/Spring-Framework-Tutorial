package demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationAutoWire {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config/SpringAutowireConfig.xml");
		
		/* Auto-Wire by name */
		Student student = (Student) context.getBean("student");
		System.out.println(student);
		
		/* Auto-Wire by type */
		Student student2 = (Student) context.getBean("student2");
		System.out.println(student2);
		
		/* Auto-Wire by constructor */
		Student student3 = (Student) context.getBean("student3");
		System.out.println(student3);
		
		context.close();
	}
}
