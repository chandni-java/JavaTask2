package com.test.grcpoc.ext.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;

@Service
public class ServiceNowRecords implements IServiceNowRecords {

	@Override
	public PostEntity extractData(ResponseEntity<ServiceNowResource> response) {
		
		field f = new field();
		
		f.setName("OPSS-Emp:First Name");
		f.setValue(response.getBody().getResult().get(0).getDisplay_name());
		f.setDataType("STRING_TYPE");
		
		field f0 = new field();
		
		f0.setName("OPSS-Emp:Last Name");
		f0.setValue(response.getBody().getResult().get(0).getSys_class_name());
		f0.setDataType("STRING_TYPE");
		
		field f1 = new field();
		
		f1.setName("OPSS-Emp:Email");
		f1.setValue("sameer@gmail.com");
		f1.setDataType("STRING_TYPE");
		
		ArrayList<field> fieldAl = new ArrayList<>();
		fieldAl.add(f);
		fieldAl.add(f0);
		fieldAl.add(f1);
		
		fields fields = new fields();
		fields.setField(fieldAl);
		
		PostEntity postE = new PostEntity();
		
		postE.setName("Emp 25th mar");
		postE.setPrimaryParentId("12122");
		postE.setTypeDefinitionId("Employee");
		postE.setFields(fields);
		
		return postE;
	}

}
