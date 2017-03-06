package com.geovote;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.geovote.helper.CandidateID;
import com.geovote.helper.ElectionInfo;

@Entity
public class CandidateWeight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Embedded
	private CandidateID candidateID;
	@Embedded
	private ElectionInfo electionInfo;
	

}
