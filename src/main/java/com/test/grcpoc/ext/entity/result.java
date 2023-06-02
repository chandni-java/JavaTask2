package com.test.grcpoc.ext.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class result {
	
	private String delivery_date;
	private String sys_id;
	private String display_name;
	private String sys_class_name;
	private String sys_mod_count;
	private String purchase_date;
	private Boolean isSelected;
	
	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getSys_class_name() {
		return sys_class_name;
	}

	public void setSys_class_name(String sys_class_name) {
		this.sys_class_name = sys_class_name;
	}


	public String getDelivery_date() {
		return delivery_date;
	}

	public String getSys_id() {
		return sys_id;
	}

	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getSys_mod_count() {
		return sys_mod_count;
	}

	public void setSys_mod_count(String sys_mod_count) {
		this.sys_mod_count = sys_mod_count;
	}

	@Override
	public String toString() {
		return sys_class_name + "," + sys_id + ","
				 + delivery_date + "," + purchase_date + ","
				 + display_name + "," + sys_mod_count+" ";
	}
}
