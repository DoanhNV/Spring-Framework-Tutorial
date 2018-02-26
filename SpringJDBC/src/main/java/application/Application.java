package application;

import java.util.List;

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
		
		// CREATE
		/*Student student = new Student("ngo van doanh", 22);
		studentDAO.insert(student);*/
		
		// GET ONE
		Student student = studentDAO.getOne(1);
		System.out.println(student);
		
		// LIST ALL
		List<Student> students = studentDAO.listAll();
		System.out.println(students);
		
		// UPDATE
		Student updateStudent = new Student(2,"Doanh đẹp trai",21);
		studentDAO.update(updateStudent);
		
		// DELETE 
		studentDAO.delete(1);
		
		((AbstractApplicationContext)context).close();
	}
}
