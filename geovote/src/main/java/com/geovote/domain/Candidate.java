package com.geovote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.helper.CandidateID;

@Entity
@XmlRootElement
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String candidateId;
	
	
	
	
	public CandidateID retrieveBasicInfo(){
		
		return new CandidateID(this.candidateId, this.name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public Long getId() {
		return id;
	}

	
	
	
}
