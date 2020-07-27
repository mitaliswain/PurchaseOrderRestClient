package com.mitali.purchaseorder.proxy.domain;

import lombok.ToString;

@ToString
public class SkuQuantity {
	
	Sku sku;
	Integer quantity;
	
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
