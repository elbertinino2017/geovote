package com.geovote.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.data.VoterDao;
import com.geovote.domain.Voter;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterDao dao;

	public void createNewVoter(Voter newVoter) {
		dao.create(newVoter);
	}

	public void deleteExistingVoter(Voter voterToDelete) {
		dao.delete(voterToDelete);
	}

	public void updateExixstingVoter(Voter voterToUpdate) {
		dao.update(voterToUpdate);
	}

	public List<Voter> retrieveAllVoters() {

		return dao.getAllVoters();
	}

}
