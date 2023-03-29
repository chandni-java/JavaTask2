package com.test.grcpoc.ext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JavaGrcPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGrcPocApplication.class, args);
	}
	
	 @Bean 
	 public RestTemplate restTemplate() 
	 { 
		 return new RestTemplate(); 
	 }
	
	/*
	 * @Bean RestOperations rest(RestTemplateBuilder restTemplateBuilder) { return
	 * restTemplateBuilder.basicAuthentication("joel.nardo", "Jithu@1254").build();
	 * }
	 */
	 
	 

}
