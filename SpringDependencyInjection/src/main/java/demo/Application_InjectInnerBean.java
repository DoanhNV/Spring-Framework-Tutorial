package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application_InjectInnerBean {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		Student student6 =  (Student) context.getBean("student6");
		System.out.println(student6);
	}
}
