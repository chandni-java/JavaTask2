package com.test.grcpoc.ext.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.grcpoc.ext.entity.PostEntity;
import com.test.grcpoc.ext.entity.field;
import com.test.grcpoc.ext.entity.fields;
import com.test.grcpoc.ext.entity.n.OpenPagesResource;
@Service
public class ServiceNowRecords01 implements IServiceNowRecords01 {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public PostEntity extractData01(String[] names) throws URISyntaxException {
        
        String SysClassName = names[0];
        String Sys_id = names[1];
        String DisplayName = names[2];
        String DeliveryDate = names[3];
        String PurchaseDate = names[4];
        String DepreciationDate = names[5];
        String SerialNumber = names[6];
        String SysModCount = names[7];
// ==================================================================================================    
//        HttpHeaders headers0 = new HttpHeaders();
//        headers0.setBasicAuth("sameer.diwse@timusconsulting.com", "Timus@2023");
//        
//        URI uri0 = new URI("http://op83.timusconsulting.com:10108/grc/api/query?q=select*from[Resource]where[Resource].[Name]IN('"+Sys_id+"')");
//	    HttpEntity<String> request0 = new HttpEntity<String>(headers0);
//        ResponseEntity<OpenPagesResource> response0 = restTemplate.exchange(
//		        uri0,
//		        HttpMethod.GET,
//		        request0,
//		        OpenPagesResource.class
//		    );
        
        
// =======================================================================================================       
				field f = new field();
				f.setName("ServiceNow Field Group:Snow Description");
				f.setValue(DeliveryDate);
				f.setDataType("STRING_TYPE");
				
				field f1 = new field();
				f1.setName("ServiceNow Field Group:Snow Additional Description");
				f1.setValue(PurchaseDate);
				f1.setDataType("STRING_TYPE");
				
				field f2 = new field();
				f2.setName("OPSS-Res:Technical Support 1");
				f2.setValue(DepreciationDate);
				f2.setDataType("STRING_TYPE");
				
				field f3 = new field();
				f3.setName("OPSS-Res:Technical Support 2");
				f3.setValue(SysModCount);
				f3.setDataType("STRING_TYPE");
				
				field f6 = new field();
				f6.setName("IntegrationWKC:Project ID");
				f6.setValue(SerialNumber);
				f6.setDataType("STRING_TYPE");
				
				field f7 = new field();
				f7.setName("ServiceNow Field Group:Snow Test Field");
				f7.setValue(SysClassName);
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
		postE.setName(Sys_id);
		postE.setPrimaryParentId("8464");
		postE.setTypeDefinitionId("Resource");
		postE.setFields(fields);
		
	    return postE;
	}

}
