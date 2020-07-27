package com.mitali.purchaseorder.proxy.domain;

import lombok.ToString;

@ToString
public class Sku {
	
	String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
