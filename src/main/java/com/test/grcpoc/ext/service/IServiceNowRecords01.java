package com.test.grcpoc.ext.service;

import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
@Component
public interface IServiceNowRecords01 
{
	PostEntity extractData01(ServiceNowResource snr, int i) throws URISyntaxException;
}
