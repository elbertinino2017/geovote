package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.representations.CountRecordRepresentation;

@Repository
public class VoteDaoJpaImpl implements VoteDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CountRecordRepresentation countVotes(String code) {

		return null;
	}



}
