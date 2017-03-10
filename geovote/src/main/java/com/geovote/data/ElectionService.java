package com.geovote.data;

import java.util.List;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Candidature;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;
import com.geovote.context.election.domain.Vote;

public interface ElectionService {

	public void createNewElection(Election newElection);

	public List<Candidate> findElectionsCandidates(String code);

	public Election findElectionByCode(String code);

	public void registerCandidateForElection(String code, Candidature candidature);

	public void registerVoteForElection(String code, Vote Vote);

	public void registerThemeForElection(String code, Theme theme);

	public List<Theme> findElectionsThemes(String code);
	
	public Theme findElectionsThemeByCode(String electionCode, String themCode);


	public void createCandidatesThemePercentages(String code, String candidateId, String  themeId, Double candidatePercentage);




}
