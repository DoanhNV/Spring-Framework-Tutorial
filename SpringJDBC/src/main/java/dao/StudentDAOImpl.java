package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import entity.Student;
import entity.mapper.StudentMapper;

public class StudentDAOImpl implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public StudentDAOImpl() {

	}
	
	public StudentDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Student getOne(int id) {
		String sqlString = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(sqlString,Student.class,id);
		return student;
	}

	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Student student) {
		String sqlString = "insert into student(user_name,age) values(?,?)";
		int row = jdbcTemplate.update(sqlString,student.getUserName(),student.getAge());
		return true;
	}

	public boolean update(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
