package com.esmt.m223isi.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Authentication {

	@Id
	private long id;
	@Column(name="login")
	private String login; 
	@Column(name="password")
	private String password;
	private String environment;
	
	public Authentication() {
		
	}
	
	public Authentication(long id, String login, String password, String environment) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.environment = environment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	} 
	
	
	
	

	
	
}
