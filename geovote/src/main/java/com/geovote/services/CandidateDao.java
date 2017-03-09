package com.geovote.services;

import com.geovote.context.election.domain.Candidate;

public interface CandidateDao {

	Candidate findCandidateByCode(String candidateRegistrationId);

}
