package com.geovote.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.representations.ParishesCollectionRepresentation;
import com.geovote.services.ParishService;

@RestController
public class ParishController {
	
	@Autowired
	private ParishService parishService;
	
	@RequestMapping("/parishes")
	public ParishesCollectionRepresentation retrieveAllParishes(){
		
		return new ParishesCollectionRepresentation(parishService.getAllParishes());
		
	}
	

}
