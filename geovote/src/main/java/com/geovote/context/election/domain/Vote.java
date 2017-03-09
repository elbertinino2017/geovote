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
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.context.administrative.domain.Voter;

@Entity
@XmlRootElement
public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "voter_id")
	private Voter voter;

	@Id
	@ManyToOne
	@JoinColumn(name = "election_id")
	private Election election;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vote_date")
	private Date date;

	public Vote() {

	}

	private String signature;

	public Vote(Voter voter, Election election, Date date, String signature) {
		super();
		this.voter = voter;
		this.election = election;
		this.date = date;
		this.signature = signature;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
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
