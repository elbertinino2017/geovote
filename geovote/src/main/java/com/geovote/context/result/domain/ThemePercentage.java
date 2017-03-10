package com.geovote.context.result.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;

@Entity
public class ThemePercentage implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "election_id")
	private Election election;

	@Id
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@Id
	@ManyToOne
	@JoinColumn(name = "theme_id")
	private Theme theme;

	private Double percentage;

	public ThemePercentage() {

	}

	public ThemePercentage(Election election, Candidate candidate, Theme theme, Double percentage) {
		super();
		this.election = election;
		this.candidate = candidate;
		this.theme = theme;
		this.percentage = percentage;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
