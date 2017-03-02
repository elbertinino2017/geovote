package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.Parish;

@Repository
public class ParishDaoJpaImpl implements ParishDao {

	
	@PersistenceContext
	EntityManager em;

	@Override
	public void create(Parish parish) {
		
		em.persist(parish);

	}

	@Override
	public void delete(Parish parish) {

		em.remove(parish);
	}

}
