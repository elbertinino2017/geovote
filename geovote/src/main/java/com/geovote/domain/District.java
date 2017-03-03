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
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String districtId;
	private String code;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "DISTRICT_FK_ID")
	private Set<Constituency> constituencies;

	public District() {
	}

	public District(String districtId, String code, String name, Set<Constituency> constituencies) {
		super();
		this.districtId = districtId;
		this.code = code;
		this.name = name;
		this.constituencies = new HashSet<Constituency>(constituencies);
	}

	public District(String districtId, String code, String name) {
		super();
		this.districtId = districtId;
		this.code = code;
		this.name = name;
		this.constituencies = new HashSet<Constituency>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtId == null) ? 0 : districtId.hashCode());
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
		District other = (District) obj;
		if (districtId == null) {
			if (other.districtId != null)
				return false;
		} else if (!districtId.equals(other.districtId))
			return false;
		return true;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
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

	public Set<Constituency> getConstituencies() {
		return constituencies;
	}

	public void setConstituencies(Set<Constituency> constituencies) {
		this.constituencies = constituencies;
	}

}
