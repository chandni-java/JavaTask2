package com.test.grcpoc.ext.service;

import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.test.grcpoc.ext.entity.PostEntity;
@Component
public interface IServiceNowRecords01 
{
	PostEntity extractData01(String[] names) throws URISyntaxException;
}
