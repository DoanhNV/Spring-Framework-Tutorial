package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>{
	
	public User findById(int id);
	public User getById(int id);
	public User readById(int id);
	public User queryById(int id);
	
	/*public User fetchById(int id);*/
	
	public List<User> findDistinctByUserName(String userName);
	public User findByUserNameIgnoreCase(String userName);
	public User findByZipcode(int zipcode);
	public List<User> findDistinctByZipcode(int zipcode);
	
	public List<User> findByIdIn(List<Integer> ids);
	public List<User> findByIdNotIn(List<Integer> ids);
	public List<User> findByUserNameNotInOrderByIdDesc(List<String> userNames);
	
	public List<User> findByUserNameAndZipcodeGreaterThan(String userName, int zipcode);
	
	public List<User> findByUserNameIn(List<String> userNames,Sort sort);
	
	public Page<User> findAll(Pageable pageable);
}
