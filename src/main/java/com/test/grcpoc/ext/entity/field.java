package com.test.grcpoc.ext.entity;

import lombok.Data;
@Data
public class field 
		{
		   private String name;
		   private String value;
		   private String dataType;
		   
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getDataType() {
			return dataType;
		}
		public void setDataType(String dataType) {
			this.dataType = dataType;
		}
		   
		
}
