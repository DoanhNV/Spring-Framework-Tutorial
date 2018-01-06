package application;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class BeanFactoryApp {
	
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("config/SpringConfig.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		Entity bean = (Entity)beanFactory.getBean("bean1");
		System.out.println(bean.getUserName());
	}
}
