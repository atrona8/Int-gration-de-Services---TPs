package com.esmt.m223isi.microservices.currencyconvertionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversation {

	
	private long id;
	private String from;
	private String to;
	private BigDecimal rateExchange;
	private BigDecimal amount;
	private BigDecimal calculateAmount;
	private String source;
	private String environnement;
	
	public CurrencyConversation() {
	}
	
	public CurrencyConversation(long id, String from, String to, BigDecimal rateExchange, BigDecimal amount,
			BigDecimal calculateAmount, String source, String environnement) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rateExchange = rateExchange;
		this.amount = amount;
		this.calculateAmount = calculateAmount;
		this.source = source;
		this.environnement = environnement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	
	public String getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public BigDecimal getRateExchange() {
		return rateExchange;
	}

	public void setRateExchange(BigDecimal rateExchange) {
		this.rateExchange = rateExchange;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCalculateAmount() {
		return calculateAmount;
	}

	public void setCalculateAmount(BigDecimal calculateAmount) {
		this.calculateAmount = calculateAmount;
	}
	
	
	
}
