package com.geovote.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.context.election.domain.Candidate;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	
	@Autowired
	private CandidateDao dao;
	


	@Override
	public Candidate findCadidateByCode(String candidateRegistrationId) {
		return dao.findCandidateByCode(candidateRegistrationId);

	}

}
