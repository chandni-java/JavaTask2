package com.test.grcpoc.ext.service;

import org.springframework.http.ResponseEntity;

import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;

public interface IServiceNowRecords 
{

	PostEntity extractData(ResponseEntity<ServiceNowResource> response);
	
}
