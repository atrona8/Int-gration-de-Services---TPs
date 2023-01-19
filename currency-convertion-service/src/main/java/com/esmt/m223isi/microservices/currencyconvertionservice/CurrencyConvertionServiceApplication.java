package com.esmt.m223isi.microservices.currencyconvertionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurrencyConvertionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertionServiceApplication.class, args);
	}

}
