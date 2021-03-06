package com.geovote.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConstituencyInfo {

	@Column(nullable=false)
	private String constituencyCode;
	@Column(nullable=false)
	private String constituencyName;

	public ConstituencyInfo() {
	}
	
	

	public ConstituencyInfo(String constituencyCode, String constituencyName) {
		super();
		this.constituencyCode = constituencyCode;
		this.constituencyName = constituencyName;
	}



	public String getConstituencyCode() {
		return constituencyCode;
	}

	public void setConstituencyCode(String constituencyCode) {
		this.constituencyCode = constituencyCode;
	}

	public String getConstituencyName() {
		return constituencyName;
	}

	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}

}
