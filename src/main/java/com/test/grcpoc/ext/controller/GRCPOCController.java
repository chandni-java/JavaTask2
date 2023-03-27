package com.test.grcpoc.ext.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.service.IServiceNowRecords;

@RestController

public class GRCPOCController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IServiceNowRecords iServiceNowRecords;

	@RequestMapping("/getrecords")
	public ResponseEntity<ServiceNowResource> getRecords() throws URISyntaxException, JsonProcessingException {
        
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("joel.nardo", "Jithu@1254");
		
		URI uri = new URI("https://dev141866.service-now.com/api/now/table/alm_asset?sysparm_limit=1");
        //.
		HttpEntity<String> request = new HttpEntity<String>(headers);
        
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);
        
//      Calling a method and passing ResponseEntity as an argument in that method.
//      In return it is giving PostEntity object.		
		PostEntity postE = iServiceNowRecords.extractData(response);
		
		
		HttpHeaders headers0 = new HttpHeaders();
		
		headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2022");
		headers0.setContentType(MediaType.APPLICATION_JSON);
		
		URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
		
	    HttpEntity<PostEntity> entity = new HttpEntity<>(postE, headers0);
		
		ResponseEntity<String> response0 = restTemplate.postForEntity(uri0, entity, String.class);
		
		return response;
	}   
	   
}
