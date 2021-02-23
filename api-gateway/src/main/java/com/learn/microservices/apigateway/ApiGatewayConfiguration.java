package com.learn.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration 
{
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
	{
		Function<PredicateSpec, Buildable<Route>> routeFunction
		= p -> p.path("/get").filters(f->f
				.addRequestHeader("MyHeader", "MyURI")
				.addRequestHeader("Param", "MyValue"))
		.uri("http://httpbin.org:80");
		Function<PredicateSpec, Buildable<Route>> currExchRouteFunction=
				p -> p.path("/currencyexchange/**")
					.uri("lb://currencyexchange");
		Function<PredicateSpec, Buildable<Route>> currConvRouteFunction=
				p -> p.path("/currency-conversion-feign/**")
				.uri("lb://currencyconversion");
		Function<PredicateSpec, Buildable<Route>> currConvOldRouteFunction = 
				p->p.path("/currency-conversion/**")
				.filters(f -> f.rewritePath("/currency-conversion/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
				.uri("lb://currencyconversion");
		return builder.routes()
				.route(routeFunction)
				.route(currExchRouteFunction)
				.route(currConvRouteFunction)
				.route(currConvOldRouteFunction)
				.build();
	}
	
}
