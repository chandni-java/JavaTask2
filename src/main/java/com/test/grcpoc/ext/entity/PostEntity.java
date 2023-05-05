package com.test.grcpoc.ext.entity;

import lombok.Data;
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PostEntity {
 
	 private String typeDefinitionId;
	 private String primaryParentId;
	 private String name;
	 private fields fields;
	 
	public String getTypeDefinitionId() {
		return typeDefinitionId;
	}
	public void setTypeDefinitionId(String typeDefinitionId) {
		this.typeDefinitionId = typeDefinitionId;
	}
	public String getPrimaryParentId() {
		return primaryParentId;
	}
	public void setPrimaryParentId(String primaryParentId) {
		this.primaryParentId = primaryParentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public fields getFields() {
		return fields;
	}
	public void setFields(fields fields) {
		this.fields = fields;
	}
	 
	 
	 

}