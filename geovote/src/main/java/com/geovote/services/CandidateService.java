package com.geovote.services;

import java.util.List;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.result.domain.ThemePercentage;

public interface CandidateService {

	public  Candidate findCadidateByCode(String candidateRegistrationId);

	public List<ThemePercentage> findCandidatesThemePercentages(String code, String candidateId);

	public void createCandidatesThemePercentages(String code, String candidateId);


}
