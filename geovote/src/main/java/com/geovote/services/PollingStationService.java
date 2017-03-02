package com.geovote.services;

import com.geovote.domain.PollingStation;

public interface PollingStationService {
	
	public void createNewPollingStation(PollingStation newPollingStation);
	public void deleteExistingPollingStation(PollingStation pollingStationToDelete);

}
