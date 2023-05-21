package com.test.grcpoc.ext.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class fieldDefinitions {
	
	private ArrayList<fieldDefinition> fieldDefinition = new ArrayList<>();

	public ArrayList<fieldDefinition> getResourceFields() {
		return fieldDefinition;
	}

	public void setResourceFields(ArrayList<fieldDefinition> resourceFields) {
		this.fieldDefinition = resourceFields;
	}
	
	

}
