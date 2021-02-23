package com.learn.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController 
{
	
	Logger logger= LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	
	@Autowired
	private CurrencyExchangeRepository currencyRepository;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/currencyexchanges/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		String port = env.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
	
	@GetMapping("/currencyexchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeData(@PathVariable String from, @PathVariable String to) 
	{
		logger.info("get exchange data called with {} to {}", from,to);
		CurrencyExchange currencyExchange= currencyRepository.findByFromAndTo(from,to);
		if(currencyExchange == null)
		{
			throw new RuntimeException("unable to find data for "+ from +" to "+ to);
		}
		String port = env.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
