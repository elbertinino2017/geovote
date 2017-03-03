package com.geovote.representations;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.Constituency;

@XmlRootElement(name = "constituencies")
public class ConstituencyCollectionRepresentation {

	private List<Constituency> constituencies;

	public ConstituencyCollectionRepresentation() {
	}

	public ConstituencyCollectionRepresentation(List<Constituency> constituencies) {
		this.constituencies = constituencies;
	}

	@XmlElement(name = "constituency")
	public List<Constituency> getConstituencies() {
		return constituencies;
	}

	public void setConstituencies(List<Constituency> constituencies) {
		this.constituencies = constituencies;
	}

}
