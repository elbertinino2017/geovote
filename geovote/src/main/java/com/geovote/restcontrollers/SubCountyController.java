package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.SubCounty;
import com.geovote.representations.SubCountyCollectionRepresentation;
import com.geovote.services.SubCountyService;

@RestController
public class SubCountyController {

	@Autowired
	SubCountyService subCountyService;

	@RequestMapping(value = "/subcounties", method = RequestMethod.GET)
	public SubCountyCollectionRepresentation allSubCounties() {

		List<SubCounty> allSubCounties = subCountyService.retrieveAllSubCounties();

		return new SubCountyCollectionRepresentation(allSubCounties);
	}

}
