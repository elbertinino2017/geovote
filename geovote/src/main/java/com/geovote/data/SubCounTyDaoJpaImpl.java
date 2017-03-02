package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.SubCounty;


@Repository
public class SubCounTyDaoJpaImpl implements SubCountyDao {

	
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(SubCounty subCounty) {

		em.persist(subCounty);
	}

	@Override
	public void delete(SubCounty subCounty) {

		em.remove(subCounty);
	}

}
