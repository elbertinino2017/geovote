package com.geovote;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.geovote.context.administrative.domain.Constituency;
import com.geovote.context.administrative.domain.District;
import com.geovote.context.administrative.domain.Parish;
import com.geovote.context.administrative.domain.PollingStation;
import com.geovote.context.administrative.domain.SubCounty;
import com.geovote.context.administrative.domain.Voter;
import com.geovote.context.election.domain.Candidate;
import com.geovote.context.election.domain.Candidature;
import com.geovote.context.election.domain.Election;
import com.geovote.context.election.domain.Theme;
import com.geovote.context.election.domain.Vote;
import com.geovote.context.result.domain.Weight;
import com.geovote.data.ElectionService;
import com.geovote.services.DistrictService;
import com.geovote.services.VoterService;

@SpringBootApplication
public class GeovoteApplication extends SpringBootServletInitializer{
	
	
	
	
	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder application){
		return application.sources(GeovoteApplication.class);
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(GeovoteApplication.class, args);
		
		
		ElectionService electionService = container.getBean(ElectionService.class);
		
		

		
		
		
		
		
		Weight w1 = new Weight();
		Weight w2 = new Weight();
		

		

		
		Candidate can1 = new Candidate("can_id_1", "Election candidate one", new HashSet<>(),new HashSet<>());
		Candidate can2 = new Candidate("can_id_2", "Election candidate two", new HashSet<>(),new HashSet<>());
		
		
		
		
		Set<Candidate> candidates = new HashSet<Candidate>();
		candidates.add(can1);
		candidates.add(can2);
		
		
		
		Set<Vote> votes = new HashSet<Vote>();
		
		
		Set<Candidature> registrations = new HashSet<>();
		
		Election newElection = new Election("el_id_1", "Election one", new Date(), new HashSet<>(), registrations, votes);
		
		Theme th1 = new Theme("th_id_1", "Them one", w1, newElection.retrieveElectionInfo(), new HashSet<>());
		Theme th2 = new Theme("th_id_2", "Theme two", w2, newElection.retrieveElectionInfo(), new HashSet<>());
		
		Set<Theme> themes = new HashSet<Theme>();
		themes.add(th1);
		themes.add(th2);
		
		newElection.setThemes(themes);
		

		Candidature can_reg1 = new Candidature(can1, newElection, new Date(),"my signature");
		Candidature can_reg2 = new Candidature(can2, newElection, new Date(), "my signature");
		can1.getRegistrations().add(can_reg1);
		can2.getRegistrations().add(can_reg2);
		

		
		
		electionService.createNewElection(newElection);

		DistrictService districtService = container.getBean(DistrictService.class);
		VoterService voterService = container.getBean(VoterService.class);

		PollingStation ps1 = new PollingStation("ps_1", "poll_stat_1", 4.0704429, 9.7243475);
		ps1.setTotalVoters(10l);
		ps1.setCurrentVotes(5l);

		PollingStation ps2 = new PollingStation("ps_2", "poll_stat_2");
		ps2.setTotalVoters(5l);
		ps2.setCurrentVotes(2l);


		HashSet<PollingStation> pollsta1 = new HashSet<PollingStation>();
		pollsta1.add(ps1);
		pollsta1.add(ps2);

		PollingStation ps3 = new PollingStation("ps_3", "poll_stat_3");
		ps3.setTotalVoters(15l);
		ps3.setCurrentVotes(10l);


		PollingStation ps4 = new PollingStation("ps_4", "poll_stat_4");
		ps4.setTotalVoters(20l);
		ps4.setCurrentVotes(3l);



		HashSet<PollingStation> pollsta2 = new HashSet<PollingStation>();
		pollsta2.add(ps3);
		pollsta2.add(ps4);

		Parish p1 = new Parish("par_1", "parish_1", pollsta1);
		Parish p2 = new Parish("par_2", "parish_2");
		Parish p3 = new Parish("par_3", "parish_3", pollsta2);
		Parish p4 = new Parish("par_4", "parish_4");

		HashSet<Parish> pa1 = new HashSet<Parish>();
		pa1.add(p1);
		pa1.add(p3);

		HashSet<Parish> pa2 = new HashSet<Parish>();
		pa2.add(p2);
		pa2.add(p4);

		SubCounty subCo1 = new SubCounty("sbc_1", "subcounty_1", pa1);
		SubCounty subCo2 = new SubCounty("sbc_2", "subcounty_2", pa2);

		HashSet<SubCounty> subCol1 = new HashSet<SubCounty>();
		subCol1.add(subCo1);

		HashSet<SubCounty> subCol2 = new HashSet<SubCounty>();
		subCol2.add(subCo2);

		Constituency c1 = new Constituency("cons_1", "constituenty_1", subCol1);
		Constituency c2 = new Constituency("cons_2", "constituenty_2", subCol2);
		Constituency c3 = new Constituency("cons_3", "constituenty_3");
		Constituency c4 = new Constituency("cons_4", "constituenty_3");

		HashSet<Constituency> constL1 = new HashSet<Constituency>();
		constL1.add(c1);
		constL1.add(c2);

		HashSet<Constituency> constL2 = new HashSet<Constituency>();
		constL2.add(c3);
		constL2.add(c4);

		District di1 = new District("dist_1", "district_1", constL1);
		District di2 = new District("dist_2", "district_2", constL2);

		districtService.createNewDistrict(di1);
		districtService.createNewDistrict(di2);
		
	

		Voter vo1 = new Voter("app_id_1", "voter_1", "Fotio", "Felicien", new Date(), "M", "Bonaberi","",
				new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(),new HashSet<>());

		Voter vo2 = new Voter("app_id_2", "voter_2", "Puepi", "Herve", new Date(), "M", "Bonamoussadi","",
				new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps2.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(), new HashSet<>());

		Voter vo3 = new Voter("app_id_3", "voter_3", "Hess", "Megan", new Date(), "F", "Denver","",
				new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(),new HashSet<>());

		Voter vo4 = new Voter("app_id_4", "voter_4", "Fothe", "Fabrice", new Date(), "M", "Paris","",
				new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(), new HashSet<>());

		voterService.createNewVoter(vo1);
		voterService.createNewVoter(vo2);
		voterService.createNewVoter(vo3);
		voterService.createNewVoter(vo4);
		
		Vote vote1 = new Vote(vo1, newElection, new Date(), "signature_voter1");
		vo1.getVote().add(vote1);
		
		Vote vote2 = new Vote(vo2, newElection, new Date(), "signature_voter2");
		vo2.getVote().add(vote2);
		
		Vote vote3 = new Vote(vo3, newElection,new Date(), "signature_voter3");
		vo3.getVote().add(vote3);
		
		Vote vote4 = new Vote(vo4, newElection, new Date(), "signature_voter4");
		vo4.getVote().add(vote4);
		

	}
}
