package com.geovote.data;

import java.util.List;

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

	@Override
	public List<PollingStation> allPollingStations() {

		List<PollingStation> allPollingStations = em
				.createQuery("select pollingStation from PollingStation as pollingStation", PollingStation.class)
				.getResultList();

		return allPollingStations;
	}

	@Override
	public PollingStation getPollingStationByCode(String pollingStationCode) {

		PollingStation pollingStation = em.createQuery(
				"select pollingStation from PollingStation as pollingStation where pollingStation.code =:pollingStationCode",
				PollingStation.class).setParameter("pollingStationCode", pollingStationCode).getSingleResult();

		return pollingStation;
	}

}
