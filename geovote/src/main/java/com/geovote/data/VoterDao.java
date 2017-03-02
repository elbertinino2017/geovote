package com.geovote.data;

import java.util.List;

import com.geovote.domain.Voter;

public interface VoterDao {
	public void create(Voter newVoter);

	public void update(Voter voterToUpdate);

	public void delete(Voter voterToDelete);

	public List<Voter> getAllVoters();

}
