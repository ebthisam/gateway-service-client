package com.iiht.client.helloclient;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/rest/client")
public class HelloClient {
	
	@Autowired
	RestTemplate template;
	@GetMapping
	public ResponseEntity<String> connect()
	{
		String url="http://localhost:8061/rest/service/";
		//String url="https://www.google.com";
		ResponseEntity<String> response=template.getForEntity(url,String.class);
		String res=template.getForObject(url, String.class);
		return ResponseEntity.ok(res);
		//return "hello";
	}
	
	@GetMapping("/{value}")
    public ResponseEntity<String> connect1(@PathVariable Long value) {
        String strValue = String.valueOf(value);
        String url = "http://localhost:8061/rest/service/" + strValue;
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        String responseBody = response.getBody();
        return ResponseEntity.ok(responseBody);
    }
	
	

}
