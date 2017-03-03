package com.geovote.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.Parish;
import com.geovote.domain.Voter;

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

	@Override
	public List<Parish> getAllParishes() {
		
		List<Parish> allParishes = em.createQuery("select parish from Parish as parish", Parish.class).getResultList();

		return allParishes;
	}

}
