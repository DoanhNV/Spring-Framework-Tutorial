package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;

public class Application {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Student student = (Student) context.getBean("student1");
		student.showName();
		student.getUserName();
		try {
			student.testThrow();
		} catch (Exception e) {
		}
		student.testAround();
	}
}
