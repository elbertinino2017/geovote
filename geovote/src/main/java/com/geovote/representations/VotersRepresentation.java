package com.geovote.representations;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.domain.Voter;

@XmlRootElement(name = "voters")
public class VotersRepresentation {

	private List<Voter> voters;

	public VotersRepresentation() {
	}

	public VotersRepresentation(List<Voter> voters) {
		this.voters = voters;
	}

	@XmlElement(name = "voter")
	public List<Voter> getVoters() {
		return voters;
	}

	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

}
