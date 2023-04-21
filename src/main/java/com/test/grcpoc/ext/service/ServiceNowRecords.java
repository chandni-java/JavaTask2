package com.test.grcpoc.ext.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;

@Service
public class ServiceNowRecords implements IServiceNowRecords {

	@Override
	public PostEntity extractData(ResponseEntity<ServiceNowResource> response, int i, int ii)
	{
		return mapper(response,i,ii);
	}
	
	public static PostEntity mapper(ResponseEntity<ServiceNowResource> response, int i, int ii)
	{
		field f = new field();
		f.setName("ServiceNow Field Group:Snow Description");
		f.setValue(response.getBody().getResult().get(i).getInvoice_number());
		f.setDataType("STRING_TYPE");
		
		field f1 = new field();
		f1.setName("ServiceNow Field Group:Snow Additional Description");
		f1.setValue(response.getBody().getResult().get(i).getDelivery_date());
		f1.setDataType("STRING_TYPE");
		
		field f2 = new field();
		f2.setName("OPSS-Res:Technical Support 1");
		f2.setValue(response.getBody().getResult().get(i).getRetirement_date());
		f2.setDataType("STRING_TYPE");
		
		field f3 = new field();
		f3.setName("OPSS-Res:Technical Support 2");
		f3.setValue(response.getBody().getResult().get(i).getDepreciation_date());
		f3.setDataType("STRING_TYPE");
		
		
		field f6 = new field();
		f6.setName("IntegrationWKC:Project ID");
		f6.setValue(response.getBody().getResult().get(i).getSerial_number());
		f6.setDataType("STRING_TYPE");
		
		field f7 = new field();
		f7.setName("ServiceNow Field Group:Resource Recovery Time");
		f7.setValue(response.getBody().getResult().get(i).getSys_mod_count());
		f7.setDataType("STRING_TYPE");
		
		ArrayList<field> fieldAl = new ArrayList<>();
		fieldAl.add(f);
		fieldAl.add(f1);
		fieldAl.add(f2);
		fieldAl.add(f3);
		fieldAl.add(f6);//.
		fieldAl.add(f7);
		
		fields fields = new fields();
		fields.setField(fieldAl);
		
		PostEntity postE = new PostEntity();
		postE.setName("SnowR " + ii +" "+response.getBody().getResult().get(i).getDisplay_name());
		postE.setPrimaryParentId("34227");
		postE.setTypeDefinitionId("Resource");
		postE.setFields(fields);
		
	    return postE;
	}
}
