package com.test.grcpoc.ext.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class result {
	
	//private String install_status;
	
	//private String sys_class_name;
	
	private String display_name;
	
//	private String invoice_number;
//	
//	private String delivery_date;
//	
//	private String retirement_date;
//	
//	private String purchase_date;
//	
//	private String depreciation_date;
//	
//	private String cost;
//	
//	private String quantity;
//	
//	private String serial_number;
//	
//	private String sys_mod_count;
//
	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
//
//
//	public String getInvoice_number() {
//		return invoice_number;
//	}
//
//	public void setInvoice_number(String invoice_number) {
//		this.invoice_number = invoice_number;
//	}
//
//	public String getDelivery_date() {
//		return delivery_date;
//	}
//
//	public void setDelivery_date(String delivery_date) {
//		this.delivery_date = delivery_date;
//	}
//
//	public String getRetirement_date() {
//		return retirement_date;
//	}
//
//	public void setRetirement_date(String retirement_date) {
//		this.retirement_date = retirement_date;
//	}
//
//	public String getPurchase_date() {
//		return purchase_date;
//	}
//
//	public void setPurchase_date(String purchase_date) {
//		this.purchase_date = purchase_date;
//	}
//
//	public String getDepreciation_date() {
//		return depreciation_date;
//	}
//
//	public void setDepreciation_date(String depreciation_date) {
//		this.depreciation_date = depreciation_date;
//	}
//
//
//	public String getCost() {
//		return cost;
//	}
//
//	public void setCost(String cost) {
//		this.cost = cost;
//	}
//
//
//	public String getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(String quantity) {
//		this.quantity = quantity;
//	}
//
//	public String getSys_mod_count() {
//		return sys_mod_count;
//	}
//
//	public void setSys_mod_count(String sys_mod_count) {
//		this.sys_mod_count = sys_mod_count;
//	}
//
//	public String getSerial_number() {
//		return serial_number;
//	}
//
//	public void setSerial_number(String serial_number) {
//		this.serial_number = serial_number;
//	}

}
