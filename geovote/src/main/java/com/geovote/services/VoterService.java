package com.geovote.services;

import com.geovote.domain.Voter;

public interface VoterService 
{
	public void createNewVoter(Voter newVoter);
	public void deleteExistingVoter(Voter voterToDelete);
	public void updateExixstingVoter(Voter voterToUpdate);
}
