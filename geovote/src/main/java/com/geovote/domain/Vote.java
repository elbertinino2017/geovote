package com.geovote.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.geovote.helper.ElectionInfo;
import com.geovote.helper.VoterInfo;

@Entity
public class Vote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Embedded
	private ElectionInfo electionInfo;
	@Embedded
	private VoterInfo voterInfo;
	private String date;
	
	
	
	
	public ElectionInfo getElectionInfo() {
		return electionInfo;
	}
	public void setElectionInfo(ElectionInfo electionInfo) {
		this.electionInfo = electionInfo;
	}
	public VoterInfo getVoterInfo() {
		return voterInfo;
	}
	public void setVoterInfo(VoterInfo voterInfo) {
		this.voterInfo = voterInfo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	


}
