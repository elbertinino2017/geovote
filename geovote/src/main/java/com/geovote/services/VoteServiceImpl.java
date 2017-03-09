package com.geovote.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.geovote.data.VoteDao;
import com.geovote.representations.CountRecordRepresentation;

public class VoteServiceImpl  implements VoteService{

	@Autowired
	private VoteDao dao;
	
	
	
	@Override
	public CountRecordRepresentation countPollingStationVotes(String code) {
		return dao.countVotes(code);
	}

}
