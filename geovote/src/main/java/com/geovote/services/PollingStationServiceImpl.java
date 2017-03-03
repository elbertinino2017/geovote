package com.geovote.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.data.PollingStationDao;
import com.geovote.domain.PollingStation;


@Service
@Transactional
public class PollingStationServiceImpl implements PollingStationService {

	@Autowired
	PollingStationDao dao;

	@Override
	public void createNewPollingStation(PollingStation newPollingStation) {
		dao.create(newPollingStation);
	}

	@Override
	public void deleteExistingPollingStation(PollingStation pollingStationToDelete) {
		dao.delete(pollingStationToDelete);
	}

	@Override
	public List<PollingStation> retrieveAllPollingStations() {
		return dao.allPollingStations();
	}

}
