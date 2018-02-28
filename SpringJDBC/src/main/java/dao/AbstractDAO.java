package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO {
	protected DataSource datasource;
	protected JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
}
