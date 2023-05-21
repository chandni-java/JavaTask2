package com.test.grcpoc.ext.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class OpenPagesResource {
	
	private String name;
	
	private String localizedLabel;
	
	private fieldDefinitions fieldDefinitions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalizedLabel() {
		return localizedLabel;
	}

	public void setLocalizedLabel(String localizedLabel) {
		this.localizedLabel = localizedLabel;
	}

	public fieldDefinitions getFieldDef() {
		return fieldDefinitions;
	}

	public void setFieldDef(fieldDefinitions fieldDef) {
		this.fieldDefinitions = fieldDef;
	}
	
}
