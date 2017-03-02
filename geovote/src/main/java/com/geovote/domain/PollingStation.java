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
public class PollingStation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String pollingStationId;
	private String code;
	private String name; 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="POLLING_STATION_FK_ID")
	private Set<Voter> voters;
	
	
	public PollingStation(String pollingStationId, String code, String name, Set<Voter> voters) {
		super();
		this.pollingStationId = pollingStationId;
		this.code = code;
		this.name = name;
		this.voters = new HashSet<Voter>(voters);
	}

	
	

	public PollingStation(String pollingStationId, String code, String name) {
		super();
		this.pollingStationId = pollingStationId;
		this.code = code;
		this.name = name;
		this.voters = new HashSet<Voter>();

	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pollingStationId == null) ? 0 : pollingStationId.hashCode());
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
		PollingStation other = (PollingStation) obj;
		if (pollingStationId == null) {
			if (other.pollingStationId != null)
				return false;
		} else if (!pollingStationId.equals(other.pollingStationId))
			return false;
		return true;
	}
	
	
	

}
