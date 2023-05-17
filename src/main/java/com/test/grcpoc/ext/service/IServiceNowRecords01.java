package com.test.grcpoc.ext.service;

import org.springframework.stereotype.Component;

import com.test.grcpoc.ext.entity.PostEntity;
@Component
public interface IServiceNowRecords01 
{
	PostEntity extractData01(String string, int ii);
}
