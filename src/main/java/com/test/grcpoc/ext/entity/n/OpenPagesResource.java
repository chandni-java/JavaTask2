package com.test.grcpoc.ext.entity.n;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
@Data
public class OpenPagesResource {
	
	ArrayList<rows> rows = new ArrayList<>();

	public ArrayList<rows> getRows() {
		return rows;
	}

	public void setRows(ArrayList<rows> rows) {
		this.rows = rows;
	}


}
