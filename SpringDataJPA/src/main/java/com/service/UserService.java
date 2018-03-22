package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Country;
import com.entity.User;
import com.repository.CountryRepository;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CountryRepository countryRepository;
	
	public void testCreate() {
		userRepository.save(new User("Doanh", 21));
		userRepository.save(new User("phong", 20));
		userRepository.save(new User("Trung", 22));
		userRepository.save(new User("Minh", 21));
		userRepository.save(new User("Long", 26));
	}
	
	public void testCreate2() {
		User user = new User("Gia Cát", 21);
		Country country = new Country(1000,"USA");
		user.setCountry(country);
		countryRepository.save(country);
		userRepository.save(user);
	}
	
	public void testReadLimit() {
		System.out.println(userRepository.findTop5ByAgeGreaterThan(20));
		System.out.println(userRepository.findFirst1ByUserName("phong"));
	}
	
	public User testFindLazy(int id) {
		return userRepository.findById(id);
	}
}
