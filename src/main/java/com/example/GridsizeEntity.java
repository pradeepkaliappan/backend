package com.example;

public class GridsizeEntity {
	public int id;
	public String product;
    public String description;
    public int orderedquantity;
    public String uom;
    public String analyticTags;
    public int unitPrice;
    public int taxes;
    public int subtotal;
    public int total;
    public String date;
    public int overalltotal;
    
    public GridsizeEntity(int id,String product, String description,int orderedquantity,String uom,String analyticTags,int unitPrice,int taxes,int subtotal,int total,String date,int overalltotal) {
    	this.id = id;
    	this.product = product;
    	this.description = description;
    	this.orderedquantity = orderedquantity;
    	this.uom = uom;
    	this.analyticTags = analyticTags;
    	this.unitPrice = unitPrice;
    	this.taxes = taxes;
    	this.subtotal = subtotal;
    	this.total = total;
    	this.date = date;
    	this.overalltotal = overalltotal;
    	}
    public int getId() {
    	return id;
    	}
    	public void setId(int id) {
    	this.id = id;
    	}
    	public String getProduct() {
    	return product;
    	}
    	public void setProduct(String product) {
    	this.product = product;
    	}
    	public String getDescription() {
    	return description;
    	}
    	public void setDescription(String description) {
    	this.description = description;
    	}
    	public int getOrderedquantity() {
    	return orderedquantity;
    	}
    	public void setOrderedquantity(int orderedquantity) {
    	this.orderedquantity = orderedquantity;
    	}
    	public String getUom() {
    	return uom;
    	}
    	public void setUom(String uom) {
    	this.uom = uom;
    	}
    	public String getAnalyticTags() {
        	return analyticTags;
        	}
        	public void setAnalyticTags(String analyticTags) {
        	this.analyticTags = analyticTags;
        	}
        	public int getTaxes() {
            	return taxes;
            	}
            	public void setTaxes(int taxes) {
            	this.taxes = taxes;
            	}
            	public int getUnitPrice() {
                	return unitPrice;
                	}
                	public void setUnitPrice(int unitPrice) {
                	this.unitPrice = unitPrice;
                	}
                	public int getSubtotal() {
                    	return subtotal;
                    	}
                    	public void setSubtotal(int subtotal) {
                    	this.subtotal = subtotal;
                    	}
                    	public int getTotal() {
                        	return total;
                        	}
                        	public void setTotal(int total) {
                        	this.total = total;
                        	}
                        	public String getDate() {
                            	return date;
                            	}
                            	public void setDate(String date) {
                            	this.date = date;
                            	}
                            	public int getoveralltotal() {
                                	return overalltotal;
                                	}
                                	public void setoveralltotal(int overalltotal) {
                                	this.overalltotal = overalltotal;
                                	}

}
