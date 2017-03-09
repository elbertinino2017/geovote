package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.context.administrative.domain.PollingStation;
import com.geovote.context.administrative.domain.Voter;
import com.geovote.representations.CountRecordRepresentation;
import com.geovote.representations.PollingStationCollectionRepresentation;
import com.geovote.representations.VotersCollectionRepresentation;
import com.geovote.services.PollingStationService;

@RestController
public class PollingStationController {

	@Autowired
	private PollingStationService pollingStationService;

	@RequestMapping(value = "/pollingstation/{code}", method = RequestMethod.GET)
	public PollingStation findPollingStationByCode(@PathVariable String code) {

		return pollingStationService.findPollingStationByCode(code);

	}
	
	@RequestMapping(value = "/pollingstation/{code}/voters", method = RequestMethod.GET)
	public VotersCollectionRepresentation findPollingStationsVoters(@PathVariable String code) {

		 List<Voter> pollingStationsVoters = pollingStationService.findPollingStationsVoters(code);
		 
		 return new VotersCollectionRepresentation(pollingStationsVoters);

	}
	
	@RequestMapping(value = "/pollingstation/{code}/voters/count", method = RequestMethod.GET)
	public CountRecordRepresentation countPollingStationsVoters(@PathVariable String code) {

		Long totalRecord =  pollingStationService.countPollingStationsVoters(code);
		
		 return new CountRecordRepresentation(totalRecord);

	}

	@RequestMapping(value = "/pollingstations", method = RequestMethod.GET)
	public PollingStationCollectionRepresentation allPollingStations() {

		List<PollingStation> allPollingStations = pollingStationService.retrieveAllPollingStations();

		return new PollingStationCollectionRepresentation(allPollingStations);
	}

	@RequestMapping(value = "/pollingstations", method = RequestMethod.POST)
	public PollingStation registerNewPollingStation(@RequestBody PollingStation newPollingStation) {


		pollingStationService.createNewPollingStation(newPollingStation);

		return newPollingStation;
	}

	@RequestMapping(value = "/pollingstation/{code}", method = RequestMethod.PUT)
	public PollingStation updateExistingPollingStation(@RequestBody PollingStation pollingStationToUpdate) {

		System.out.println("Here in the incommig polling station" + pollingStationToUpdate);
		pollingStationService.updatePollingStation(pollingStationToUpdate);

		return pollingStationToUpdate;
	}

}
