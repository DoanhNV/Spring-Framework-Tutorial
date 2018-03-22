package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void testCreate() {
		// CREATE
		userRepository.save(new User("DoanhNV", 1000000));
		userRepository.save(new User("Long", 2000000));
		userRepository.save(new User("Manh", 3000000));
		userRepository.save(new User("Vu", 5120000));
		userRepository.save(new User("Minh", 8000000));
	}
	
	public void testRead() {
		System.out.println(userRepository.findById(1));
		System.out.println(userRepository.getById(1));
		System.out.println(userRepository.readById(1));
		System.out.println(userRepository.queryById(1));
		
		System.out.println(userRepository.findDistinctByUserName("doanhnv"));
		System.out.println(userRepository.findByUserNameIgnoreCase("Minh"));
		System.out.println(userRepository.findByZipcode(5120000));
		System.out.println(userRepository.findDistinctByZipcode(1000000));
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		System.out.println(userRepository.findByIdIn(ids));
		System.out.println(userRepository.findByIdNotIn(ids));
		List<String> userNames = new ArrayList<String>();
		userNames.add("doanhNV");
		userNames.add("Minh");
		System.out.println(userRepository.findByUserNameNotInOrderByIdDesc(userNames));
		System.out.println(userRepository.findByUserNameAndZipcodeGreaterThan("doanhnv", 1000));
	}
	
	
	public void testSort() {
		List<String> userNames = new ArrayList<String>();
		userNames.add("doanhNV");
		userNames.add("Minh");
		userNames.add("Long");
		userNames.add("Vu");
		Sort sort = new Sort(Sort.Direction.DESC,"zipcode");
		System.out.println(userRepository.findByUserNameIn(userNames,sort));;
	}
	
	public void testPageing() {
		int currentPage = 0;
		int itemPerPage = 2;
		Pageable pageable = new PageRequest(currentPage,itemPerPage,Direction.DESC,"userName");
		Page<User> userPages = userRepository.findAll(pageable);
		List<User> users = userPages.getContent();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
