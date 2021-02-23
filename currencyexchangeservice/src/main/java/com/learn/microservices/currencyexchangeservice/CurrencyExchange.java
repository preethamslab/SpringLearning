package com.learn.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class CurrencyExchange 
{
	@Id 
	 private Long id;
	
	@Column(name="currency_from")
	 private String from;
	@Column(name="currency_to")
	 private String to;
	 private BigDecimal conversionMultiple;
	 private String environment;
	 
	 public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public CurrencyExchange() {
		// TODO Auto-generated constructor stub
	}
	 
	public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public BigDecimal getconversionMultiple() {
		return conversionMultiple;
	}
	public void setConverstionMultiple(BigDecimal converstionMultiple) {
		this.conversionMultiple = converstionMultiple;
	}
}
