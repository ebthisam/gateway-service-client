package com.iiht.resiliececlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("rest/client")
public class HelloClientResource {
	
	@Autowired
	RestTemplate template;
	public final static String CLIENT_SERVICE="clientService";
	public final static String CLIENT_SERVICE1="clientService1";

	
	
	@GetMapping
	@CircuitBreaker(name=CLIENT_SERVICE, fallbackMethod="callOnfail")
	public String message() {
		
		String url="http://localhost:8061/rest/service/fetch";
		String output=template.getForObject(url,String.class);
		return output;
	}
	
	public String callOnfail(Exception e) {
		return "msg from callonfail()...";
	}
	@GetMapping("/{value}")
	@CircuitBreaker(name=CLIENT_SERVICE1, fallbackMethod="callOnFail")
	public String factorial(@PathVariable Long value) {
        String strValue = String.valueOf(value);

		
		String url="http://localhost:8061/rest/service/"+strValue;
		String output=template.getForObject(url,String.class);
		return output;
	}
	public String callOnFail(Exception e) {
		return "msg from callonfail()...";
	}


}

