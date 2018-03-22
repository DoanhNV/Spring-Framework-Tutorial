package com.repository;

import com.entity.Country;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends CrudRepository<Country, Integer>, CountryDAO {
	
	@Query("select c from Country c where c.countryName = ?1")
	public List<Country> findUser(String countryName);
	
	@Query( value = "select * from Country where id >= ?1 and id <= ?2", nativeQuery = true )
	public List<Country> findUser(int min, int max);
	
	@Query("select c from Country c where c.countryName like %?1%")
	Page<Country> findUser(String countryName, Pageable pageable);
	
	@Query("select c, LENGTH(c.countryName) as fn_length from Country c where c.countryName like %?1%")
	List<Object[]> findUser(String countryName, Sort sort);
	
	@Query("select c from Country c where c.id = :id ")
	Country findUser(@Param("id") int id);
	
	@Query("select c from Country c where c.countryName like %:countryName% ")
	List<Country> findUserByUserName(@Param("countryName") String countryName);
}
