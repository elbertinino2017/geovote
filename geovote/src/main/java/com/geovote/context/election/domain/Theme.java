package com.geovote.context.election.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.context.result.domain.ThemePercentage;
import com.geovote.context.result.domain.Weight;
import com.geovote.helper.ElectionInfo;

@Entity
@XmlRootElement
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String code;
	private String name;
	@Embedded
	private Weight weight;
	@Embedded
	ElectionInfo electionInfo;

	@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
	private Set<ThemePercentage> themePercentages;



	public Theme() {

	}

	public Theme(String code, String name, Weight weight, ElectionInfo electionInfo,
			Set<ThemePercentage> themePercentages) {
		this.code = code;
		this.name = name;
		this.weight = weight;
		this.electionInfo = electionInfo;
		this.themePercentages = themePercentages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public ElectionInfo getElectionInfo() {
		return electionInfo;
	}

	public void setElectionInfo(ElectionInfo electionInfo) {
		this.electionInfo = electionInfo;
	}

	public Set<ThemePercentage> getThemePercentages() {
		return themePercentages;
	}

	public void setThemePercentages(Set<ThemePercentage> themePercentages) {
		this.themePercentages = themePercentages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
