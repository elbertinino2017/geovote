package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.Parish;
import com.geovote.domain.PollingStation;
import com.geovote.domain.SubCounty;
import com.geovote.domain.Voter;
import com.geovote.representations.ParishesCollectionRepresentation;
import com.geovote.representations.PollingStationCollectionRepresentation;
import com.geovote.services.ParishService;

@RestController
public class ParishController {
	
	@Autowired
	private ParishService parishService;
	
	@RequestMapping(value="/parishes", method=RequestMethod.GET)
	public ParishesCollectionRepresentation retrieveAllParishes(){
		
		return new ParishesCollectionRepresentation(parishService.getAllParishes());
		
	}
	
	@RequestMapping(value="/parish/{code}", method=RequestMethod.GET)
	public Parish findParichByCode(@PathVariable String code){
		
		return parishService.getParishByCode(code);
		
	}
	
	
	@RequestMapping(value = "/parish/{code}/voters", method = RequestMethod.GET)
	public List<Voter> findParichesVotersByParishCode(@PathVariable String code){
		
		return parishService.findParichesVotersByParishCode(code);
		
	}

	
	@RequestMapping(value = "/parish/{code}/pollingstations", method = RequestMethod.GET)
	public PollingStationCollectionRepresentation subCountiesParishesBySubCountyCode(@PathVariable String code) {

		Parish  parish = parishService.getParishByCode(code);

		return new PollingStationCollectionRepresentation(parish.getPollingStations());
	}

	

	

}
