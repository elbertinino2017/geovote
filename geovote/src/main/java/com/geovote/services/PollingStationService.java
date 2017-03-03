package com.geovote.services;

import java.util.List;

import com.geovote.domain.PollingStation;

public interface PollingStationService {
	
	public void createNewPollingStation(PollingStation newPollingStation);
	public void deleteExistingPollingStation(PollingStation pollingStationToDelete);
	public List<PollingStation> retrieveAllPollingStations();
	public void updatePollingStation(PollingStation pollingStationToUpdate);

}
