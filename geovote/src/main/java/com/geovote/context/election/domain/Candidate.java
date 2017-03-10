package com.geovote.context.election.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.context.result.domain.ThemePercentage;

@Entity
@XmlRootElement
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String candidateId;
	private String name;
	
	@OneToMany(mappedBy="candidate", cascade=CascadeType.ALL)
	private Set<Candidature> candidatures;
	
	@OneToMany(mappedBy="candidate", cascade=CascadeType.ALL)
	private Set<ThemePercentage> themePercentages;

	public Candidate() {

	}



	public Candidate(String candidateId, String name, Set<Candidature> candidatures,
			Set<ThemePercentage> themePercentages) {
		this.candidateId = candidateId;
		this.name = name;
		this.candidatures = candidatures;
		this.themePercentages = themePercentages;
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



	public Set<Candidature> getCandidatures() {
		return candidatures;
	}



	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}



	public Set<ThemePercentage> getThemePercentages() {
		return themePercentages;
	}



	public void setThemePercentages(Set<ThemePercentage> themePercentages) {
		this.themePercentages = themePercentages;
	}



	public void addThemePercentage(ThemePercentage themePercentage) {
		this.themePercentages.add(themePercentage);
	}

	

}
