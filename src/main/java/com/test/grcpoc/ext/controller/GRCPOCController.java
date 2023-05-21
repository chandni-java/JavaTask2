package com.test.grcpoc.ext.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.result;
import com.test.grcpoc.ext.service.IServiceNowRecords;
import com.test.grcpoc.ext.service.IServiceNowRecords01;
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
	public String getJsp()
	{
		return "welcome";
	}
	
	@RequestMapping("/result")
	public String getResult(ModelMap model,@RequestParam("records") Integer number) throws URISyntaxException, MalformedURLException 
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.setBasicAuth("admin", "VZb5joG5Rn-!");
		
		URI uri = new URI("https://dev158414.service-now.com/api/now/table/alm_asset?sysparm_limit="+number);
        
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		ResponseEntity<ServiceNowResource> response = restTemplate.exchange(
		        uri,
		        HttpMethod.GET,
		        request,
		        new ParameterizedTypeReference<ServiceNowResource>(){}
		    );
		ArrayList<result> result = response.getBody().getResult();
		model.addAttribute("result",result);
		
//========================================================================================================
		HttpHeaders headers0 = new HttpHeaders();
        headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
		//[Name]LIKE'%"+result.get(0).getSys_id()+"%'"
		//URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/query?q=select*from[Resource]where[Resource].[Name]LIKE'%00a96c0d3790200044e0bfc8bcbe5dc3'");
        
//            URL url = new URL("http://op83.timusconsulting.com:10108/grc/api/query?q=select*from[Resource]where[Resource].[Name]IN('BANKDB1')");
//            URI uri0 = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery());
            URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/query?q=select[Resource].[Description]from[Resource]where[Resource].[Name]IN('BANKDB1')");
		    HttpEntity<String> request0 = new HttpEntity<String>(headers0);
            ResponseEntity<OpenPagesResource> response0 = restTemplate.exchange(
    		        uri0,
    		        HttpMethod.GET,
    		        request0,
    		        OpenPagesResource.class
    		    );
//        System.out.println("everything : " + response0.getBody().getRows().get(0).getFields().getField().get(0).getValue());
//        System.out.println("everything OK");
//        HttpEntity<String> request0 = new HttpEntity<String>(headers0);
		
//		ResponseEntity<com.test.grcpoc.ext.entity.n.OpenPagesResource> response0 = restTemplate.exchange(
//		        uri0,
//		        HttpMethod.GET,
//		        request0,
//		        new ParameterizedTypeReference<com.test.grcpoc.ext.entity.n.OpenPagesResource>(){}
//		    );
		
//		System.out.println("from OP : " + response0.getBody().getRows().get(0).getFields().getField().get(0).getName().toString());
//		
//		System.out.println("size : " + response0.getBody().getRows().get(0).getFields().getField().size());
//		
//		if(response.getBody().getResult().get(0).getSys_id().equals(response0.getBody().getRows().get(0).getFields().getField().get(0).getName().toString()))
//		{
//			
//		}
//=====================================================================================================
		return "resultjsp";
	}
	
	@RequestMapping("/savedata")
	public String saveData(@RequestParam ("selectedItems") List<String> name,ModelMap model) throws URISyntaxException, JsonProcessingException
	{
		
		for(int i = 0; i<name.size(); i++)
		{
			String s = name.get(i);
			
			String [] names = new String [8];
			String[] ar = s.split(",");
			
			int length = Math.min(ar.length, names.length);
	        System.arraycopy(ar, 0, names, 0, length);
	        
	        // Fill remaining empty slots with empty strings
	        for (int ii = length; ii < names.length; ii++) {
	            names[ii] = "";
	        }
//=====================================================================================================
	        String Sys_id = names[1];
	        HttpHeaders headers01 = new HttpHeaders();
	        headers01.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
	        
	        URI uri01 = new URI("http://op83.timusconsulting.com:10108/grc/api/query?q=select*from[Resource]where[Resource].[Name]IN('"+Sys_id+"')");
		    HttpEntity<String> request01 = new HttpEntity<String>(headers01);
	        ResponseEntity<OpenPagesResource> response01 = restTemplate.exchange(
			        uri01,
			        HttpMethod.GET,
			        request01,
			        OpenPagesResource.class
			    );
	        
	        if(response01.getBody().getRows()!=null)
	        {
	        	model.addAttribute("sysid", Sys_id);
	        	return "sysid";
	        }
//=======================================================================================================	        
			PostEntity PE =	iServiceNowRecords01.extractData01(names);
			
			HttpHeaders headers0 = new HttpHeaders();
			
			headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
			
			headers0.setContentType(MediaType.APPLICATION_JSON);
			
			URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/contents");
			
		    HttpEntity<PostEntity> entity = new HttpEntity<>(PE, headers0);
			
			restTemplate.postForEntity(uri0, entity, String.class);
		}
		
		System.out.println("hello");
		
		return "done";
	}
	
	//@RequestParam("records") Integer number
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
