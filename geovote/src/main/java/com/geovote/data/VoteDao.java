package com.geovote.data;

import com.geovote.representations.CountRecordRepresentation;

public interface VoteDao {
	

	public CountRecordRepresentation countVotes(String code);

}
