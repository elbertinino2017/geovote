package com.geovote.restcontrollers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.geovote.context.administrative.domain.PollingStation;
import com.geovote.context.administrative.domain.Voter;
import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Candidature;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;
import com.geovote.context.election.domain.Vote;
import com.geovote.data.ElectionService;
import com.geovote.helper.VoteMessage;
import com.geovote.representations.CandidateCollectionRepresentstion;
import com.geovote.representations.CandidatureRepresentation;
import com.geovote.representations.ThemeCollectionRepresentation;
import com.geovote.representations.VoteRepresentation;
import com.geovote.services.CandidateService;
import com.geovote.services.PollingStationService;
import com.geovote.services.VoterService;

@RestController
public class ElectionController {
	
	
	private final SseEmitter sseEmitter =new SseEmitter(Long.MAX_VALUE);


	@Autowired
	private ElectionService electionService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private VoterService voterService;
	@Autowired
	private PollingStationService pollingStationService;
	
	@RequestMapping(value="/elections", method=RequestMethod.POST)
	public void createNewElection(@RequestBody Election newElection){
		
		electionService.createNewElection(newElection);
	}
	
	@RequestMapping(value="/election/{code}", method=RequestMethod.GET)
	public Election findElectionByCode(@PathVariable String code){
		
		return electionService.findElectionByCode(code);
	}
	
	@RequestMapping(value="/election/{code}/candidates", method=RequestMethod.GET)
	public CandidateCollectionRepresentstion findElectionsCandidates(@PathVariable String code){
		
		List<Candidate> electionsCandidates = electionService.findElectionsCandidates(code);
		
		return new CandidateCollectionRepresentstion(electionsCandidates);
	}
	
	
	@RequestMapping(value="/election/{code}/candidatures", method=RequestMethod.POST)
	public void registerCandidateForElection(@PathVariable String code,  @RequestBody CandidatureRepresentation candidatureRepresention){
		
		Election foundElection = electionService.findElectionByCode(code);
		
		Candidate foundCandidate = candidateService.findCadidateByCode(candidatureRepresention.getCandidateRegistrationId());
		
		Candidature candidature = new Candidature(foundCandidate, foundElection, new Date(),candidatureRepresention.getCandidateSignature());
		
		electionService.registerCandidateForElection(code, candidature);;
		
	}
	
	@RequestMapping(value="/election/{code}/votes", method=RequestMethod.POST)
	public void registerVoteForElection(@PathVariable String code,  @RequestBody VoteRepresentation voteRepresentation){
		
		Election foundElection = electionService.findElectionByCode(code);
		
		Voter foundVoter = voterService.findVoterByVoterId(voteRepresentation.getVoterId());

		Vote vote = new Vote(foundVoter, foundElection, new Date(), "Herve");
		
		electionService.registerVoteForElection(code, vote);
		
		PollingStation votersPollingStation = pollingStationService.findPollingStationByCode(vote.getVoter().getPollingStationInfo().getPollingStationCode());
		
		
		VoteMessage message = new VoteMessage(foundElection.getCode(), foundVoter.getDistrictInfo().getDistrictCode(), foundVoter.getConstituencyInfo().getConstituencyCode(), 
				foundVoter.getSubCountyInfo().getSubCountyCode(), foundVoter.getParishInfo().getParishCode(), foundVoter.getPollingStationInfo().getPollingStationCode(), votersPollingStation.getCurrentVotes());
		
		

		try {
			
						
			sseEmitter.send(SseEmitter.event().name("newVoteEntry").data(message));
			
			
		} catch (IOException e) {
			

		}

		

		
	}
	
	@RequestMapping(value="/election/{code}/themes", method=RequestMethod.POST)
	public void registerThemeForElection(@PathVariable String code,  @RequestBody Theme theme){
		
		electionService.registerThemeForElection(code, theme);
		
	}
	
	@RequestMapping(value="/election/{code}/themes", method=RequestMethod.GET)
	public ThemeCollectionRepresentation findElectionsThems(@PathVariable String code){
		
		List<Theme> electionsThemes = electionService.findElectionsThemes(code);
		
		return new ThemeCollectionRepresentation(electionsThemes);
		
	}
	
	
	
	@RequestMapping("/event")
	public SseEmitter alertMeOfNewVote(HttpServletRequest request){
				
		return sseEmitter;
		
		
	}
	
	

}
