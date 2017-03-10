package com.geovote.services;

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
import com.geovote.context.result.domain.ThemePercentage;
import com.geovote.data.CandidateDao;
import com.geovote.data.ElectionDao;
import com.geovote.data.ElectionService;
import com.geovote.data.PollingStationDao;
import com.geovote.data.ThemeDao;

@Service
@Transactional
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionDao electionDao;
	@Autowired
	private PollingStationDao pollingStationDao;
	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private ThemeDao themeDao;

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
		PollingStation votersPollingStation = pollingStationDao
				.getPollingStationByCode(vote.getVoter().getPollingStationInfo().getPollingStationCode());
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

	@Override
	public void createCandidatesThemePercentages(String code, String candidateId, String themeId,
			Double candidatePercentage) {

		Election foundElection = electionDao.getElectionByCode(code);
		Candidate electionsCandidate = candidateDao.findElectionCandidateByCode(code, candidateId);
		Theme foundTheme = themeDao.findElectionsThemeByCode(code, themeId);
		ThemePercentage themePercentage = new ThemePercentage(foundElection, electionsCandidate, foundTheme,
				candidatePercentage);

		electionsCandidate.addThemePercentage(themePercentage);
	}

	@Override
	public Theme findElectionsThemeByCode(String electionCode, String themCode) {
		return electionDao.findElectionsThemeByCode(electionCode, themCode);
	}

}
