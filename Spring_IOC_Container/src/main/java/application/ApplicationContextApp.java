package application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		Entity entity = (Entity)context.getBean("bean1");
		System.out.println(entity.getUserName());
		Entity entity2 = (Entity)context.getBean(Entity.class);
		System.out.println(entity2.getUserName());
	}
}
