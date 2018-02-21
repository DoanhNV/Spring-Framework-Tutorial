package application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ApplicationConfig;
import dao.StudentDAO;
import entity.Student;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentDAO studentDAO = context.getBean(StudentDAO.class);
		
		// CREATE
		/*Student student = new Student("ngo van doanh", 22);
		studentDAO.insert(student);*/
		
		// GET ONE
		Student student = studentDAO.getOne(1);
		System.out.println(student);
	}
}
