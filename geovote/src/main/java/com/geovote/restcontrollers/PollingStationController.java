package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public PollingStationCollectionRepresentation allPollingStations(){
		
		List<PollingStation> allPollingStations = pollingStationService.retrieveAllPollingStations();

		return new PollingStationCollectionRepresentation(allPollingStations);
	}
	

}
