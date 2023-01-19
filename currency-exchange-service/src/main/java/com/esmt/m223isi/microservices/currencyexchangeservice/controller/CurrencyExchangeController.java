package com.esmt.m223isi.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esmt.m223isi.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.esmt.m223isi.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	CurrencyExchangeRepository repo;
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to)
	{
		String port = environment.getProperty("local.server.port");
		//System.out.println("port : "+port);
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		
		if(currencyExchange == null) 
			throw new RuntimeException("Taux de change nom trouvé pour "+from + " -> "+to);
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
