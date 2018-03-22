package com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.internal.QueryImpl;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Country;
import com.repository.CountryDAO;

@Transactional
public class CountryDAOImpl implements CountryDAO {
	
	@PersistenceContext
	public EntityManager entityManager;

	public Country findById(int id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Country> query = builder.createQuery(Country.class);
		Root<Country> root = query.from(Country.class);
		query.where(builder.equal(root.get("id"), id));
		System.out.println(entityManager.createQuery(query).unwrap(QueryImpl.class).getQueryString());
		System.out.println(entityManager.createQuery(query).getSingleResult());
		return null;
	}

	public List<Country> findAll() {
		return null;
	}

	public List<Country> listAll() {
		return null;
	}

}
