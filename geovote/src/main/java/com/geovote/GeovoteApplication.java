package com.geovote;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.geovote.domain.Voter;
import com.geovote.services.VoterService;
import com.geovote.services.VoterServiceImpl;

@SpringBootApplication
public class GeovoteApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(GeovoteApplication.class, args);

		// String[] allBeans = container.getBeanDefinitionNames();

		VoterService voterService = container.getBean(VoterServiceImpl.class);

		Voter vo1 = new Voter("VOTER1", "Didier Nkalla", "Douala", "M");
		Voter vo2 = new Voter("VOTER2", "Felicien Fotio", "Dschang", "M");
		Voter vo3 = new Voter("VOTER3", "Megan Hess", "Denver", "F");
		Voter vo4 = new Voter("VOTER4", "Fothe Fabrice", "Paris", "M");
		Voter vo5 = new Voter("VOTER5", "Chalene Melacheo", "Touboro", "F");

		voterService.createNewVoter(vo1);
		voterService.createNewVoter(vo2);
		voterService.createNewVoter(vo3);
		voterService.createNewVoter(vo4);
		voterService.createNewVoter(vo5);

		List<Voter> allPersistedVoters = voterService.retrieveAllVoters();

		for (Voter next : allPersistedVoters) {
			System.out.println(next);
		}
	}
}
