package com.geovote.helper;

import javax.persistence.Embeddable;

@Embeddable
public class ElectionInfo {

	private String electionCode;
	private String electionName;

	public ElectionInfo() {
	}

	public ElectionInfo(String electionCode, String electionName) {
		this.electionCode = electionCode;
		this.electionName = electionName;
	}

	public String getElectionCode() {
		return electionCode;
	}

	public void setElectionCode(String electionCode) {
		this.electionCode = electionCode;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

}
