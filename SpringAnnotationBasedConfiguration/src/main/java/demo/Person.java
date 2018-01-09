package demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Person {
	private Phone phone;
	
	public Person() {

	}

	public Phone getPhone() {
		return phone;
	}
	
	/* Only use for property setter*/
	@Required
	@Autowired
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "[phone=" + phone + "]";
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy methhod");
	}
}
