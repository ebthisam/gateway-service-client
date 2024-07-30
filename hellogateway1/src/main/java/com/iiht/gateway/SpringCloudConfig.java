package com.iiht.gateway;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class SpringCloudConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return 
				builder.routes().
				route(
						"helloservice",
						r->r.path("/rest/service/**").
						uri("http://localhost:8061")
						)
				.build();
	}
}
