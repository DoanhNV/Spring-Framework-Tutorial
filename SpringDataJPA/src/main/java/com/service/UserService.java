package com.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.entity.Country;
import com.entity.User;
import com.entity.projection.UserDTO;
import com.entity.projection.UserElement;
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
		Country country = new Country(1000, "USA");
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

	public void testReadElement() {
		Collection<UserElement> list = userRepository.findByUserNameContaining("gia");
		for (UserElement userElement : list) {
			System.out.println(userElement.getUserName() + " " + ": " + userElement.getCountry() + ": "
					+ userElement.getFullName());
		}
	}

	public void testReadForDTO() {
		Collection<UserDTO> list = userRepository.findByAge(21);
		for (UserDTO userElement : list) {
			System.out.println(userElement.getUserName() + " " + ": " + userElement.getAge());
		}
	}

	public void testDynamicProjection() {
		Collection<UserDTO> list1 = userRepository.findFirst3ByAge(21, UserDTO.class);
		for (UserDTO userElement : list1) {
			System.out.println(userElement.getUserName() + " " + ": " + userElement.getAge());
		}

		Collection<UserElement> list2 = userRepository.findFirst3ByAge(21, UserElement.class);
		for (UserElement userElement : list2) {
			System.out.println(userElement.getUserName() + " " + ": " + userElement.getCountry() + ": "
					+ userElement.getFullName());
		}
	}

	public void testExample() {
		User user = new User();
		user.setUserName("oan");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIncludeNullValues()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnorePaths("id","age","country");
		Example<User> example = Example.of(user,exampleMatcher);
		/*example.getMatcher().withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains());*/
		Iterable<User> users = userRepository.findAll(example);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}

	/*https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.data.geo.GeoResults
*/	public void testGeo() {
		Point center = new Point(-30.030277, -51.230339);
		Distance radius = new Distance(1, Metrics.KILOMETERS);
		/*GeoResults<User> users = userRepository.findByAddressLocationNear(center, radius);*/
		System.out.println();
	}
}
