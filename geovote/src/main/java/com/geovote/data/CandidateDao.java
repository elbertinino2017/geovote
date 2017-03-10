package com.geovote.data;

import java.util.List;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.result.domain.ThemePercentage;

public interface CandidateDao {

	Candidate findCandidateByCode(String candidateRegistrationId);
	
	Candidate findElectionCandidateByCode(String code,String candidateRegistrationId);

	List<ThemePercentage> findCandidatesThemePercentages(String code, String candidateId);

}
