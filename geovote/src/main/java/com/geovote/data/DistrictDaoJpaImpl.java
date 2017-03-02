package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.District;


@Repository
public class DistrictDaoJpaImpl implements DistrictDao{

	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(District district) {
		
		em.persist(district);
	}

	@Override
	public void delete(District district) {
		
		em.remove(district);
		
	}

}
