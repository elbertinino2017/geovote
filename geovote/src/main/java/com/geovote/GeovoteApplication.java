package com.geovote;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.geovote.domain.Constituency;
import com.geovote.domain.District;
import com.geovote.domain.Parish;
import com.geovote.domain.PollingStation;
import com.geovote.domain.SubCounty;
import com.geovote.domain.Voter;
import com.geovote.services.DistrictService;
import com.geovote.services.VoterService;

@SpringBootApplication
public class GeovoteApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(GeovoteApplication.class, args);


		DistrictService  districtService = container.getBean(DistrictService.class);
		VoterService  voterService = container.getBean(VoterService.class);
		

		
		
		PollingStation ps1 = new PollingStation("ps_1", "poll_stat_1");
		PollingStation ps2 = new PollingStation("ps_2", "poll_stat_2");
		
		
		HashSet<PollingStation> pollsta1 = new HashSet<PollingStation>();
		pollsta1.add(ps1);
		pollsta1.add(ps2);
		
		
		
		
		Parish p1 = new Parish("par_1", "parish_1", pollsta1);
		
		

		HashSet<Parish> pa1 = new HashSet<Parish>();
		pa1.add(p1);
		
		
		
		SubCounty subCo1 = new SubCounty("sbc_1", "subcounty_1", pa1);
		HashSet<SubCounty> subCol1 = new HashSet<SubCounty>();
		subCol1.add(subCo1);
		
		
		
		Constituency c1 = new Constituency("cons_1", "constituenty_1", subCol1);
		Constituency c2 = new Constituency("cons_2", "constituenty_2");
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
		

		
		
		
		

		
		Voter vo1 = new Voter("app_id_1","voter_1","Fotio", "Felicien","21/01/1985","M","Bonaberi", di1.retrieveBasicInfo(),c1.retrieveBasicInfo(),p1.retrieveBasicInfo(),ps1.retrieveBasicInfo(),subCo1.retrieveBasicInfo());
		
		Voter vo2 = new Voter("app_id_2", "voter_2", "Puepi", "Herve","21/02/1986", "M", "Bonamoussadi", di1.retrieveBasicInfo(),c1.retrieveBasicInfo(),p1.retrieveBasicInfo(),ps1.retrieveBasicInfo(),subCo1.retrieveBasicInfo());
		
		Voter vo3 = new Voter("app_id_3", "voter_3", "Hess", "Megan", "13/02/1990", "F", "Denver", di1.retrieveBasicInfo(),c1.retrieveBasicInfo(),p1.retrieveBasicInfo(),ps1.retrieveBasicInfo(),subCo1.retrieveBasicInfo());
		
		Voter vo4 = new Voter("app_id_4",  "voter_4", "Fothe", "Fabrice","02/11/1986",  "M", "Paris", di1.retrieveBasicInfo(),c1.retrieveBasicInfo(),p1.retrieveBasicInfo(),ps1.retrieveBasicInfo(),subCo1.retrieveBasicInfo());
		
		
		

		voterService.createNewVoter(vo1);
		voterService.createNewVoter(vo2);
		voterService.createNewVoter(vo3);
		voterService.createNewVoter(vo4);
		
		

		
		



	}
}
