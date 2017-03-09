package com.geovote.services;

import com.geovote.context.election.domain.Candidate;

public interface CandidateService {

	public  Candidate findCadidateByCode(String candidateRegistrationId);


}
