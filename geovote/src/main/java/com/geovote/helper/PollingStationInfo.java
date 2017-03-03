package com.geovote.helper;

import javax.persistence.Embeddable;

@Embeddable
public class PollingStationInfo {

	private String pollingStationCode;
	private String pollingStationName;

	public PollingStationInfo() {
	}

	public PollingStationInfo(String pollingStationCode, String pollingStationName) {
		super();
		this.pollingStationCode = pollingStationCode;
		this.pollingStationName = pollingStationName;
	}

	public String getPollingStationCode() {
		return pollingStationCode;
	}

	public void setPollingStationCode(String pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

	public String getPollingStationName() {
		return pollingStationName;
	}

	public void setPollingStationName(String pollingStationName) {
		this.pollingStationName = pollingStationName;
	}

}
