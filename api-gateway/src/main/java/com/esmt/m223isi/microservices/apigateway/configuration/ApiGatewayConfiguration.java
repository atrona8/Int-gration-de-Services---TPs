package com.esmt.m223isi.microservices.apigateway.configuration;


import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiGatewayConfiguration {

		@Bean
		public RouteLocator gatewayRouter( RouteLocatorBuilder builder)
		{
			/*
			Function<PredicateSpec, Buildable<Route>> routeFunction =
					p ->p.path("/get")
					.uri("http://httpbin.org:80");
			*/
			
			return builder.routes()
					.route(p ->p.path("/get")
							.filters( f ->f
									.addRequestHeader("myHeaderParam", "HeaderParamValue")
									.addRequestParameter("MyParameter", "ParamValue"))
							.uri("http://httpbin.org:80"))
					.route(p ->p
							.path("/currency-exchange/**")
							.uri("lb://currency-exchange")) //  nom de la microservice dans eureka
					.route(p ->p
							.path("/currency-conversion/**")
							.uri("lb://currency-conversion")) //  nom de la microservice dans eureka
					.route(p ->p
							.path("/authentication/**")
							.uri("lb://authentication")) //  nom de la microservice authentication dans eureka
					.build();
		}
}
