package com.geovote.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geovote.domain.DomainTest;

@RestController
public class ControllerTest {
	
	
	@RequestMapping("/home")
	public DomainTest myAppInfo()
	{
		DomainTest domainTest = new DomainTest();
		
		domainTest.setAppName("Geovote");
		domainTest.setAuthor("Felicien Fotio");
		domainTest.setGreet("Bonjour");
		
		return domainTest;
	}

}
