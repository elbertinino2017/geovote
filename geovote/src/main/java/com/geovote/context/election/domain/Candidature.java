package com.geovote.context.election.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Candidature implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Id
	@ManyToOne
	@JoinColumn(name="election_id")
	private Election election;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registration_date")
	private Date date;
	private String signature;
	
	public Candidature(){
		
	}



	public Candidature(Candidate candidate, Election election, Date date, String signature) {
		super();
		this.candidate = candidate;
		this.election = election;
		this.date = date;
		this.signature = signature;
	}



	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public String getSignature() {
		return signature;
	}



	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	

}
