package com.geovote.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DistrictInfo {

	@Column(nullable=false)
	private String districtCode;
	@Column(nullable=false)
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
