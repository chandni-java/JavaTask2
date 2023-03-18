package com.test.grcpoc.ext.entity;

import lombok.Data;

@Data
public class field 
		{
		   private String Title;
		   private String Email;
		   private String DisplayName;
		   
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getDisplayName() {
			return DisplayName;
		}
		public void setDisplayName(String displayName) {
			DisplayName = displayName;
		}
		   
		   
}
