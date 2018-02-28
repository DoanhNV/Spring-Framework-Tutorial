package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class AbstractDAO {
	protected JdbcTemplate jdbcTemplate;
	protected DataSource dataSource;
	protected PlatformTransactionManager transactionManager;
}
