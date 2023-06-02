package com.test.grcpoc.ext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	 
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	     binder.setAutoGrowCollectionLimit(1000);
	 }
	 
}
