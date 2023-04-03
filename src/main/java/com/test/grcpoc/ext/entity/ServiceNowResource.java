package com.test.grcpoc.ext.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ServiceNowResource 
{
		private ArrayList <result> result;

		public ArrayList<result> getResult() 
		{
			return result;
		}

		public void setResult(ArrayList<result> result) 
		{
			this.result = result;
		}
		 
		
		
}
