package com.esmt.m223isi.microservices.aurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AurekaNamingServerApplication.class, args);
	}
	
}
