package com.test.grcpoc.ext.entity;

import java.util.ArrayList;

import lombok.Data;

@Data
public class fields {
	
	 private String typeDefinitionId;
	 private String primaryParentId;
	 private String name;
	 private String description;
	 private ArrayList<field> field;


	 // Getter Methods 

	 public ArrayList<field> getField() {
		return field;
	}

	public void setField(ArrayList<field> field) {
		this.field = field;
	}

	public String getTypeDefinitionId() {
	  return typeDefinitionId;
	 }

	 public String getPrimaryParentId() {
	  return primaryParentId;
	 }

	 public String getName() {
	  return name;
	 }

	 public String getDescription() {
	  return description;
	 }

	 // Setter Methods 

	 public void setTypeDefinitionId(String typeDefinitionId) {
	  this.typeDefinitionId = typeDefinitionId;
	 }

	 public void setPrimaryParentId(String primaryParentId) {
	  this.primaryParentId = primaryParentId;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }
	}

