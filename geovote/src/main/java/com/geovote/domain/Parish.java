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
public class Parish {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String parishId;
	private String code;
	private String name; 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PARISH_FK_ID")
	private Set<PollingStation> pollingStations;
	
	
	public Parish(String parishId, String code, String name, Set<PollingStation> pollingStations) {
		super();
		this.parishId = parishId;
		this.code = code;
		this.name = name;
		this.pollingStations = new HashSet<PollingStation> (pollingStations); 
	}

	
	

	public Parish(String parishId, String code, String name) {
		super();
		this.parishId = parishId;
		this.code = code;
		this.name = name;
		this.pollingStations = new HashSet<PollingStation> (); 

	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parishId == null) ? 0 : parishId.hashCode());
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
		Parish other = (Parish) obj;
		if (parishId == null) {
			if (other.parishId != null)
				return false;
		} else if (!parishId.equals(other.parishId))
			return false;
		return true;
	}
	

	
	

}
