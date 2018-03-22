package com.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.entity.User;
import com.entity.projection.UserDTO;
import com.entity.projection.UserElement;

public interface UserRepository  extends CrudRepository<User, Integer>, QueryByExampleExecutor<User> {
	public List<User> findTop5ByAgeGreaterThan(int age);
	public List<User> findFirst1ByUserName(String userName);
	
	@EntityGraph(value = "testGraph",type  = EntityGraphType.FETCH , attributePaths = { "country" })
	public User findById(int id);
	
	public Collection<UserElement> findByUserNameContaining(String userName);
	
	public Collection<UserDTO> findByAge(int age);
	
	public <T> Collection<T> findFirst3ByAge(int age,Class<T> class1);
	
	/*GeoResults<User> findByAddressLocationNear(Point point, Distance distance);*/
}
