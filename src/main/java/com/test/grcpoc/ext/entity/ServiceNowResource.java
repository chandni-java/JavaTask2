package com.test.grcpoc.ext.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ServiceNowResource 
{

		private ArrayList <result> result = new ArrayList<result>();

		public ArrayList<result> getResult() 
		{
			return result;
		}

		public void setResult(ArrayList<result> result) 
		{
			this.result = result;
		}

		@Override
		public String toString() {
			return "ServiceNowResource [result=" + result + "]";
		}
}
