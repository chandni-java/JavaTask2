package com.test.grcpoc.ext.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;
@Service
public class ServiceNowRecords01 implements IServiceNowRecords01 {

	@Override
	public PostEntity extractData01(String s, int ii) {
		String [] names = new String [8];
		String[] ar = s.split(",");
		
		int length = Math.min(ar.length, names.length);
        System.arraycopy(ar, 0, names, 0, length);
        
        // Fill remaining empty slots with empty strings
        for (int i = length; i < names.length; i++) {
            names[i] = "";
        }
        
				field f = new field();
				f.setName("ServiceNow Field Group:Snow Description");
				f.setValue(names[2]);
				f.setDataType("STRING_TYPE");
				
				field f1 = new field();
				f1.setName("ServiceNow Field Group:Snow Additional Description");
				f1.setValue(names[3]);
				f1.setDataType("STRING_TYPE");
				
				field f2 = new field();
				f2.setName("OPSS-Res:Technical Support 1");
				f2.setValue(names[4]);
				f2.setDataType("STRING_TYPE");
				
				field f3 = new field();
				f3.setName("OPSS-Res:Technical Support 2");
				f3.setValue(names[6]);
				f3.setDataType("STRING_TYPE");
				
				field f6 = new field();
				f6.setName("IntegrationWKC:Project ID");
				f6.setValue(names[7]);
				
				field f7 = new field();
				f7.setName("ServiceNow Field Group:Snow Test Field");
				f7.setValue("test");
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
		postE.setName("SnowR " + ii +" "+names[1]);
		postE.setPrimaryParentId("9601");
		postE.setTypeDefinitionId("Resource");
		postE.setFields(fields);
		
	    return postE;
	}

}
