package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import entity.Student;
import entity.mapper.StudentMapper;

public class StudentDAOImpl extends AbstractDAO implements StudentDAO {
	
	public StudentDAOImpl() {

	}
	
	public StudentDAOImpl(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Student getOne(int id) {
		Student student = null;
		try {
			String sqlString = "select * from student where id=?";
			student = jdbcTemplate.queryForObject( sqlString,new Object[]{id},new StudentMapper());
		} catch (Exception e) {
			System.out.println("this user not exist!");
		}
		return student;
	}

	public List<Student> listAll() {
		String sqlString = "SELECT * FROM student";
		List<Student> students = jdbcTemplate.query(sqlString, new StudentMapper()); // BeanPropertyRowMapper<Student>(Student.class)
		return students;
	}

	public boolean insert(Student student) {
		String sqlString = "insert into student(user_name,age) values(?,?)";
		int row = jdbcTemplate.update(sqlString,student.getUserName(),student.getAge());
		return true;
	}

	public boolean update(Student student) {
		String sqlString = "update student set user_name = ? ,age = ? where id = ?";
		int row = jdbcTemplate.update(sqlString,student.getUserName(),student.getAge(),student.getId());
		return true;
	}

	public boolean delete(int id) {
		String sqlString = "delete from student where id = ?";
		jdbcTemplate.update(sqlString, id);
		return false;
	}

}
