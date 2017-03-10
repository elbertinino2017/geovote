package com.geovote.data;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.result.domain.ThemePercentage;

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


	@Override
	public List<ThemePercentage> findCandidatesThemePercentages(String code, String candidateId) {

		Candidate  foundCandidate = em.createQuery("select candidate from Candidate as candidate where candidate.candidateId =:candidateRegistrationId and candidate.candidatures.election.code=:code", Candidate.class)
									.setParameter("code", code)
									.setParameter("candidateRegistrationId", candidateId)
									.getSingleResult();
		return new ArrayList<ThemePercentage>(foundCandidate.getThemePercentages());
	}





	@Override
	public Candidate findElectionCandidateByCode(String code, String candidateRegistrationId) {
		return em.createQuery("select candidate from Candidate as candidate join candidate.candidatures as candidature "
				+ "where candidate.candidateId =:candidateRegistrationId and candidature.election.code=:code", Candidate.class)
				.setParameter("code", code)
				.setParameter("candidateRegistrationId", candidateRegistrationId)
				.getSingleResult();

	}


}
