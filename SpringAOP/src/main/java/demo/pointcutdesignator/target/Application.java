package demo.pointcutdesignator.target;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;
/* 
 * Reference: https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch08s06.html,
 *  https://spring.io/blog/2012/05/23/transactions-caching-and-aop-understanding-proxy-usage-in-spring
 */

/*
 * If you get Exception like this : java.lang.ClassCastException: $Proxy0 cannot be cast to com.somaniab.blog.ex.Example1 ,
 *  it means your target class does not implement the interface.
 */
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person2 person = (Person2) context.getBean("person3");
		person.showName();
		person.display();
	}
}	
