package com.test.grcpoc.ext.entity;

import java.util.ArrayList;

import lombok.Data;
@Data
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class fields {
	
	 private ArrayList<field> field = new ArrayList<>();
	 
	
	public ArrayList<field> getField() {
		return field;
	}
	public void setField(ArrayList<field> field) {
		this.field = field;
	}
	}

