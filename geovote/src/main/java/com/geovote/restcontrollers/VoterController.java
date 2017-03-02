package com.geovote.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.Voter;
import com.geovote.representations.VotersRepresentation;
import com.geovote.services.VoterService;

@RestController
public class VoterController {
	@Autowired
	VoterService voterService;

	@RequestMapping(value = "/voters", method = RequestMethod.GET)
	public VotersRepresentation allVotersUseCase() {
		List<Voter> allVoters = voterService.retrieveAllVoters();

		for (Voter next : allVoters) {
			System.out.println("/////////////   " + next + "  /////////////");
		}

		return new VotersRepresentation(allVoters);
	}

}
