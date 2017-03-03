package com.geovote.helper;

import javax.persistence.Embeddable;

@Embeddable
public class DistrictInfo {

	private String districtCode;
	private String districtName;

	public DistrictInfo() {
	}
	
	

	public DistrictInfo(String districtCode, String districtName) {
		super();
		this.districtCode = districtCode;
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String ditrictCode) {
		this.districtCode = ditrictCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
