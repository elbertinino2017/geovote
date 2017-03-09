package com.geovote.representations;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.context.election.domain.Candidate;


@XmlRootElement(name="candidates")
public class CandidateCollectionRepresentstion {

	private List<Candidate> candidates;
	
	
	

	public CandidateCollectionRepresentstion() {

	}
	
	

	public CandidateCollectionRepresentstion(List<Candidate> candidates) {
		this.candidates = candidates;
	}


	@XmlElement(name="candidate")
	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	
}
