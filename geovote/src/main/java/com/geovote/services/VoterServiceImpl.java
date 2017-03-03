package com.geovote.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.data.PollingStationDao;
import com.geovote.data.VoterDao;
import com.geovote.domain.PollingStation;
import com.geovote.domain.Voter;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterDao voterDao;
	@Autowired
	private PollingStationDao pollingStationDao;
	
	

	public void createNewVoter(Voter newVoter) {
		voterDao.create(newVoter);
	}

	public void deleteExistingVoter(Voter voterToDelete) {
		voterDao.delete(voterToDelete);
	}

	public void updateExixstingVoter(Voter voterToUpdate) {
		voterDao.update(voterToUpdate);
	}

	public List<Voter> retrieveAllVoters() {

		return voterDao.getAllVoters();
	}

	@Override
	public Voter findVoterByVoterId(String id) {

		return voterDao.getVoterById(id);
	}

	@Override
	public PollingStation findVotersPollingStation(String voterId) {

		Voter foundVoter = findVoterByVoterId(voterId);
		
		PollingStation foundVotersPollingStation = pollingStationDao.getPollingStationByCode(foundVoter.getPollingStationInfo().getPollingStationCode());
		
		return foundVotersPollingStation;
		
	}

}
