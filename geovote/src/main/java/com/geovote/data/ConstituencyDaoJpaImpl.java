package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.Constituency;

@Repository
public class ConstituencyDaoJpaImpl implements ConstituencyDao {
	
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void create(Constituency constituency) {
		
		em.persist(constituency);
	}

	@Override
	public void delete(Constituency constituency) {
		
		em.remove(constituency);
	}

}
