package com.geovote.services;

import java.util.List;

import com.geovote.context.administrative.domain.PollingStation;
import com.geovote.context.administrative.domain.Voter;

public interface PollingStationService {
	
	public void createNewPollingStation(PollingStation newPollingStation);
	public void deleteExistingPollingStation(PollingStation pollingStationToDelete);
	public List<PollingStation> retrieveAllPollingStations();
	public void updatePollingStation(PollingStation pollingStationToUpdate);
	public PollingStation findPollingStationByCode(String code);
	public List<Voter> findPollingStationsVoters(String code);
	public Long countPollingStationsVoters(String code);

}
