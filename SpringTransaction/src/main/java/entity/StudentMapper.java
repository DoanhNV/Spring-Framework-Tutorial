package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet result, int rowNum) throws SQLException {
		int id = result.getInt("id");
		String userName = result.getString("user_name");
		int age = result.getInt("age");
		return new Student(id, userName, age);
	}

}
