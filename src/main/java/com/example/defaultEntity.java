package com.example;

public class defaultEntity {
	public String customername;
	public String validitydate;
	public String payment;
	public int price;
	public defaultEntity(){}
	public defaultEntity(String customername, String validitydate, String payment, int price) {
	this.customername = customername;
	this.validitydate = validitydate;
	this.payment = payment;
	this.price = price;
	}
	public String getCustomername() {
	return customername;
	}
	public void setCustomername(String customername) {
	this.customername = customername;
	}
	public String getValiditydate() {
	return validitydate;
	}
	public void setValiditydate(String validitydate) {
	this.validitydate = validitydate;
	}
	public String getPayment() {
	return payment;
	}
	public void setPayment(String payment) {
	this.payment = payment;
	}
	public int getPrice() {
	return price;
	}
	public void setPrice(int price) {
	this.price = price;
	}
	
}
