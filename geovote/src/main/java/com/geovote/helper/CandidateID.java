package com.geovote.helper;

import javax.persistence.Embeddable;

@Embeddable
public class CandidateID {
	

	private String canditateId;
	private String candidateName;
	
	
	public CandidateID(String candidateId, String name) {
		this.canditateId = candidateId;
		this.candidateName = name;
		
	}


	public String getCanditateId() {
		return canditateId;
	}


	public void setCanditateId(String canditateId) {
		this.canditateId = canditateId;
	}


	public String getCandidateName() {
		return candidateName;
	}


	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	
	

}
