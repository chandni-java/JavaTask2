package com.test.grcpoc.ext.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;

@RestController

public class GRCPOCController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getrecords")
	public ResponseEntity<ServiceNowResource> getRecords() throws URISyntaxException {

		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("joel.nardo", "Jithu@1254");
		
		URI uri = new URI("https://dev141866.service-now.com/api/now/table/alm_asset?sysparm_limit=5");

		HttpEntity<String> request = new HttpEntity<String>(headers);

		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);

//		field f = new field();
//		
//		for (int i = 0; i < response.getBody().getResult().size(); i++) 
//		{
//			f.setDisplayName(response.getBody().getResult().get(i).getDisplay_name());
//			f.setTitle(response.getBody().getResult().get(i).getInstall_status());
//			f.setEmail(response.getBody().getResult().get(i).getSys_class_name());
//		}
//	
//			System.out.println("this is list " + f.toString());
//		
////=======================================================================================================================		
//		
//        HttpHeaders headers0 = new HttpHeaders();
//		
//		headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2022");
//		
//		URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
//		
//		HttpEntity<String> request0 = new HttpEntity<String>(headers0);
//		
//		ResponseEntity<fields> response0 = restTemplate.exchange(uri0, HttpMethod.POST, request0, fields.class);
//		
//		response0.getBody().getField();
		
		//return response;
	}
	
	@PostMapping("/postrecords")
	public void postRecords(@RequestBody fields fields) throws URISyntaxException
	{   
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2022");
		
		URI uri = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
        
		restTemplate.exchange(uri, HttpMethod.POST, request, fields.class);
	}
}
