package com.esmt.m223isi.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esmt.m223isi.microservices.currencyexchangeservice.bean.Authentication;
import com.esmt.m223isi.microservices.currencyexchangeservice.repository.AuthenticationRepository;


@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationRepository repo;
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping("/authentication/login/{login}/password/{password}")
	public Authentication getAuthentication(@PathVariable String login, @PathVariable String password)
	{
		String port = environment.getProperty("local.server.port");
		//System.out.println("port : "+port);
		Authentication currencyExchange = repo.findByLoginAndPassword(login, password);
		
		if(currencyExchange == null) 
			throw new RuntimeException("Utilisateur de change nom trouvé pour "+login + " -> "+password);
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
