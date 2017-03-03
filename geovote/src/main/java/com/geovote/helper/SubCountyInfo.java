package com.geovote.helper;

import javax.persistence.Embeddable;

@Embeddable
public class SubCountyInfo {

	private String subCountyCode;
	private String subCountyName;

	public SubCountyInfo() {
	}

	public SubCountyInfo(String subCountyCode, String subCountyName) {
		super();
		this.subCountyCode = subCountyCode;
		this.subCountyName = subCountyName;
	}

	public String getSubCountyCode() {
		return subCountyCode;
	}

	public void setSubCountyCode(String subCountyCode) {
		this.subCountyCode = subCountyCode;
	}

	public String getSubCountyName() {
		return subCountyName;
	}

	public void setSubCountyName(String subCountyName) {
		this.subCountyName = subCountyName;
	}

}
