package dao;

import java.util.List;

import entity.Student;

public interface StudentDAO {
	public Student getOne(int id);
	
	public List<Student> listAll();
	
	public boolean insert(Student student);
	
	public boolean update(Student student);
	
	public boolean delete(int id);
	
}
