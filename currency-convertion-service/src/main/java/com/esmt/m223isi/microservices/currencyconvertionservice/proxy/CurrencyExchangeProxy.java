package com.esmt.m223isi.microservices.currencyconvertionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esmt.m223isi.microservices.currencyconvertionservice.bean.CurrencyConversation;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversation getCurrencyExchange(
			@PathVariable String from,
			@PathVariable String to
			);

	
}
