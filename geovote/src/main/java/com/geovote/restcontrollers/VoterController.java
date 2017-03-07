package com.geovote.restcontrollers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.geovote.domain.PollingStation;
import com.geovote.domain.Voter;
import com.geovote.representations.VotersCollectionRepresentation;
import com.geovote.services.VoterService;

@RestController
public class VoterController {

	@Autowired
	VoterService voterService;
	
	private final SseEmitter sseEmitter =new SseEmitter(Long.MAX_VALUE);
	private static int i = 0;


	@RequestMapping(value = "/voters", method = RequestMethod.GET)
	public VotersCollectionRepresentation allVotersUseCase() {

		List<Voter> allVoters = voterService.retrieveAllVoters();

		return new VotersCollectionRepresentation(allVoters);
	}

	@RequestMapping(value = "/voter/{id}", method = RequestMethod.GET)
	public Voter findVoterById(@PathVariable String id,
			@RequestParam(required = false, defaultValue = "voterId") String idType) {
		
		
		

		if (idType.equals("applicantId")) {

			return voterService.findVoterByApplicantId(id);

		} else if (idType.equals("voterId")) {

			Voter v = voterService.findVoterByVoterId(id);
		
			try {
				
				i=i+1;
				
				sseEmitter.send(SseEmitter.event().name("newVoteEntry").data(v));
				
				
			} catch (IOException e) {
				
	
			}

			return v;

		} else {

			return new Voter();
		}

	}

	@RequestMapping(value = "/voter/{id}/pollingstation", method = RequestMethod.GET)
	public PollingStation findVoterPollingStation(@PathVariable String id,
			@RequestParam(required = false, defaultValue = "voterId") String idType) {

		if (idType.equals("applicantId")) {

			return voterService.findVotersPollingStationByApplicantId(id);

		} else if (idType.equals("voterId")) {

			return voterService.findVotersPollingStationByVoterId(id);

		} else {
			return new PollingStation();
		}

	}
	
	
	@RequestMapping("/event")
	public SseEmitter alertMeOfNewVote(HttpServletRequest request){
				
		return sseEmitter;
		
		
	}
}