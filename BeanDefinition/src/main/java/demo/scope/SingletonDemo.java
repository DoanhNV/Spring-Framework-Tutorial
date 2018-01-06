package demo.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		
		SingletonEntity bean1 = (SingletonEntity)context.getBean("bean1");
		System.out.println(bean1);
		bean1.setUserName("Hello Doanh");
		
		SingletonEntity bean1Ref = (SingletonEntity)context.getBean("bean1");
		System.out.println(bean1Ref);
	}
}
