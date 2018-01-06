package demo.beanproccessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		HelloWorld bean1 = (HelloWorld)bean;
		System.out.println("edit bean - postProcessBeforeInitialization " + bean1);
		bean1.setMessage("Hello Doanh");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		HelloWorld bean1 = (HelloWorld)bean;
		System.out.println("edit  bean - postProcessBeforeInitialization " + bean1);
		bean1.setMessage("Hi Doanh ");
		return bean;
	}
	
	
}
