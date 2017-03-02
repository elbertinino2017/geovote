package com.geovote.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.geovote.domain.PollingStation;

@Repository
public class PolligStationDoaImpl implements PollingStationDao {

	
	@PersistenceContext
	EntityManager em;

	@Override
	public void create(PollingStation pollingStation) {

		em.persist(pollingStation);
	
	}

	@Override
	public void delete(PollingStation pollingStation) {
		
		em.remove(pollingStation);

	}

}
