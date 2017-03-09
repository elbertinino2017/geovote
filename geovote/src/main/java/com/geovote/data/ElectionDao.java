package com.geovote.data;

import java.util.List;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;

public interface ElectionDao {

	public void create(Election newElection);

	public List<Candidate> getElectionsCandidates(String code);

	public Election getElectionByCode(String code);

	public List<Theme> findElectionsThemes(String code);

}
