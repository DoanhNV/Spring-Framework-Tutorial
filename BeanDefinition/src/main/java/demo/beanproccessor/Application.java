package demo.beanproccessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config/BeanProccessorConfig.xml");
		HelloWorld bean = context.getBean(HelloWorld.class);
		System.out.println("at main Application "+bean);
		context.registerShutdownHook();
	}
}
