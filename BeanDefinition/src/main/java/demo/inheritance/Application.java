package demo.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/BeanInheritanceConfig.xml");
		
		/* class template */
		Student student = (Student) context.getBean("student");
		System.out.println(student);
		
		/* bean template */
		Student student2 = (Student) context.getBean("student2");
		System.out.println(student2);
	}
}
