package com.esmt.m223isi.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.m223isi.microservices.currencyexchangeservice.bean.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long>{
	
	Authentication findByLoginAndPassword (String login, String password);

}
