package com.geovote.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;


@Repository
public class ElectionDaoJpaImpl implements ElectionDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Election newElection) {
		em.persist(newElection);
	}

	@Override
	public List<Candidate> getElectionsCandidates(String code) {
		
		return em.createQuery("select candidate from Candidate as candidate where candidate.electionInfo.electionCode =:code",Candidate.class)
				.setParameter("code", code)
				.getResultList();
	}

	@Override
	public Election getElectionByCode(String code) {

		return em.createQuery("select election from Election as election  where election .code =:code",Election.class)
				.setParameter("code", code)
				.getSingleResult();
	}

	@Override
	public List<Theme> findElectionsThemes(String code) {
		
		return em.createQuery("select theme from Theme as theme where theme.code =:code",Theme.class)
				.setParameter("code", code)
				.getResultList();
	}

	@Override
	public Theme findElectionsThemeByCode(String electionCode, String themCode) {

		Election foundElection = em.createQuery("select election from Election as election  where election .code =:code",Election.class)
				.setParameter("code", electionCode)
				.getSingleResult();
		
		for(Theme next : foundElection.getThemes()){
			
			if(next.getClass().equals(themCode))
			{
				return next;
			}
		}
		
		return null;
	}



}
