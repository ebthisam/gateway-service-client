package com.iiht.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.*;
@SpringBootApplication
public class HelloclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloclientApplication.class, args);
	}
	
	@Bean
	public RestTemplate newTemplate() {
		return new RestTemplate();
	}

}
