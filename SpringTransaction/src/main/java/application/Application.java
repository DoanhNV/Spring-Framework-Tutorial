package application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.ApplicationConfig;
import dao.StudentDAO;
import entity.Student;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentDAO studentDAO = context.getBean(StudentDAO.class);
		Student student = new Student(2, "Hello Doanh", 22);
		studentDAO.updateIfExist(student);
		((AbstractApplicationContext)context).close();
	}
}
