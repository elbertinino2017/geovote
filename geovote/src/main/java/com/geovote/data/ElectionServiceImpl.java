package com.geovote.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.context.administrative.domain.PollingStation;
import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Candidature;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;
import com.geovote.context.election.domain.Vote;

@Service
@Transactional
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionDao electionDao;

	@Autowired
	private PollingStationDao pollingStationDao;
	
	@Override
	public void createNewElection(Election newElection) {
		electionDao.create(newElection);
	}

	@Override
	public List<Candidate> findElectionsCandidates(String code) {
		return electionDao.getElectionsCandidates(code);
	}

	@Override
	public Election findElectionByCode(String code) {
		return electionDao.getElectionByCode(code);
	}

	@Override
	public void registerCandidateForElection(String code, Candidature candidature) {

		Election foundElection = electionDao.getElectionByCode(code);
		foundElection.addCandidate(candidature);
		
	}

	@Override
	public void registerVoteForElection(String code, Vote vote) {
		
		Election foundElection = electionDao.getElectionByCode(code);
		foundElection.addVote(vote);
		PollingStation votersPollingStation = pollingStationDao.getPollingStationByCode(vote.getVoter().getPollingStationInfo().getPollingStationCode());
		votersPollingStation.updateCurrentVotes();
		
	}

	@Override
	public void registerThemeForElection(String code, Theme theme) {

		Election foundElection = electionDao.getElectionByCode(code);
		foundElection.addTheme(theme);

	}

	@Override
	public List<Theme> findElectionsThemes(String code) {

		return electionDao.findElectionsThemes(code);
	}

}
