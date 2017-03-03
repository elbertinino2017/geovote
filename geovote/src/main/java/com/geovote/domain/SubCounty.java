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
public class SubCounty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String subCountyId;
	private String code;
	private String name; 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="SUB_COUNTY_FK_ID")
	private Set<Parish> parishes;
	
	
	
	
	public SubCounty() {}

	public SubCounty(String subCountyId, String code, String name, Set<Parish> parishes) {
		super();
		this.subCountyId = subCountyId;
		this.code = code;
		this.name = name;
		this.parishes = new HashSet<Parish>(parishes);
	}

	
	



	public SubCounty(String subCountyId, String code, String name) {
		super();
		this.subCountyId = subCountyId;
		this.code = code;
		this.name = name;
		this.parishes = new HashSet<Parish>();

	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subCountyId == null) ? 0 : subCountyId.hashCode());
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
		SubCounty other = (SubCounty) obj;
		if (subCountyId == null) {
			if (other.subCountyId != null)
				return false;
		} else if (!subCountyId.equals(other.subCountyId))
			return false;
		return true;
	}

	public String getSubCountyId() {
		return subCountyId;
	}

	public void setSubCountyId(String subCountyId) {
		this.subCountyId = subCountyId;
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

	public Set<Parish> getParishes() {
		return parishes;
	}

	public void setParishes(Set<Parish> parishes) {
		this.parishes = parishes;
	}
	
	
	
	
	

}
