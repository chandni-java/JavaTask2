package com.test.grcpoc.ext.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.result;
import com.test.grcpoc.ext.service.IServiceNowRecords;

@Controller
public class GRCPOCController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IServiceNowRecords iServiceNowRecords;

	//ResponseEntity<ServiceNowResource> response;
	
	@GetMapping("/testjsp")
	public String getJsp()
	{
//HttpHeaders headers = new HttpHeaders();
//		
//		headers.setBasicAuth("joel.nardo", "Jithu@1254");
//		
//		URI uri = new URI("https://dev141866.service-now.com/api/now/table/alm_asset?sysparm_limit=10");
//        
//		HttpEntity<String> request = new HttpEntity<String>(headers);
//        
//		 response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);
//        response.getBody().getResult().size();
		//return "NewFile3";
		return "welcome";
	}
	
	@RequestMapping("/result")
	public String getResult(ModelMap model,@RequestParam("records") Integer number) throws URISyntaxException 
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("admin", "VZb5joG5Rn-!");
		
		URI uri = new URI("https://dev158414.service-now.com/api/now/table/alm_asset?sysparm_limit="+number);
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		//ResponseEntity<ServiceNowResource> response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);
		
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(
		        uri,
		        HttpMethod.GET,
		        request,
		        new ParameterizedTypeReference<ServiceNowResource>(){}
		    );
		ArrayList<result> result = response.getBody().getResult();
		model.addAttribute("result",result);
		return "result";
	}
	
	@PostMapping(value = "/savedata", produces = MediaType.APPLICATION_JSON_VALUE)
	public void postResponseJsonContent(@ModelAttribute result loginForm) {
	    System.out.println(loginForm.getDelivery_date());
	}
	
//	@RequestMapping("/savedata")
//	//@RequestParam ("selectedItems") List<String> name
//	//@ModelAttribute ("selectedItems") result name,
//	public void saveData(@ModelAttribute ("ServiceNowResource") ServiceNowResource name)
//	{
//		//System.out.println(name[0]);
//		//System.out.println(name.getSys_class_name());
//		System.out.println("hello");
//	}
	
	//@RequestParam("records") Integer number
	@RequestMapping("/getassetsdata")
	public ResponseEntity<ServiceNowResource> getRecords(@RequestParam("records") Integer number) throws URISyntaxException, JsonProcessingException {
        
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("admin", "VZb5joG5Rn-!");
		
		URI uri = new URI("https://dev158414.service-now.com/api/now/table/alm_asset?sysparm_limit="+number);
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
        
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);
        response.getBody().getResult().size();
//      Calling a method and passing ResponseEntity as an argument in that method.
//      In return it is giving PostEntity object.		
        int ii = 0;
        for(int i = 0; i<response.getBody().getResult().size(); i++)
        {
	        ii++;
			PostEntity postE = iServiceNowRecords.extractData(response, i, ii);
			
			HttpHeaders headers0 = new HttpHeaders();
			
			headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
			headers0.setContentType(MediaType.APPLICATION_JSON);
			
			URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
			
		    HttpEntity<PostEntity> entity = new HttpEntity<>(postE, headers0);
			
			restTemplate.postForEntity(uri0, entity, String.class);
			
			System.out.println("doing good");
        }
		
		System.out.println("doing good!");
		
		return response;
	}   
	   
}
