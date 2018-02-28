package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import entity.Student;

public class StudentDAOImpl extends AbstractDAO implements StudentDAO {

	public StudentDAOImpl(DataSource dataSource, PlatformTransactionManager transactionManager) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.transactionManager = transactionManager;
	}

	public int updateIfExist(Student student) {
		int result = 1;
		TransactionDefinition df = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(df);
		try {
			String querySQL = "select * from student where id=?";
			Student queryStudent = jdbcTemplate.queryForObject(querySQL,new BeanPropertyRowMapper<Student>(Student.class), student.getId());
			if (queryStudent != null) {
				System.out.println("this student not exist!");
				throw new Exception("this student not exist!");
			}

			String updateSql = "update student set id = ?, user_name = ?, age = ?";
			jdbcTemplate.update(updateSql, student.getId(), student.getUserName(), student.getAge());
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
			transactionManager.rollback(status);
		}
		return result;
	}
}
