package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.context.election.domain.Candidate;
import com.geovote.services.CandidateDao;

@Repository
public class CandidateDaoJpaImpl implements CandidateDao {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Candidate findCandidateByCode(String candidateRegistrationId) {
		return em.createQuery("select candidate from Candidate as candidate where candidate.candidateId =:candidateRegistrationId", Candidate.class)
				.setParameter("candidateRegistrationId", candidateRegistrationId)
				.getSingleResult();
	}

}
