package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.entity.Country;
import com.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public void testcreate() {
		countryRepository.save(new Country(20, "VietNam"));
	}
	
	@SuppressWarnings("deprecation")
	public void testRead() {
		countryRepository.findById(1);
		System.out.println(countryRepository.findById(new Integer(1)).get());
		System.out.println(countryRepository.findUser("VietNam"));
		System.out.println(countryRepository.findUser(3, 4));
		System.out.println(countryRepository.findUser("viet", new PageRequest(1, 2, Direction.DESC, "id")));
		System.out.println(countryRepository.count());
		List<Object[]> list = countryRepository.findUser("viet", new Sort("fn_length"));
		for (Object[] objects : list) {
			Country country = (Country)objects[0];
			System.out.println(country);
		}
		System.out.println("JPA: countryRepository.findUser(2): " + countryRepository.findUser(2));
		System.out.println("JPA: " + countryRepository.findUserByUserName("v"));
	}
}
