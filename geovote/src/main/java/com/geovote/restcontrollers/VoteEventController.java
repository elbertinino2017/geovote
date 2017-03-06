package com.geovote.restcontrollers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class VoteEventController {
	
	@RequestMapping("/event")
	public SseEmitter alertMeOfNewVote(HttpServletRequest request){
		
		
		SseEmitter sseEmitter =new SseEmitter();
				
				try {
					
					sseEmitter.send("Here I am");
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
		return sseEmitter;
		
		
	}

}
