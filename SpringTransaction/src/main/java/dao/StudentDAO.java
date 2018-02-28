package dao;

import entity.Student;

public interface StudentDAO {
	public int updateIfExist(Student student);
}
