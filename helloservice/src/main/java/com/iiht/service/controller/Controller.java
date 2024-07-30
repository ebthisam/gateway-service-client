package com.iiht.service.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;


@RequestMapping("/rest/service")
@RestController
public class Controller {
	@Autowired
	Environment environment;
	
	@GetMapping("/fetch")
	public String fetch(Long pathId) {
		return "Bye "+environment.getProperty("local.server.port");
		
	}
	@GetMapping("/{value}")
	public ResponseEntity<Long> factor(@PathVariable Long value )
	{
		Long res=(long) 1;
		for(int i=1;i<=value;i++ ) {
			res=res*i;
		}
	return ResponseEntity.ok(res);
	}
	
	

}
