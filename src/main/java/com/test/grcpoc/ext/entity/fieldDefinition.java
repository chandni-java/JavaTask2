package com.test.grcpoc.ext.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class fieldDefinition {
	
	private String id;
	
	private String name;
	
	private String localizedLabel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
}
