package com.repository;

import java.util.List;

import com.entity.Country;

public interface CountryDAO {
	public Country findById(int id);

	public List<Country> findAll();

	public List<Country> listAll();
}
