package com.test.grcpoc.ext.service;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.ServiceNowResource;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;
@Service
public class ServiceNowRecords01 implements IServiceNowRecords01 {
	@Override
	public PostEntity extractData01(ServiceNowResource snr, int i) throws URISyntaxException {
        
				field f = new field();
				f.setName("ServiceNow Field Group:Snow Description");
				f.setValue(snr.getResult().get(i).getDelivery_date());
				f.setDataType("STRING_TYPE");
				
				field f1 = new field();
				f1.setName("ServiceNow Field Group:Snow Additional Description");
				f1.setValue(snr.getResult().get(i).getPurchase_date());
				f1.setDataType("STRING_TYPE");
				
				field f2 = new field();
				f2.setName("OPSS-Res:Technical Support 1");
				f2.setValue(snr.getResult().get(i).getSys_mod_count());
				f2.setDataType("STRING_TYPE");
				
				field f3 = new field();
				f3.setName("OPSS-Res:Technical Support 2");
				f3.setValue(snr.getResult().get(i).getSys_class_name());
				f3.setDataType("STRING_TYPE");
				
				field f6 = new field();
				f6.setName("IntegrationWKC:Project ID");
				f6.setValue(snr.getResult().get(i).getDisplay_name());
				f6.setDataType("STRING_TYPE");
				
				field f7 = new field();
				f7.setName("ServiceNow Field Group:Snow Test Field");
				f7.setValue(snr.getResult().get(i).getSys_class_name());
				f7.setDataType("STRING_TYPE");
		
		ArrayList<field> fieldAl = new ArrayList<>();
		fieldAl.add(f);
		fieldAl.add(f1);
		fieldAl.add(f2);
		fieldAl.add(f3);
		fieldAl.add(f6);
		fieldAl.add(f7);
		
		fields fields = new fields();
		fields.setField(fieldAl);
		
		PostEntity postE = new PostEntity();
		postE.setName(snr.getResult().get(i).getSys_id());
		postE.setPrimaryParentId("8464");
		postE.setTypeDefinitionId("Resource");
		postE.setFields(fields);
		
	    return postE;
	}
	
	public String mapper(String serviceNowField, String openPagesField, String dataType)
	{
		return "";
	}

}
