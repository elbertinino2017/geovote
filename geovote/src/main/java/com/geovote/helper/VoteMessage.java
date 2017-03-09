package com.geovote.helper;

public class VoteMessage {

	public String electionCode;
	public String districtCode;
	public String constituencyCode;
	public String subCountyCode;
	public String parishCode;
	public String pollingStationCode;
	public Long currentVotes;
	
	
	public VoteMessage() {
	}
	
	
	public VoteMessage(String electionCode, String districtCode, String constituencyCode, String subCountyCode,
			String parishCode, String pollingStationCode, Long currentVotes) {
		super();
		this.electionCode = electionCode;
		this.districtCode = districtCode;
		this.constituencyCode = constituencyCode;
		this.subCountyCode = subCountyCode;
		this.parishCode = parishCode; 
		this.pollingStationCode = pollingStationCode;
		this.currentVotes = currentVotes;
	}


	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getConstituencyCode() {
		return constituencyCode;
	}

	public void setConstituencyCode(String constituencyCode) {
		this.constituencyCode = constituencyCode;
	}

	public String getSubCountyCode() {
		return subCountyCode;
	}

	public void setSubCountyCode(String subCountyCode) {
		this.subCountyCode = subCountyCode;
	}

	public String getParishCode() {
		return parishCode;
	}

	public void setParishCode(String parishCode) {
		this.parishCode = parishCode;
	}

	public String getPollingStationCode() {
		return pollingStationCode;
	}

	public void setPollingStationCode(String pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}



}
