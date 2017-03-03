package com.geovote.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Constituency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String constituencyId;
	private String code;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONSTITUENCY_FK_ID")
	private Set<SubCounty> subCounties;
	
	public Constituency() {}


	public Constituency(String constituencyId, String code, String name, Set<SubCounty> subCounties) {
		super();
		this.constituencyId = constituencyId;
		this.code = code;
		this.name = name;
		this.subCounties = new HashSet<SubCounty>(subCounties);
	}

	public Constituency(String constituencyId, String code, String name) {
		super();
		this.constituencyId = constituencyId;
		this.code = code;
		this.name = name;
		this.subCounties = new HashSet<SubCounty>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constituencyId == null) ? 0 : constituencyId.hashCode());
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
		Constituency other = (Constituency) obj;
		if (constituencyId == null) {
			if (other.constituencyId != null)
				return false;
		} else if (!constituencyId.equals(other.constituencyId))
			return false;
		return true;
	}

	public String getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(String constituencyId) {
		this.constituencyId = constituencyId;
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

	public Set<SubCounty> getSubCounties() {
		return subCounties;
	}

	public void setSubCounties(Set<SubCounty> subCounties) {
		this.subCounties = subCounties;
	}

}
