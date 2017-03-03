package com.geovote.data;

import java.util.List;

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

	@Override
	public List<District> allDistricts() {

		return em.createQuery("select district from District as district", District.class)
				.getResultList();
	}

	@Override
	public District getDistrictByCode(String code) {
		
		return em.createQuery("select district from District as district where district.code=:code", District.class)
				.setParameter("code", code)
				.getSingleResult();
	}

}
