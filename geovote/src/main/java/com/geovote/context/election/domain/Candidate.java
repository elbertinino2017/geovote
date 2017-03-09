package com.geovote.context.election.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String candidateId;
	private String name;
	@OneToMany(mappedBy="candidate")
	private Set<Candidature> candidatures;

	public Candidate() {

	}

	public Candidate(String candidateId, String name, Set<Candidature> registrations) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.candidatures = registrations;
	}


	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Candidature> getRegistrations() {
		return candidatures;
	}

	public void setRegistrations(Set<Candidature> registrations) {
		this.candidatures = registrations;
	}

	

}
