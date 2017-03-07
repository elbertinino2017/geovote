package com.geovote.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(name="/home")
	public String hello()
	{
		return "welcome";
	}

}
