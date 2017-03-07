package com.geovote;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
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
public class GeovoteApplication extends SpringBootServletInitializer{
	
	
	
	
	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder application){
		return application.sources(GeovoteApplication.class);
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(GeovoteApplication.class, args);

		DistrictService districtService = container.getBean(DistrictService.class);
		VoterService voterService = container.getBean(VoterService.class);

		PollingStation ps1 = new PollingStation("ps_1", "poll_stat_1", 4.0704429, 9.7243475);

		PollingStation ps2 = new PollingStation("ps_2", "poll_stat_2");

		HashSet<PollingStation> pollsta1 = new HashSet<PollingStation>();
		pollsta1.add(ps1);
		pollsta1.add(ps2);

		PollingStation ps3 = new PollingStation("ps_3", "poll_stat_3");
		PollingStation ps4 = new PollingStation("ps_4", "poll_stat_4");

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

		Voter vo1 = new Voter("app_id_1", "voter_1", "Fotio", "Felicien", "21/01/1985", "M", "Bonaberi",
				di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo());

		Voter vo2 = new Voter("app_id_2", "voter_2", "Puepi", "Herve", "21/02/1986", "M", "Bonamoussadi",
				di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo());

		Voter vo3 = new Voter("app_id_3", "voter_3", "Hess", "Megan", "13/02/1990", "F", "Denver",
				di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps3.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo());

		Voter vo4 = new Voter("app_id_4", "voter_4", "Fothe", "Fabrice", "02/11/1986", "M", "Paris",
				di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps3.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo());

		voterService.createNewVoter(vo1);
		voterService.createNewVoter(vo2);
		voterService.createNewVoter(vo3);
		voterService.createNewVoter(vo4);

	}
}
