package com.test.grcpoc.ext.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.grcpoc.ext.entity.AssetFormData;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.result;
import com.test.grcpoc.ext.service.IServiceNowRecords;
import com.test.grcpoc.ext.service.IServiceNowRecords01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import com.test.grcpoc.ext.entity.n.OpenPagesResource;

@Controller
public class GRCPOCController {
	
	@Autowired
	private IServiceNowRecords01 iServiceNowRecords01;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IServiceNowRecords iServiceNowRecords;
	
	@GetMapping("/testjsp")
	public String getJsp(HttpServletRequest request)
	{
		return "welcome";
	}
	
	@RequestMapping("/result")
	public String getResult(ModelMap model,@RequestParam("records") Integer number) throws URISyntaxException, MalformedURLException 
	//public String getResult(Integer number) throws URISyntaxException, MalformedURLException 
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("admin", "VZb5joG5Rn-!");
		
		URI uri = new URI("https://dev158414.service-now.com/api/now/table/alm_asset?sysparm_limit="+number);
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
//		  try { Thread.sleep(5000); } catch (InterruptedException e) {
//		  e.printStackTrace(); }
		 
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(
		        uri,
		        HttpMethod.GET,
		        request,
		        new ParameterizedTypeReference<ServiceNowResource>(){}
		    );
		
		ArrayList<result> result = response.getBody().getResult();
		ServiceNowResource snr = new ServiceNowResource();
		snr.setResult(result);
		
		model.addAttribute("snr",snr);
		return "resultjsp";
	}
	
	@RequestMapping("/savedata")
//	public String saveData(@RequestParam ("selectedItems") List<String> name,ModelMap model) throws URISyntaxException, JsonProcessingException
	//public String saveData(@RequestParam ("selectedItems") String[] name,ModelMap model) throws URISyntaxException, JsonProcessingException
	public String saveData(@ModelAttribute ServiceNowResource snr,ModelMap model) throws URISyntaxException, JsonProcessingException
	//public String saveData(@ModelAttribute result result, ModelMap model) throws URISyntaxException, JsonProcessingException
	{
		int noOfRecordsSaved = 0;
		List<result> existingRecords = new ArrayList<>();
	
		int ii = -1;
		for(int i = 0; i<snr.getResult().size(); i++)
		{
			 //To check if record with same name is present in IBM OpenPages Environment.
			
			String sys_Id = snr.getResult().get(i).getSys_id();
		        HttpHeaders headers01 = new HttpHeaders();
		        headers01.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
		        
		        URI uri01 = new URI("http://op83.timusconsulting.com:10108/grc/api/query?q=select*from[Resource]where[Resource].[Name]IN('"+sys_Id+"')");
			    HttpEntity<String> request01 = new HttpEntity<String>(headers01);
		        ResponseEntity<OpenPagesResource> response01 = restTemplate.exchange(
				        uri01,
				        HttpMethod.GET,
				        request01,
				        OpenPagesResource.class
				    );
		        
		        if(!response01.getBody().getRows().isEmpty())
		        {
		        	existingRecords.add(snr.getResult().get(i));
		        	continue;
		        }
			
			//Saving record in IBM Open Pages environment.
			ii++;
			PostEntity RecordsToBeSaved = iServiceNowRecords01.extractData01(snr,ii);
			
			HttpHeaders headers0 = new HttpHeaders();
			
			headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
			
			headers0.setContentType(MediaType.APPLICATION_JSON);
			
			URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
			
		    HttpEntity<PostEntity> entity = new HttpEntity<>(RecordsToBeSaved, headers0);
			
			restTemplate.postForEntity(uri0, entity, String.class);
			
			noOfRecordsSaved++;
		}
		
		if(!existingRecords.isEmpty())
		{
			model.addAttribute("noofrecordssaved", noOfRecordsSaved);
			model.addAttribute("sysid", existingRecords);
        	return "existingrecords";
		}
		
		model.addAttribute("noOfRecords", noOfRecordsSaved);
		return "done";
	}
	
	@RequestMapping("/getassetsdata")
	public ResponseEntity<ServiceNowResource> getRecords(@RequestParam("records") Integer number) throws URISyntaxException, JsonProcessingException {
        
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("admin", "VZb5joG5Rn-!");
		
		URI uri = new URI("https://dev158414.service-now.com/api/now/table/alm_asset?sysparm_limit="+number);
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
        
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(uri, HttpMethod.GET, request, ServiceNowResource.class);
        response.getBody().getResult().size();
////      Calling a method and passing ResponseEntity as an argument in that method.
////      In return it is giving PostEntity object.		
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
        }
		return response;
	}   
}
