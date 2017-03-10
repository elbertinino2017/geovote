package com.geovote.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.result.domain.ThemePercentage;
import com.geovote.data.CandidateDao;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	
	@Autowired
	private CandidateDao dao;
	


	@Override
	public Candidate findCadidateByCode(String candidateRegistrationId) {
		return dao.findCandidateByCode(candidateRegistrationId);

	}



	@Override
	public List<ThemePercentage> findCandidatesThemePercentages(String code, String candidateId) {
		return dao.findCandidatesThemePercentages(code ,candidateId);
	}



	@Override
	public void createCandidatesThemePercentages(String code, String candidateId) {
		// TODO Auto-generated method stub
		
	}


/*
	@Override
	public void createCandidatesThemePercentages(String code, String candidateId) {
		dao.createCandidatesThemePercentages(code, candidateId);
		
	}*/

}
