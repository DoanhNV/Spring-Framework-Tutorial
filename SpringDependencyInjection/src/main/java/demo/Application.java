package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		
		/* Reference */
		Student student = (Student)context.getBean("student1");
		System.out.println(student);
		
		
		/* Index */
		Student student2 = (Student)context.getBean("student2");
		System.out.println(student2);
		
		
		/* Type */
		Student student3 = (Student) context.getBean("student3");
		System.out.println(student3);
		
		
		// SETTER METHOD
		Student student4  = (Student) context.getBean("student4");
		System.out.println(student4);
		
		
		/* Short way */
		Student student5 = (Student) context.getBean("student5");
		System.out.println(student5);
	}
}
