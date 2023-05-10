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
	 
//	 @Bean
//	 public RestTemplate restTemplate(RestTemplateBuilder builder) {
//	     return builder.build();
//	 }
	
//	@Bean
//	public RestTemplate restTemplate() {
//	   final RestTemplate restTemplate = new RestTemplate();
//
//	   List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//	   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//	   converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//	   messageConverters.add(converter);
//	   restTemplate.setMessageConverters(messageConverters);
//
//	   return restTemplate;
//	}
	
}
