package com.geovote.helper;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParishInfo {

	@Column(nullable=false)
	private String parishCode;
	@Column(nullable=false)
	private String parishName;

	public ParishInfo() {

	}

	
	public ParishInfo(String parishCode, String parishName) {
		super();
		this.parishCode = parishCode;
		this.parishName = parishName;
	}




	public String getParishCode() {
		return parishCode;
	}

	public void setParishCode(String parishCode) {
		this.parishCode = parishCode;
	}

	public String getParishName() {
		return parishName;
	}

	public void setParishName(String parishName) {
		this.parishName = parishName;
	}

}
