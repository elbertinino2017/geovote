package com.geovote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GeovoteApplication {

	public static void main(String[] args) 
	{
		
		
		ConfigurableApplicationContext container =  SpringApplication.run(GeovoteApplication.class, args);
		
		String[] allBeans = container.getBeanDefinitionNames();
		
		
		/*for(String next : allBeans )
		{
			System.out.println(next);
		}*/
	}
}
