package com.repository.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.entity.Country;
import com.repository.CountryDAO;

@Component("countryRepositoryImpl")
public class CountryDAOImpl2  implements CountryDAO {

	public Country findById(int id) {
		System.out.println("Hello Doanh");
		return null;
	}

	public List<Country> findAll() {
		return null;
	}

	public List<Country> listAll() {
		return null;
	}

}
