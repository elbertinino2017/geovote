package com.geovote.representations;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "count")
public class CountRecordRepresentation {

	private Long totalCount;

	public CountRecordRepresentation() {

	}

	public CountRecordRepresentation(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
