package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.PollingStation;
import com.geovote.representations.PollingStationCollectionRepresentation;
import com.geovote.services.PollingStationService;

@RestController
public class PollingStationController {

	@Autowired
	private PollingStationService pollingStationService;

	@RequestMapping(value = "/pollingstations", method = RequestMethod.GET)
	public PollingStationCollectionRepresentation allPollingStations() {

		List<PollingStation> allPollingStations = pollingStationService.retrieveAllPollingStations();

		return new PollingStationCollectionRepresentation(allPollingStations);
	}
	
	
	@RequestMapping(value = "/pollingstations", method = RequestMethod.POST)
	public PollingStation registerNewPollingStation(@RequestBody PollingStation newPollingStation) {

		
		System.out.println("Here in the incomming polling station"+ newPollingStation);
		
		
		  pollingStationService.createNewPollingStation(newPollingStation);

		return newPollingStation;
	}
	
	@RequestMapping(value = "/pollingstations", method = RequestMethod.PUT)
	public PollingStation updateExistingPollingStation(@RequestBody PollingStation pollingStationToUpdate) {

		
		System.out.println("Here in the incomming polling station"+ pollingStationToUpdate);
		
		
		  pollingStationService.updatePollingStation(pollingStationToUpdate);

		return pollingStationToUpdate;
	}

}
