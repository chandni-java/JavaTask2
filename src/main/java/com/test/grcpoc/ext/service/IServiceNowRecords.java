package com.test.grcpoc.ext.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowArrayRecords;
import com.test.grcpoc.ext.entity.ServiceNowResource;

public interface IServiceNowRecords 
{

	ServiceNowArrayRecords extractData(ResponseEntity<ServiceNowResource> response);
	
}
