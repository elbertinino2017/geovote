package com.geovote.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.context.administrative.domain.SubCounty;


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

	@Override
	public List<SubCounty> allSubCountyes() {
		
		return em.createQuery("select subCounty from SubCounty as subCounty", SubCounty.class).getResultList();
	}

	@Override
	public SubCounty getSubCountyByCode(String code) {

		return em.createQuery("select subCounty from SubCounty as subCounty where code=:code", SubCounty.class)
				 .setParameter("code", code)
				 .getSingleResult();
	}

}
