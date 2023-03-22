package com.test.grcpoc.ext.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;
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
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
        
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);
        
		iServiceNowRecords.extractData(response);
		
		HttpHeaders headers0 = new HttpHeaders();
		
		headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2022");
		headers0.setContentType(MediaType.APPLICATION_JSON);
		
		URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
		
		//HttpEntity<String> request0 = new HttpEntity<String>(headers0);
		
		 //String objectString= mapper.writeValueAsString(postE);
         
	    // JsonNode jsonBody = mapper.readTree(objectString);
	     
	    HttpEntity<PostEntity> entity = new HttpEntity<>(postE, headers0);
		
		//ResponseEntity<PostEntity> response0 = restTemplate.exchange(uri0, HttpMethod.POST, entity, PostEntity.class);
		
		ResponseEntity<String> response0 = restTemplate.postForEntity(uri0, entity, String.class);
		
		System.out.println(postE.toString());
		
		return response;
	}   
	   
//	@RequestMapping(value = "/postrecords")
//	public void postRecords(@ModelAttribute fields postEntity) throws URISyntaxException
//	{   
//			HttpHeaders headers0 = new HttpHeaders();
//			
//			headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2022");
//			
//			URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
//			
//			HttpEntity<String> request0 = new HttpEntity<String>(headers0);
//			
//			fields f = new fields();
//			field ff0 = new field();
//			f.setTypeDefinitionId("Employee");
//			f.setName("employee 9");
//			f.setPrimaryParentId("12122");
//			f.setDescription("this is hard coded");
////			f.setDescription(fields.getDescription());
////			f.setName(fields.getName());
////			f.setTypeDefinitionId(fields.getTypeDefinitionId());
////			f.setPrimaryParentId(fields.getPrimaryParentId());
//			
//			ResponseEntity<fields> response0 = restTemplate.exchange(uri0, HttpMethod.POST, request0, fields.class);
//			
//			//System.out.println("this is description : " +response0.getBody().getField().get(0));
//	}
}
