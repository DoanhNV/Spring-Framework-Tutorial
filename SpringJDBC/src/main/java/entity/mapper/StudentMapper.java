package entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet result, int arg1) throws SQLException {
		int id = result.getInt("id");
		String userName = result.getString("user_name");
		int age = result.getInt("age");
		return new Student(id, userName, age);
	}
	
}
