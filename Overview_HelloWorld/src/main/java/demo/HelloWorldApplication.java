package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldApplication {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/Beans.xml");
		Activity bean = (Activity)context.getBean("Bean1");
		System.out.println(bean.getName());
	}
}
