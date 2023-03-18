package com.test.grcpoc.ext.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class result {
	
	
	@SuppressWarnings("unused")
	public String install_status;
	
	@SuppressWarnings("unused")
	public String sys_class_name;
	
	@SuppressWarnings("unused")
	public String display_name;


	public String getInstall_status() {
		return install_status;
	}

	public void setInstall_status(String install_status) {
		this.install_status = install_status;
	}

	public String getSys_class_name() {
		return sys_class_name;
	}

	public void setSys_class_name(String sys_class_name) {
		this.sys_class_name = sys_class_name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
	
	
	
	
	
	
	
}
