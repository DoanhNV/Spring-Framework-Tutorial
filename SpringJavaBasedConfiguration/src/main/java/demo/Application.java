package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.SpringConfig;
import demo.entity.Pencil;
import demo.entity.Student;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Student student = (Student) context.getBean("student1");
		Pencil pencil = new Pencil();
		pencil.setColor("red");
		student.setPencil(pencil);
		System.out.println(student);
		
		Student studentScope = (Student) context.getBean("student1");
		System.out.println(studentScope);
		
		Student student2 = (Student) context.getBean("student2");
		System.out.println(student2);
		context.close();
	}
}
