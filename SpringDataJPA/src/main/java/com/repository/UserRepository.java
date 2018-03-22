package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;

import com.entity.User;

public interface UserRepository  extends CrudRepository<User, Integer> {
	public List<User> findTop5ByAgeGreaterThan(int age);
	public List<User> findFirst1ByUserName(String userName);
	
	@EntityGraph(value = "testGraph",type  = EntityGraphType.FETCH , attributePaths = { "country" })
	public User findById(int id);
}
