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

@SpringBootApplication
public class GeovoteApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(GeovoteApplication.class, args);


		DistrictService  districtService = container.getBean(DistrictService.class);

		
		Voter vo1 = new Voter("VOTER_1", "Didier Nkalla", "Douala", "M");
		Voter vo2 = new Voter("VOTER_2", "Felicien Fotio", "Dschang", "M");
		Voter vo3 = new Voter("VOTER_3", "Megan Hess", "Denver", "F");
		Voter vo4 = new Voter("VOTER_4", "Fothe Fabrice", "Paris", "M");
		
		HashSet<Voter> vl1 = new HashSet<Voter>();
		
		vl1.add(vo1);
		vl1.add(vo2);
		vl1.add(vo3);
		vl1.add(vo4);

		
		
		
		Voter vo5 = new Voter("VOTER_5", "Chalene Melacheo", "Touboro", "F");
		Voter vo6 = new Voter("VOTER_6", "Didier Nkalla", "Douala", "M");
		Voter vo7 = new Voter("VOTER_7", "Felicien Fotio", "Dschang", "M");
		Voter vo8 = new Voter("VOTER_8", "Megan Hess", "Denver", "F");
		
		
		HashSet<Voter> vl2 = new HashSet<Voter>();
		
		vl2.add(vo5);
		vl2.add(vo6);
		vl2.add(vo7);
		vl2.add(vo8);
		
		
		
		PollingStation ps1 = new PollingStation("POLLING_STAT_1", "PS_1", "POSTA_1", vl1);
		PollingStation ps2 = new PollingStation("POLLING_STAT_1", "PS_1", "POSTA_1", vl2);
		
		
		HashSet<PollingStation> pollsta1 = new HashSet<PollingStation>();
		pollsta1.add(ps1);
		pollsta1.add(ps2);
		
		
		
		
		Parish p1 = new Parish("PARISH_1", "PA1", "PR1", pollsta1);
		
		

		HashSet<Parish> pa1 = new HashSet<Parish>();
		pa1.add(p1);
		
		
		
		SubCounty subCo1 = new SubCounty("SUB_CO_1", "SC1", "SUBCO1", pa1);
		HashSet<SubCounty> subCol1 = new HashSet<SubCounty>();
		subCol1.add(subCo1);
		
		
		
		Constituency c1 = new Constituency("CONS_1", "CO1", "CONS1", subCol1);
		Constituency c2 = new Constituency("CONS_1", "CO1", "CONS1");
		Constituency c3 = new Constituency("CONS_1", "CO1", "CONS1");
		Constituency c4 = new Constituency("CONS_1", "CO1", "CONS1");
		
		HashSet<Constituency> constL1 = new HashSet<Constituency>();
		constL1.add(c1);
		constL1.add(c2);
		constL1.add(c3);
		constL1.add(c4);
		

		
		District di1 = new District("DISTRICT_1", "D1", "DIST1", constL1);
		
		
		districtService.createNewDistrict(di1);

	}
}
