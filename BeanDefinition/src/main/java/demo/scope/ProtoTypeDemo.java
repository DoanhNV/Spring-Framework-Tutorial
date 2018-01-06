package demo.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProtoTypeDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
		ProtoTypeEntity bean = context.getBean(ProtoTypeEntity.class);
		System.out.println(bean);
		bean.setUserName("Hello Doanh");
		
		ProtoTypeEntity bean2 = context.getBean(ProtoTypeEntity.class);
		System.out.println(bean2);
	}
}
