package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.Constituency;
import com.geovote.representations.ConstituencyCollectionRepresentation;
import com.geovote.services.ConstituencyService;

@RestController
public class ConstituencyController {
	
	@Autowired
	private ConstituencyService constituencyService;
	
	
	@RequestMapping(value="/constituencies", method=RequestMethod.GET)
	public ConstituencyCollectionRepresentation allConstituencies(){
		
		
		List<Constituency> allConstituencies = constituencyService.retrieveAllConstituencies();
		
		return new ConstituencyCollectionRepresentation(allConstituencies);
	}

}
