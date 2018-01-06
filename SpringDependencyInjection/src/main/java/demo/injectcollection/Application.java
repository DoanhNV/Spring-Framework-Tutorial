package demo.injectcollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		Student student = (Student) context.getBean("student7");
		System.out.println(student.getMarks());
		System.out.println(student.getCars());
		System.out.println(student.getCompanies());
		System.out.println(student.getAddress());
	}
}
