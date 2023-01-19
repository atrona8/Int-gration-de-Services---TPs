package com.esmt.m223isi.microservices.currencyconvertionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esmt.m223isi.microservices.currencyconvertionservice.bean.CurrencyConversation;
import com.esmt.m223isi.microservices.currencyconvertionservice.proxy.CurrencyExchangeProxy;


@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy ;
	
	@Autowired
	private Environment environment;
	
	
	
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/amount/{amount}")
	CurrencyConversation getCurrencyConversation(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal amount)
	{
		String originTemplate = environment.getProperty("origin.restTemplate");
		
		HashMap<String, String> uriVariables = new HashMap<>();		
		
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversation> responseEntity = new RestTemplate().
				getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
						CurrencyConversation.class, uriVariables);
		
		CurrencyConversation currencyConversation = responseEntity.getBody();
			
		
		return new CurrencyConversation(currencyConversation.getId(),
				from,
				to, 
				amount, 
				currencyConversation.getRateExchange(), 
				amount.multiply(currencyConversation.getRateExchange()),
				originTemplate,
				environment.getProperty("local.server.port"));
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/amount/{amount}")
	CurrencyConversation getCurrencyConversationFeign(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal amount)
	{
		String port = environment.getProperty("local.server.port");
		
		String originFeign = environment.getProperty("origin.restFeignClient");
		
		CurrencyConversation currencyConversation = proxy.getCurrencyExchange(from, to);
		
		return new CurrencyConversation(currencyConversation.getId(),
				from,
				to, 
				amount, 
				currencyConversation.getRateExchange(), 
				amount.multiply(currencyConversation.getRateExchange()),
				originFeign,
				environment.getProperty("local.server.port"));
		
	}
	
}
