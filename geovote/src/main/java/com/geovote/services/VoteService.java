package com.geovote.services;

import com.geovote.representations.CountRecordRepresentation;

public interface VoteService {
	
	public CountRecordRepresentation countPollingStationVotes(String code);

}
