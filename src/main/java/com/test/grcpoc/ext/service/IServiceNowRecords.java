package com.test.grcpoc.ext.service;

import org.springframework.http.ResponseEntity;

import com.test.grcpoc.ext.entity.ServiceNowResource;

public interface IServiceNowRecords 
{

	void extractData(ResponseEntity<ServiceNowResource> response);
	
}
