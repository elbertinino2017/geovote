package com.geovote.representations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.Parish;

@XmlRootElement(name = "parishes")
public class ParishesCollectionRepresentation {

	private List<Parish> parishes;

	public ParishesCollectionRepresentation() {
	}

	public ParishesCollectionRepresentation(List<Parish> parishes) {
		this.parishes = parishes;
	}

	public ParishesCollectionRepresentation(Set<Parish> parishes) {
		this.parishes = new ArrayList<Parish>(parishes);
	}



	@XmlElement(name = "parish")
	public List<Parish> getParishes() {
		return parishes;
	}

	public void setParishes(List<Parish> parishes) {
		this.parishes = parishes;
	}

}
